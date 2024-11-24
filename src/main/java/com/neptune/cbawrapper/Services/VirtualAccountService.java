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

    public CreateAccountResponse createVirtualAccount(VirtualAccountModel virtualAccountModel){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(virtual_server_ip, virtual_server_port).usePlaintext().build();
        CreateAccountResponse response = null;

        try {
            CreateAccountRequest request = CreateAccountRequest
                    .newBuilder()
                    .setStaticAccount(
                            StaticAccountMessage
                                    .newBuilder().setPhoneNumber(virtualAccountModel.getPhone_number())
                                    .setAccountName(virtualAccountModel.getAccount_name())
                                    .setEmail(virtualAccountModel.getEmail())
                                    .setBvn(virtualAccountModel.getBvn())
                                    .setNin(virtualAccountModel.getNin())
                                    .build())
                    .setAccountType(AccountTypes.STATIC)
                    .setSecondaryParentAccountNumber(virtualAccountModel.getParent_account())
                    .setParentId(virtualAccountModel.getParent_id())
                    .build();

            CreateAccountServiceGrpc.CreateAccountServiceBlockingStub stub = CreateAccountServiceGrpc.newBlockingStub(channel);
            response = stub.createAccount(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("CREATE_VIRTUAL_ACCOUNT_STATUS_RUNTIME_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("CREATE_VIRTUAL_ACCOUNT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        }

        return response;

    }
}
