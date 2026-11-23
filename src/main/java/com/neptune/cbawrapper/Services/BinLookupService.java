package com.neptune.cbawrapper.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.neptune.cbawrapper.Models.BinLookup;
import com.neptune.cbawrapper.Models.PosTransactionIssuerBank;
import com.neptune.cbawrapper.Models.PosTransactionIssuerBankDaily;
import com.neptune.cbawrapper.Repository.BinLookupRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.TransactionRequestSchema;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * Tracks card health per issuing bank and card scheme from pos_transaction_requests.
 *
 * For each new card transaction, the BIN (first 6 or 8 clear digits of the masked PAN, e.g.
 * "539941******9379") is looked up on binlist.io to get the issuing bank and scheme. The
 * transaction is then counted as successful (responseCode "00" and not reversed) or failed on:
 *  - pos_transaction_issuer_banks: one record per bank + scheme, all-time totals
 *  - pos_transaction_issuer_bank_daily: one record per day + bank + scheme
 * and the successRate / status of both are recalculated. pos_transaction_requests is only read.
 * Transactions whose bank can't be identified (BIN unknown to binlist.io, or fewer than 6 clear
 * PAN digits) are skipped and logged, not counted. Bank names are normalized so variants of one
 * bank's name are counted as one bank (see normalizeBankName).
 *
 * Each transaction is counted once: a checkpoint in job_checkpoints holds the last
 * pos_transaction_requests _id counted, and a run only applies its counts after moving the
 * checkpoint forward atomically, so two app instances cannot count the same batch.
 * BIN results are cached in bin_lookups, so each BIN hits the API once. If binlist.io is
 * rate-limited or down, the batch is cut at that transaction and resumes on the next run.
 */
@Service
public class BinLookupService {

    private static final Logger log = LoggerFactory.getLogger(BinLookupService.class);

    public static final String STATUS_HEALTHY = "HEALTHY";
    public static final String STATUS_DEGRADED = "DEGRADED";
    public static final String STATUS_DOWN = "DOWN";
    public static final String UNKNOWN = "UNKNOWN";

    private static final String CHECKPOINT_COLLECTION = "job_checkpoints";
    private static final String CHECKPOINT_ID = "pos_transaction_issuer_banks";
    private static final String CHECKPOINT_FIELD = "lastTransactionId";

    private final MongoTemplate mongoTemplate;
    private final BinLookupRepository binLookupRepository;
    private final RestTemplate restTemplate;

    @Value("${binlist.enabled:true}")
    private boolean enabled;

    @Value("${binlist.url:https://binlist.io/lookup/}")
    private String binlistUrl;

    @Value("${binlist.batch-size:200}")
    private int batchSize;

    // Pause between API calls so we stay under binlist.io's rate limit.
    @Value("${binlist.request-delay-ms:1000}")
    private long requestDelayMs;

    // successRate at or above this is HEALTHY
    @Value("${binlist.health.healthy-threshold:95}")
    private double healthyThreshold;

    // successRate at or above this (and below healthy) is DEGRADED; below it is DOWN
    @Value("${binlist.health.degraded-threshold:80}")
    private double degradedThreshold;

    public BinLookupService(MongoTemplate mongoTemplate, BinLookupRepository binLookupRepository) {
        this.mongoTemplate = mongoTemplate;
        this.binLookupRepository = binLookupRepository;
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10_000);
        factory.setReadTimeout(15_000);
        this.restTemplate = new RestTemplate(factory);
    }

    /** Thrown when the API cannot be used right now (rate limit, outage, timeout). */
    private static class BinApiUnavailableException extends RuntimeException {
        BinApiUnavailableException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /** Success / failure counts for one bank + scheme (and optionally one day) within a batch. */
    private static class Tally {
        final String issuerBank;
        final String scheme;
        final String date;
        long successful;
        long failed;

        Tally(String issuerBank, String scheme, String date) {
            this.issuerBank = issuerBank;
            this.scheme = scheme;
            this.date = date;
        }
    }

    @Scheduled(cron = "${binlist.cron:0 */2 * * * *}")
    public void updateIssuerBankHealth() {
        if (!enabled) {
            return;
        }
        try {
            int counted = processBatch();
            if (counted > 0) {
                log.info("Issuer bank health: counted {} card transaction(s)", counted);
            }
        } catch (Exception e) {
            log.error("Issuer bank health run failed: {}", e.getMessage(), e);
        }
    }

    /**
     * Counts the next batch of card transactions after the checkpoint, in _id order.
     *
     * @return the number of transactions counted
     */
    public int processBatch() {
        ObjectId checkpoint = readCheckpoint();

        Criteria criteria = Criteria.where("pan").nin(null, "")
                // Transfers are logged here too, with intra_ / inter_ references; they are not card transactions.
                .and("reference").not().regex("^(intra_|inter_)");
        if (checkpoint != null) {
            criteria = criteria.and("_id").gt(checkpoint);
        }
        Query query = new Query(criteria)
                .with(Sort.by(Sort.Direction.ASC, "_id"))
                .limit(batchSize);
        query.fields().include("_id", "pan", "cardScheme", "responseCode", "reversal", "created_at");

        List<TransactionRequestSchema> pending = mongoTemplate.find(query, TransactionRequestSchema.class);
        if (pending.isEmpty()) {
            return 0;
        }

        // 1. Resolve banks. Stop at the first API failure so the batch stays a contiguous run of _ids.
        Map<String, Tally> allTime = new LinkedHashMap<>();
        Map<String, Tally> daily = new LinkedHashMap<>();
        Map<String, Optional<BinLookup>> resolvedThisRun = new HashMap<>();
        String lastProcessedId = null;
        int counted = 0;
        // Transactions whose bank or scheme can't be identified are skipped, not stored as UNKNOWN.
        Map<String, Integer> skipped = new LinkedHashMap<>();
        for (TransactionRequestSchema tx : pending) {
            Optional<BinLookup> lookup = Optional.empty();
            String bin = extractBin(tx.getPan());
            if (bin != null) {
                try {
                    lookup = resolve(bin, resolvedThisRun);
                } catch (BinApiUnavailableException e) {
                    log.warn("BIN lookup paused, will resume on next run: {}", e.getMessage());
                    break;
                }
            }
            lastProcessedId = tx.getId();
            String issuerBank = normalizeBankName(lookup.map(BinLookup::getBankName).orElse(null));
            String scheme = normalizeScheme(lookup.map(BinLookup::getScheme).orElse(null), tx.getCardScheme());
            if (issuerBank == null || scheme == null) {
                skipped.merge(bin != null ? bin : "invalid PAN " + tx.getPan(), 1, Integer::sum);
                continue;
            }
            boolean success = isSuccessful(tx);
            String date = transactionDate(tx);

            tally(allTime, key(issuerBank, scheme), issuerBank, scheme, null, success);
            tally(daily, date + "|" + key(issuerBank, scheme), issuerBank, scheme, date, success);
            counted++;
        }
        if (lastProcessedId == null) {
            return 0;
        }
        if (!skipped.isEmpty()) {
            log.warn("Issuer bank health: skipped transactions with no identifiable bank (BIN=count): {}", skipped);
        }

        // 2. Claim the batch by moving the checkpoint. If another instance moved it first, it owns these.
        if (!advanceCheckpoint(checkpoint, new ObjectId(lastProcessedId))) {
            log.info("Issuer bank health: batch already counted by another instance, skipping");
            return 0;
        }

        // 3. Apply the counts.
        String now = ZonedDateTime.now().toString();
        for (Map.Entry<String, Tally> e : allTime.entrySet()) {
            applyTally(e.getKey(), e.getValue(), PosTransactionIssuerBank.class, now);
        }
        for (Map.Entry<String, Tally> e : daily.entrySet()) {
            applyTally(e.getKey(), e.getValue(), PosTransactionIssuerBankDaily.class, now);
        }
        return counted;
    }

    /** Same rule as the reports: approved (00) and not reversed. */
    static boolean isSuccessful(TransactionRequestSchema tx) {
        return "00".equals(tx.getResponseCode()) && !Boolean.TRUE.equals(tx.getReversal());
    }

    /** Percentage with one decimal place; 0 when there are no transactions. */
    public static double successRate(long successful, long total) {
        if (total <= 0) {
            return 0;
        }
        return BigDecimal.valueOf(successful * 100.0 / total).setScale(1, RoundingMode.HALF_UP).doubleValue();
    }

    public String healthStatus(double successRate) {
        if (successRate >= healthyThreshold) {
            return STATUS_HEALTHY;
        }
        if (successRate >= degradedThreshold) {
            return STATUS_DEGRADED;
        }
        return STATUS_DOWN;
    }

    private static String key(String issuerBank, String scheme) {
        return issuerBank + "|" + scheme;
    }

    /**
     * One name per bank, so variants returned by binlist.io for different BINs are counted together:
     * upper case, single spaces, without a trailing "(NIGERIA)"-style suffix or legal suffix.
     * "United Bank for Africa PLC (Nigeria)" and "UNITED BANK FOR AFRICA PLC" both become
     * "UNITED BANK FOR AFRICA". Returns null when there is no name.
     */
    public static String normalizeBankName(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }
        String n = name.trim().replaceAll("\\s+", " ").toUpperCase(Locale.ROOT);
        String previous;
        do {
            previous = n;
            n = n.replaceAll("\\s*\\([^)]*\\)$", "")      // trailing "(NIGERIA)"
                    .replaceAll("[\\s,.]+$", "")              // trailing punctuation
                    .replaceAll("\\s+(PLC|LIMITED|LTD)$", ""); // trailing legal suffix
        } while (!n.equals(previous));
        return n.isEmpty() || UNKNOWN.equals(n) ? null : n;
    }

    /** Scheme from binlist.io, else the scheme the terminal reported; null when neither is known. */
    static String normalizeScheme(String binlistScheme, String terminalScheme) {
        for (String value : new String[]{binlistScheme, terminalScheme}) {
            if (value != null && !value.isBlank()) {
                String s = value.trim().replaceAll("\\s+", " ").toUpperCase(Locale.ROOT);
                if (!UNKNOWN.equals(s)) {
                    return s;
                }
            }
        }
        return null;
    }

    /** yyyy-MM-dd of the transaction: from created_at, else from the _id timestamp. */
    private static String transactionDate(TransactionRequestSchema tx) {
        String createdAt = tx.getCreated_at();
        if (createdAt != null && createdAt.length() >= 10 && createdAt.substring(0, 10).matches("\\d{4}-\\d{2}-\\d{2}")) {
            return createdAt.substring(0, 10);
        }
        if (ObjectId.isValid(tx.getId())) {
            return LocalDate.ofInstant(new ObjectId(tx.getId()).getDate().toInstant(), ZoneId.systemDefault()).toString();
        }
        return LocalDate.now().toString();
    }

    private static void tally(Map<String, Tally> tallies, String key, String issuerBank, String scheme,
                              String date, boolean success) {
        Tally t = tallies.computeIfAbsent(key, k -> new Tally(issuerBank, scheme, date));
        if (success) {
            t.successful++;
        } else {
            t.failed++;
        }
    }

    /** Adds a tally to its record (creating it on first sight), then recalculates rate and status. */
    private void applyTally(String id, Tally t, Class<?> entity, String now) {
        Query byId = new Query(Criteria.where("_id").is(id));
        Update increment = new Update()
                .inc("successfulTransactions", t.successful)
                .inc("failedTransactions", t.failed)
                .inc("totalTransactions", t.successful + t.failed)
                .setOnInsert("issuerBank", t.issuerBank)
                .setOnInsert("scheme", t.scheme);
        if (t.date != null) {
            increment.setOnInsert("date", t.date);
        } else {
            increment.setOnInsert("created_at", now);
        }
        Document updated = mongoTemplate.findAndModify(byId, increment,
                FindAndModifyOptions.options().upsert(true).returnNew(true),
                Document.class, mongoTemplate.getCollectionName(entity));
        if (updated == null) {
            return;
        }
        long successful = ((Number) updated.getOrDefault("successfulTransactions", 0L)).longValue();
        long total = ((Number) updated.getOrDefault("totalTransactions", 0L)).longValue();
        double rate = successRate(successful, total);
        mongoTemplate.updateFirst(byId, new Update()
                        .set("successRate", rate)
                        .set("status", healthStatus(rate))
                        .set("lastChecked", now),
                entity);
    }

    private ObjectId readCheckpoint() {
        Document doc = mongoTemplate.findById(CHECKPOINT_ID, Document.class, CHECKPOINT_COLLECTION);
        if (doc == null) {
            return null;
        }
        Object value = doc.get(CHECKPOINT_FIELD);
        return value instanceof ObjectId ? (ObjectId) value : null;
    }

    /** Moves the checkpoint from {@code expected} to {@code next}; false if someone else moved it first. */
    private boolean advanceCheckpoint(ObjectId expected, ObjectId next) {
        String now = ZonedDateTime.now().toString();
        if (expected == null) {
            try {
                mongoTemplate.insert(new Document("_id", CHECKPOINT_ID)
                        .append(CHECKPOINT_FIELD, next)
                        .append("updated_at", now), CHECKPOINT_COLLECTION);
                return true;
            } catch (DuplicateKeyException e) {
                return false;
            }
        }
        Query query = new Query(Criteria.where("_id").is(CHECKPOINT_ID).and(CHECKPOINT_FIELD).is(expected));
        Update update = new Update().set(CHECKPOINT_FIELD, next).set("updated_at", now);
        return mongoTemplate.updateFirst(query, update, CHECKPOINT_COLLECTION).getModifiedCount() == 1;
    }

    /**
     * Returns the leading clear digits of a masked PAN: 8 if available, else 6.
     * Returns null when fewer than 6 leading digits are present.
     */
    static String extractBin(String pan) {
        if (pan == null) {
            return null;
        }
        String trimmed = pan.trim();
        int i = 0;
        while (i < trimmed.length() && Character.isDigit(trimmed.charAt(i))) {
            i++;
        }
        if (i >= 8) {
            return trimmed.substring(0, 8);
        }
        if (i >= 6) {
            return trimmed.substring(0, 6);
        }
        return null;
    }

    /**
     * Resolves a BIN to a found lookup. An 8-digit BIN that binlist.io does not know
     * falls back to its 6-digit prefix.
     */
    private Optional<BinLookup> resolve(String bin, Map<String, Optional<BinLookup>> resolvedThisRun) {
        BinLookup lookup = lookupCached(bin, resolvedThisRun);
        if (lookup.isFound()) {
            return Optional.of(lookup);
        }
        if (bin.length() == 8) {
            BinLookup shortLookup = lookupCached(bin.substring(0, 6), resolvedThisRun);
            if (shortLookup.isFound()) {
                return Optional.of(shortLookup);
            }
        }
        return Optional.empty();
    }

    private BinLookup lookupCached(String bin, Map<String, Optional<BinLookup>> resolvedThisRun) {
        Optional<BinLookup> local = resolvedThisRun.get(bin);
        if (local != null && local.isPresent()) {
            return local.get();
        }
        Optional<BinLookup> cached = binLookupRepository.findById(bin);
        if (cached.isPresent()) {
            resolvedThisRun.put(bin, cached);
            return cached.get();
        }
        BinLookup fetched = fetchFromApi(bin);
        binLookupRepository.save(fetched);
        resolvedThisRun.put(bin, Optional.of(fetched));
        return fetched;
    }

    private BinLookup fetchFromApi(String bin) {
        throttle();
        JsonNode body;
        try {
            body = restTemplate.getForObject(binlistUrl + bin + "/", JsonNode.class);
        } catch (HttpClientErrorException.NotFound e) {
            return notFound(bin);
        } catch (RestClientException e) {
            // 429, 5xx, timeouts, DNS errors: transient, retry on the next run.
            throw new BinApiUnavailableException("binlist.io request for " + bin + " failed: " + e.getMessage(), e);
        }

        BinLookup lookup = new BinLookup();
        lookup.setBin(bin);
        lookup.setCheckedAt(ZonedDateTime.now().toString());
        String bankName = body == null ? null : text(body.path("bank").path("name"));
        // binlist.io answers HTTP 200 with "success": false for unknown BINs.
        boolean found = body != null && body.path("success").asBoolean(false) && bankName != null;
        lookup.setFound(found);
        if (body != null) {
            lookup.setBankName(bankName);
            lookup.setScheme(text(body.path("scheme")));
            lookup.setCardType(text(body.path("type")));
            lookup.setCategory(text(body.path("category")));
            lookup.setCountryCode(text(body.path("country").path("alpha2")));
            lookup.setCountryName(text(body.path("country").path("name")));
        }
        return lookup;
    }

    private BinLookup notFound(String bin) {
        BinLookup lookup = new BinLookup();
        lookup.setBin(bin);
        lookup.setFound(false);
        lookup.setCheckedAt(ZonedDateTime.now().toString());
        return lookup;
    }

    private static String text(JsonNode node) {
        if (node == null || node.isMissingNode() || node.isNull()) {
            return null;
        }
        String value = node.asText().trim();
        return value.isEmpty() ? null : value;
    }

    private void throttle() {
        if (requestDelayMs <= 0) {
            return;
        }
        try {
            Thread.sleep(requestDelayMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new BinApiUnavailableException("interrupted", e);
        }
    }
}
