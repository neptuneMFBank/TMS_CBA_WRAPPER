package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.BusinessPlatformCharges;
import com.neptune.cbawrapper.Models.PlatformCharges;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessPlatformChargesRepository extends MongoRepository<BusinessPlatformCharges, String> {

    @Query("{ 'businessWalletId': { $eq: ?0 } }")
    Optional<BusinessPlatformCharges> getChargeByBusinessWalletId(String businessWalletId);

    @Query("{ 'businessName': { $eq: ?0 } }")
    Optional<BusinessPlatformCharges> getChargeByBusinessPlatformId(String businessName);

    @Query("{ 'businessWalletId': { $eq: ?0 } }")
    Optional<BusinessPlatformCharges> getChargeByAcct(String businessWalletId);
}
