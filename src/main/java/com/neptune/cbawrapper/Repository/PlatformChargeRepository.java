package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.AuthCredentials;
import com.neptune.cbawrapper.Models.PlatformCharges;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlatformChargeRepository extends MongoRepository<PlatformCharges, String> {

    @Query("{ 'platformName': { $eq: ?0 } }")
    Optional<PlatformCharges> getChargeByName(String platformName);

    @Query("{ 'platformName': ?0, 'platformId': ?1 }")
    Optional<PlatformCharges> getChargeByNameAndId(String platformName, int platformId);

    @Query("{ 'id': { $eq: ?0 } }")
    Optional<PlatformCharges> getChargeById(String id);

    @Query("{ 'platformId': { $eq: ?0 } }")
    Optional<PlatformCharges> getChargeByPlatformId(int platformId);
}
