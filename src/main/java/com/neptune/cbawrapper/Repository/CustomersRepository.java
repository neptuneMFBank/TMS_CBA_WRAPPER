package com.neptune.cbawrapper.Repository;


import com.neptune.cbawrapper.Models.CustomersModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends MongoRepository<CustomersModel, String> {

    @Query("{ 'tin': {$in: ?0} }")
    List<CustomersModel> findByAccountId(List<String> tin);

    @Query("{ 'account_num': { $ne: null }, 'is_updated': false }")
    List<CustomersModel> getCustomersWithAccountId();

    @Query("{ 'account_num': { $eq: null } }")
    List<CustomersModel> getCustomersWithoutAccountId();

    @Query("{ 'savingsId': {$in: ?0} }")
    List<CustomersModel> findBySavingsId(List<Integer> savingsId);
}
