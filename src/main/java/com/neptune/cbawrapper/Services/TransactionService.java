package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.intra_transfer.IntraTransferRequest;
import com.neptune.cba.transaction.intra_transfer.IntraTransferResponse;
import com.neptune.cba.transaction.intra_transfer.IntraTransferServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.RequestRessponseSchema.IntraTransfer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final ErrorLoggingException errorLoggingException;

    @Value("${grpc.debitCredit.request.url}")
    private String transaction_ip;

    @Value("${grpc.debitCredit.request.port}")
    private int transaction_port;

    public IntraTransferResponse intraTransfer(IntraTransfer intraTransfer){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(transaction_ip, transaction_port).usePlaintext().build();

        IntraTransferResponse response = null;
        try {
            IntraTransferServiceGrpc.IntraTransferServiceBlockingStub stub = IntraTransferServiceGrpc.newBlockingStub(channel);

            IntraTransferRequest request = IntraTransferRequest.newBuilder()
                    .setCustomerId(intraTransfer.getCustomerId())
                    .setMobilekey("")
                    .setFromaccount(intraTransfer.getFromaccount())
                    .setFromacctname(intraTransfer.getFromacctname())
                    .setFromaccountstatus(intraTransfer.getFromaccountstatus())
                    .setFromaccountemail(intraTransfer.getFromaccountemail())
                    .setFromacctype(intraTransfer.getFromacctype())
                    .setToaccount(intraTransfer.getToaccount())
                    .setToacctname(intraTransfer.getToacctname())
                    .setToacctype(intraTransfer.getToacctype())
                    .setAmount(intraTransfer.getAmount())
                    .setTokenType("")
                    .setTransactionreference(intraTransfer.getTransactionreference())
                    .setNarration(intraTransfer.getNarration())
                    .setChannel("MOBILE")
                    .setEid("")
                    .build();
            response = stub.intraTransfer(request);
        }catch (StatusRuntimeException e){
            System.out.println("error 1 = " + e.getMessage());
            errorLoggingException.logError("INTRA_TRANSFER_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e){
            System.out.println("error 2 = " + e.getMessage());
            errorLoggingException.logError("INTRA_TRANSFER_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

}
