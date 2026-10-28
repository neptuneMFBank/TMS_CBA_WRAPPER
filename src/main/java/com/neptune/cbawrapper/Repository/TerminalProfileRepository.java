package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.TerminalProfileModel;
import com.neptune.cbawrapper.RequestRessponseSchema.TerminalProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TerminalProfileRepository extends MongoRepository<TerminalProfileModel, String> {

    @Query("{ 'serialNo': { $eq: ?0 } }")
    Optional<TerminalProfileModel> getBySerialNo(String serialNo);

    @Query("{ 'terminalId': { $in: ?0 } }")
    List<TerminalProfileModel> findByTerminalIdIn(List<String> terminalIds);
}
