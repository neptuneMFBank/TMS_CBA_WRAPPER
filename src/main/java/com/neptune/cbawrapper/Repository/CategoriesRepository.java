package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.CategoriesModel;
import com.neptune.cbawrapper.Models.TransactionDrCr;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends MongoRepository<CategoriesModel, String> {

    @Query("{ 'interswitchId': {$eq: ?0}, 'name': { $eq: ?1 } }")
    Optional<CategoriesModel> findCategory(String interswitchId, String name);

    @Query("{ 'isActive': {$eq: ?0} }")
    List<CategoriesModel> findCategory(boolean status);
}
