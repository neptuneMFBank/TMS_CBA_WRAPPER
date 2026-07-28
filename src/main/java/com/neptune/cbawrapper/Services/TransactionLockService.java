package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Models.TransactionDrCr;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionLockService {

    private final MongoTemplate mongoTemplate;

    // ✅ Atomically claim the transaction — only ONE process can claim it
    public TransactionDrCr claimTransaction(String transactionId) {
        Query query = new Query(
                Criteria.where("_id").is(transactionId)
                        .and("isProcessing").is(false)        // not already processing
                        .and("isUpdatedToCba").is(false)      // not already completed
        );

        Update update = new Update()
                .set("isProcessing", true)
                .set("processingStartedAt", LocalDateTime.now().toString());

        FindAndModifyOptions options = FindAndModifyOptions.options()
                .returnNew(true)   // return updated document
                .upsert(false);

        // ✅ Atomic — only one thread/process can successfully claim it
        return mongoTemplate.findAndModify(query, update, options, TransactionDrCr.class);
    }

    // ✅ Release lock after processing
    public void releaseTransaction(String transactionId, boolean success, String message) {
        Query query = new Query(Criteria.where("_id").is(transactionId));
        Update update = new Update()
                .set("isProcessing", false)
                .set("isUpdatedToCba", success)
                .set("cbaMessage", message)
                .set("updated_at", LocalDateTime.now().toString());

        mongoTemplate.updateFirst(query, update, TransactionDrCr.class);
    }
}
