package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.VirtualAccountModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VirtualAccountRepository extends MongoRepository<VirtualAccountModel, String> {

    @Query("{ 'virtual_account_number': { $eq: null } }")
    List<VirtualAccountModel> getCustomersWithoutAccountId();
}
