package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.TransactionDrCr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CbaTransactionRequestsRepository extends MongoRepository<TransactionDrCr, String> {

    @Query("{ 'isUpdatedToCba': {$eq: ?0}, 'isProcessing': {$eq: ?1}, 'type': { $ne: 'charge' } }")
    List<TransactionDrCr> findByIsUpdatedToCbaAndIsProcessing(boolean isUpdatedToCba, boolean isProcessing);

    @Query("{ 'transactionreference': {$eq: ?0} }")
    Optional<TransactionDrCr> findByRef(String transactionreference);

    @Query("{ 'isUpdatedToCba': {$eq: ?0}, 'cbaMessage': { $eq: 'ok' } }")
    List<TransactionDrCr> findTransactionsLoggedToCba(boolean isUpdatedToCba);

    // Add to repository
    @Query("{ 'isProcessing': true, 'processingStartedAt': { $lt: ?0 }, 'isUpdatedToCba': false }")
    List<TransactionDrCr> findStuckProcessingTransactions(String thresholdTime);
}
