package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.Create3ppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdpUserRepository extends MongoRepository<Create3ppUser, String> {
}
