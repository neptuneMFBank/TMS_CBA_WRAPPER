package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.MerchantData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends MongoRepository<MerchantData, String> {
    List<MerchantData> findByUploadedFalse();

    List<MerchantData> findBySyncFalse();

    List<MerchantData> findMerchantByTin(String tin);

    List<MerchantData> findMerchantByBusinessAcct(String businessAcct);

    Optional<MerchantData> findFirstByOrderByCreatedAtDesc();
}
