package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.CategoryServicesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryServicesRepository extends MongoRepository<CategoryServicesModel, String> {

    @Query("{ 'serviceId': {$eq: ?0}, 'name': { $eq: ?1 } }")
    Optional<CategoryServicesModel> findCategoryService(String serviceId, String categoryName);

    @Query("{ 'interswitchId': {$eq: ?0} }")
    List<CategoryServicesModel> findAllById(String id);
}
