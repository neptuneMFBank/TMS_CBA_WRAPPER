package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends MongoRepository<Bank, String> {
    Optional<Bank> findByBankName(String bankName);
}
