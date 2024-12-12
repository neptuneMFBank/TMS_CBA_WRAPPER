package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.TransactionDrCr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CbaTransactionRequestsRepository extends MongoRepository<TransactionDrCr, String> {

    @Query("{ 'isUpdatedToCba': {$eq: ?0} }")
    List<TransactionDrCr> findTransactionsNotLoggedToCba(boolean isUpdatedToCba);
}
