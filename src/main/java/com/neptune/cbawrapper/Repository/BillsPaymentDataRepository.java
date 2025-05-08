package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.BillsPaymentData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillsPaymentDataRepository extends MongoRepository<BillsPaymentData, String> {
}
