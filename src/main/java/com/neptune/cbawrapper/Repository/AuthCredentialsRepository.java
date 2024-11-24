package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.AuthCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthCredentialsRepository extends MongoRepository<AuthCredentials, String> {

    @Query("{ 'business_name': { $eq: ?0 } }")
    Optional<AuthCredentials> getAuthByBusinessName(String business_name);

    @Query("{ 'token': { $ne: null } }")
    Optional<AuthCredentials> getAuth();
}
