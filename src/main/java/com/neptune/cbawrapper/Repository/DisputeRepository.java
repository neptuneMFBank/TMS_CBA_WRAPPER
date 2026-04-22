package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.DisputeReasons;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisputeRepository extends MongoRepository<DisputeReasons, String> {
    @Query("{ 'reason': { $eq: ?0 } }")
    Optional<DisputeReasons> getDispute(String reason);
}
