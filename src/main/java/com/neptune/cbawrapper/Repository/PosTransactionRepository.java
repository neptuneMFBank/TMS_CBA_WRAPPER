package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.BusinessPlatformCharges;
import com.neptune.cbawrapper.RequestRessponseSchema.TransactionRequestSchema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PosTransactionRepository extends MongoRepository<TransactionRequestSchema, String> {

    @Query("{ 'transactionPlatform': { $eq: ?0 } }")
    Optional<TransactionRequestSchema> getPlatformChargesByPlatformId(Integer transactionPlatform);
}
