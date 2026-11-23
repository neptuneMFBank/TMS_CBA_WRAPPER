package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.BinLookup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinLookupRepository extends MongoRepository<BinLookup, String> {
}
