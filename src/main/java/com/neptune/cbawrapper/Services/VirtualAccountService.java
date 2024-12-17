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

    public CreateBulkAccResponse createVirtualAccount(List<VirtualAccountModel> virtualAccountModel){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(virtual_server_ip, virtual_server_port).usePlaintext().build();
        CreateBulkAccResponse response = null;
        CreateBulkAccountRequest.Builder request = CreateBulkAccountRequest.newBuilder();

        try {
            for (VirtualAccountModel virtualAccountModel1 : virtualAccountModel) {

                        request.addData(
                                CreateAccountRequest
                                        .newBuilder()
                                        .setStaticAccount(
                                        StaticAccountMessage.newBuilder()
                                                .setPhoneNumber(virtualAccountModel1.getPhone_number())
                                                .setAccountName(virtualAccountModel1.getAccount_name())
                                                .setEmail(virtualAccountModel1.getEmail())
                                                .setBvn(virtualAccountModel1.getBvn())
                                                .setNin(virtualAccountModel1.getNin())
                                                .setTin(virtualAccountModel1.getTin())
                                                .setSettlementAccount(virtualAccountModel1.getParent_account())
                                                .build()
                                        )
                                        .setAccountType(AccountTypes.STATIC)
                                        .setParentId(virtualAccountModel1.getParent_id())
                                        .setSecondaryParentAccountNumber(virtualAccountModel1.getBusiness_wallet())
                                        .build()
                        ).build();

            }
            CreateAccountServiceGrpc.CreateAccountServiceBlockingStub stub = CreateAccountServiceGrpc.newBlockingStub(channel);
            response = stub.createBulkAcc(request.build());
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("CREATE_VIRTUAL_ACCOUNT_STATUS_RUNTIME_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("CREATE_VIRTUAL_ACCOUNT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        }
        channel.shutdownNow();
        return response;
    }
}
