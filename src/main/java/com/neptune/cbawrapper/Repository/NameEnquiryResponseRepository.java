package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.AuthCredentials;
import com.neptune.cbawrapper.Models.NameEnquiryResponseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NameEnquiryResponseRepository extends MongoRepository<NameEnquiryResponseModel, String> {

    @Query("{ 'sessionID': { $eq: ?0 } }")
    Optional<NameEnquiryResponseModel> getNameEnquiryById(String sessionID);
}
