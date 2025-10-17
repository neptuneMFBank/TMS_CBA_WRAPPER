package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.AuthCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthCredentialsRepository extends MongoRepository<AuthCredentials, String> {

    @Query("{ 'email': { $eq: ?0 }, 'env': ?1 }")
    Optional<AuthCredentials> getAuthByEmail(String email, String env);

    @Query("{ 'token': { $ne: null }, 'env': ?0 } }")
    Optional<AuthCredentials> getAuth(String env);
}
