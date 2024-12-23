package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.MenuListModel;
import com.neptune.cbawrapper.RequestRessponseSchema.MenuList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenuListRepository extends MongoRepository<MenuListModel, String> {

    List<MenuListModel> findBySerialNo(String serialNo);
}
