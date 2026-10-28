package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.BusinessPlatformCharges;
import com.neptune.cbawrapper.RequestRessponseSchema.TransactionRequestSchema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PosTransactionRepository extends MongoRepository<TransactionRequestSchema, String> {

    @Query("{ 'transactionPlatform': { $eq: ?0 } }")
    Optional<TransactionRequestSchema> getPlatformChargesByPlatformId(Integer transactionPlatform);

    @Query("{ 'reference': { $eq: ?0 } }")
    Optional<TransactionRequestSchema> getTransactionByRef(String reference);

    @Query(value = "{ 'terminalId': { $in: ?0 }, " +
            "'created_at': { $gte: ?1, $lt: ?2 }, " +
            "'reference': { $not: { $regex: '^(intra_|inter_|2103)' } }, " +
            "$or: [ { 'responseCode': { $ne: '00' } }, { 'reversal': true } ] }")
    List<TransactionRequestSchema> findUnsuccessfulTransactions(
            List<String> terminalIds,
            String startDate,
            String endDate
    );

    @Query("{ 'terminalId': { $in: ?0 }, 'created_at': { $gte: ?1, $lt: ?2 }, 'reference': { $regex: '^(intra_|inter_)' } }")
    List<TransactionRequestSchema> findTransfersByTerminalIdsAndDateRange(
            Set<String> terminalIds,
            String startDate,
            String endDate
    );

}
