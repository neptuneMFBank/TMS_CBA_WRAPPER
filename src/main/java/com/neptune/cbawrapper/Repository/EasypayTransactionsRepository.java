package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.EasypayTransactionsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EasypayTransactionsRepository extends MongoRepository<EasypayTransactionsModel, String> {
}
