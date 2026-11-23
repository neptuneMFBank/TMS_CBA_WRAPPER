package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.PosTransactionIssuerBank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosTransactionIssuerBankRepository extends MongoRepository<PosTransactionIssuerBank, String> {
}
