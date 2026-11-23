package com.neptune.cbawrapper.Controllers;

import com.neptune.cbawrapper.Models.PosTransactionIssuerBank;
import com.neptune.cbawrapper.Models.PosTransactionIssuerBankDaily;
import com.neptune.cbawrapper.Repository.PosTransactionIssuerBankRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.IssuerBankHealth;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import com.neptune.cbawrapper.Services.BinLookupService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Card health per issuing bank and card scheme, from pos_transaction_issuer_banks (all time)
 * or pos_transaction_issuer_bank_daily (when a date range is given).
 */
@RestController
@RequestMapping("/api/v1/card-issuers")
public class CardIssuerController {

    private final PosTransactionIssuerBankRepository issuerBankRepository;
    private final MongoTemplate mongoTemplate;
    private final BinLookupService binLookupService;

    public CardIssuerController(PosTransactionIssuerBankRepository issuerBankRepository, MongoTemplate mongoTemplate,
                                BinLookupService binLookupService) {
        this.issuerBankRepository = issuerBankRepository;
        this.mongoTemplate = mongoTemplate;
        this.binLookupService = binLookupService;
    }

    /**
     * One entry per issuing bank, each with its card schemes and their success rate and status.
     *
     * Without dates: all-time totals. With startDate and/or endDate (yyyy-MM-dd, both inclusive):
     * totals for transactions on those days only, e.g. ?startDate=2026-11-20&endDate=2026-11-20 for one day.
     * Optional bankName / scheme filters match case-insensitively on part of the name.
     */
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<ResponseSchema<?>> health(@RequestParam(required = false) String startDate,
                                                    @RequestParam(required = false) String endDate,
                                                    @RequestParam(required = false) String bankName,
                                                    @RequestParam(required = false) String scheme) {
        LocalDate start;
        LocalDate end;
        try {
            start = isBlank(startDate) ? null : LocalDate.parse(startDate);
            end = isBlank(endDate) ? null : LocalDate.parse(endDate);
        } catch (DateTimeParseException e) {
            return error(400, "startDate and endDate must be in yyyy-MM-dd format");
        }
        if (start != null && end != null && end.isBefore(start)) {
            return error(400, "endDate cannot be before startDate");
        }

        // Rows of (bank, scheme, successful, failed, lastChecked), from the all-time or the daily records.
        List<Row> rows = new ArrayList<>();
        if (start == null && end == null) {
            for (PosTransactionIssuerBank r : issuerBankRepository.findAll()) {
                rows.add(new Row(r.getIssuerBank(), r.getScheme(), r.getSuccessfulTransactions(),
                        r.getFailedTransactions(), r.getLastChecked()));
            }
        } else {
            Criteria date = Criteria.where("date");
            if (start != null) {
                date.gte(start.toString());
            }
            if (end != null) {
                date.lte(end.toString());
            }
            for (PosTransactionIssuerBankDaily r : mongoTemplate.find(new Query(date), PosTransactionIssuerBankDaily.class)) {
                rows.add(new Row(r.getIssuerBank(), r.getScheme(), r.getSuccessfulTransactions(),
                        r.getFailedTransactions(), r.getLastChecked()));
            }
        }

        // Sum per bank + scheme (several days collapse into one), then group schemes under their bank.
        Map<String, Map<String, Row>> byBank = new TreeMap<>();
        for (Row row : rows) {
            // Records stored before bank names were normalized / UNKNOWN was dropped are merged or left out here.
            if (row.bank == null || row.scheme == null) {
                continue;
            }
            if (!matches(row.bank, bankName) || !matches(row.scheme, scheme)) {
                continue;
            }
            Row total = byBank.computeIfAbsent(row.bank, b -> new TreeMap<>())
                    .computeIfAbsent(row.scheme, s -> new Row(row.bank, row.scheme, 0, 0, null));
            total.successful += row.successful;
            total.failed += row.failed;
            if (row.lastChecked != null && (total.lastChecked == null || row.lastChecked.compareTo(total.lastChecked) > 0)) {
                total.lastChecked = row.lastChecked;
            }
        }

        List<IssuerBankHealth> result = new ArrayList<>();
        for (Map.Entry<String, Map<String, Row>> bank : byBank.entrySet()) {
            IssuerBankHealth health = new IssuerBankHealth(bank.getKey());
            for (Row r : bank.getValue().values()) {
                long total = r.successful + r.failed;
                double rate = BinLookupService.successRate(r.successful, total);
                IssuerBankHealth.SchemeHealth s = new IssuerBankHealth.SchemeHealth();
                s.setScheme(r.scheme);
                s.setStatus(binLookupService.healthStatus(rate));
                s.setSuccessRate(rate);
                s.setTotalTransactions(total);
                s.setSuccessfulTransactions(r.successful);
                s.setFailedTransactions(r.failed);
                s.setLastChecked(r.lastChecked);
                health.getCardSchemes().add(s);
            }
            result.add(health);
        }
        return ok(result);
    }

    private static class Row {
        final String bank;
        final String scheme;
        long successful;
        long failed;
        String lastChecked;

        Row(String bank, String scheme, long successful, long failed, String lastChecked) {
            this.bank = BinLookupService.normalizeBankName(bank);
            this.scheme = scheme == null || scheme.isBlank() || BinLookupService.UNKNOWN.equalsIgnoreCase(scheme)
                    ? null : scheme.trim().toUpperCase(Locale.ROOT);
            this.successful = successful;
            this.failed = failed;
            this.lastChecked = lastChecked;
        }
    }

    private static boolean matches(String value, String filter) {
        return isBlank(filter) || value.toUpperCase(Locale.ROOT).contains(filter.trim().toUpperCase(Locale.ROOT));
    }

    private static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private ResponseEntity<ResponseSchema<?>> ok(Object data) {
        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", data, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    private ResponseEntity<ResponseSchema<?>> error(int status, String message) {
        ResponseSchema<?> responseSchema = new ResponseSchema<>(status, message, null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.valueOf(status));
    }
}
