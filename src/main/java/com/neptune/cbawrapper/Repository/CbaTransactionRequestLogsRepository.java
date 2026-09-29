package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.CbaTransactionRequestLogs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CbaTransactionRequestLogsRepository extends MongoRepository<CbaTransactionRequestLogs, String> {
}
