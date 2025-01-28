package com.neptune.cbawrapper.Services;


import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import com.virtualAccountApplication.createAccount.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class VirtualAccountService {

    private static final Logger log = LoggerFactory.getLogger(VirtualAccountService.class);
    @Value("${grpc.virtual.request.url}")
    private String virtual_server_ip;

    @Value("${grpc.virtual.request.port}")
    private int virtual_server_port;

    private final ErrorLoggingException errorLoggingException;

    public CreateBulkAccResponse createVirtualAccount(List<VirtualAccountModel> virtualAccountModel) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(virtual_server_ip, virtual_server_port).usePlaintext().build();
        CreateBulkAccResponse response = null;
        try {
            CreateAccountServiceGrpc.CreateAccountServiceBlockingStub stub = CreateAccountServiceGrpc.newBlockingStub(channel);

            // Create the request builder for CreateBulkAccountRequest
            CreateBulkAccountRequest.Builder bulkRequestBuilder = CreateBulkAccountRequest.newBuilder();

            // Use a for loop to create 4 CreateAccountRequest objects
            for (int i = 0; i < virtualAccountModel.size(); i++) {
                String email = virtualAccountModel.get(i).getEmail() != null ? virtualAccountModel.get(i).getEmail() : "";

                String bvn = virtualAccountModel.get(i).getBvn() != null ? virtualAccountModel.get(i).getBvn() : "";
                String acctName = virtualAccountModel.get(i).getAccount_name() != null ? virtualAccountModel.get(i).getAccount_name() : "";
                String nin = virtualAccountModel.get(i).getNin() != null ? virtualAccountModel.get(i).getNin() : "";
                String tin = virtualAccountModel.get(i).getTin() != null ? virtualAccountModel.get(i).getTin() : "";
                String settlementAcct = virtualAccountModel.get(i).getParent_account() != null ? virtualAccountModel.get(i).getParent_account() : "";
                String parentId = virtualAccountModel.get(i).getParent_id() != null ? virtualAccountModel.get(i).getParent_id() : "";
                String phone = virtualAccountModel.get(i).getPhone_number() != null ? virtualAccountModel.get(i).getPhone_number() : "";
                String businessWallet = virtualAccountModel.get(i).getBusinessWalletId() != null ? virtualAccountModel.get(i).getBusinessWalletId() : "";
                StaticAccountMessage staticAccount = StaticAccountMessage.newBuilder()
                        .setPhoneNumber(phone) // Example phone numbers
                        .setAccountName(acctName)
                        .setEmail(email)
                        .setBvn(bvn)
                        .setNin(nin)
                        .setTin(tin)
                        .setSettlementAccount(settlementAcct)
                        .build();

                CreateAccountRequest accountRequest = CreateAccountRequest.newBuilder()
                        .setStaticAccount(staticAccount)
                        .setAccountType(AccountTypes.STATIC)
                        .setParentId(parentId)
                        .setSecondaryParentAccountNumber(businessWallet)
                        .build();

                // Add the request to the bulk request
                bulkRequestBuilder.addData(accountRequest);
            }

            // Build the bulk request
            CreateBulkAccountRequest bulkRequest = bulkRequestBuilder.build();

            // Send the request to the gRPC server
            response = stub.createBulkAcc(bulkRequest);
        }catch (StatusRuntimeException e) {
            System.out.println("error1 CREATE_VIRTUAL_ACCOUNT_HANDLER = " + e.getMessage());
            errorLoggingException.logError("CREATE_VIRTUAL_ACCOUNT_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            System.out.println("error 2 CREATE_VIRTUAL_ACCOUNT_HANDLER = " + e.getMessage());
            errorLoggingException.logError("CREATE_VIRTUAL_ACCOUNT_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }
}
