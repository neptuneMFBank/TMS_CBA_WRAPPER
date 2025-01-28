package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.TransactionDrCr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CbaTransactionRequestsRepository extends MongoRepository<TransactionDrCr, String> {

    @Query("{ 'isUpdatedToCba': {$eq: ?0}, 'type': { $ne: 'charge' } }")
    List<TransactionDrCr> findTransactionsNotLoggedToCba(boolean isUpdatedToCba);

    @Query("{ 'transactionreference': {$eq: ?0} }")
    Optional<TransactionDrCr> findByRef(String transactionreference);


}
