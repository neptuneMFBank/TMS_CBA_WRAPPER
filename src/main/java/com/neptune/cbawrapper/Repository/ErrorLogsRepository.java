package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.ErrorLogsModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorLogsRepository extends MongoRepository<ErrorLogsModel, String> {
}
