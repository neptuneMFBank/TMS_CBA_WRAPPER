package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionsRepository extends MongoRepository<Transactions, String> {

    @Query("{ 'transactionreference': { $eq: ?0 } }")
    Optional<Transactions> checkIfTransactionWithRefExists(String transactionreference);

    @Query("{ 'status': { $eq: ?0 } }")
    List<Transactions> checkTransactionStatus(String status);
}
