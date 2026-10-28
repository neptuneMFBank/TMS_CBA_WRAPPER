package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.EasypayTransactionsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EasypayTransactionsRepository extends MongoRepository<EasypayTransactionsModel, String> {

    @Query("{ 'paymentReference': { $in: ?0 } }")
    List<EasypayTransactionsModel> findByPaymentReferenceIn(List<String> paymentReferences);
}
