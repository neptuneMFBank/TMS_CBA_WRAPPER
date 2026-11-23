package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.States;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends MongoRepository<States, String> {
    boolean existsByStateCode(String stateCode);

    Optional<States> findByStateCode(String stateCode);

    Optional<States> findByStateName(String stateName);

    Optional<States> findByStateNameIgnoreCase(String stateName);
}
