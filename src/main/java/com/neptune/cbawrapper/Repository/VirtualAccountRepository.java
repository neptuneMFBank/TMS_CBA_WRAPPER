package com.neptune.cbawrapper.Repository;

import com.neptune.cbawrapper.Models.CustomersModel;
import com.neptune.cbawrapper.Models.Transactions;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VirtualAccountRepository extends MongoRepository<VirtualAccountModel, String> {

    @Query("{ 'virtual_account_number': { $eq: null } }")
    List<VirtualAccountModel> getCustomersWithoutAccountId();

    @Query("{ 'virtual_account_number': { $eq: ?0 } }")
    Optional<VirtualAccountModel> getCustomersWithAccountId(String accountId);

    @Query("{ 'virtual_account_number': { $ne: null }, 'is_updated': false }")
    List<VirtualAccountModel> getCustomersNotAddedToCorePay();

    @Query("{ 'terminalId': {$in: ?0} }")
    List<VirtualAccountModel> findByVirtualAccountsByTerminalId(List<String> terminalId);

    @Query("{ 'terminalId': { $eq: ?0 } }")
    Optional<VirtualAccountModel> getVirtualAccountByTerminalId(String terminalId);

    @Query("{ 'virtual_account_number': { $eq: ?0 } }")
    Optional<VirtualAccountModel> getVirtualAccountModelByAccount(String virtual_account_number);

    @Query("{ 'businessWalletId': { $eq: ?0 } }")
    Optional<VirtualAccountModel> getVirtualAccountModelByBusinessAccount(String businessWalletId);

    @Query("{ 'parent_account': { $eq: ?0 } }")
    Optional<VirtualAccountModel> getVirtualAccountModelByParentAccount(String parent_account);
}
