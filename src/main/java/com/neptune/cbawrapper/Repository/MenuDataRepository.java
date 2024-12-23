package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.MenuDataModel;
import com.neptune.cbawrapper.RequestRessponseSchema.MenuData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuDataRepository extends MongoRepository<MenuDataModel, String> {

    Optional<MenuDataModel> findBySerialNo(String serialNo);
}
