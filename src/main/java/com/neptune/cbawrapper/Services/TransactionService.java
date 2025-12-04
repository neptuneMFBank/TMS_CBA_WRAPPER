package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.intra_transfer.IntraTransferRequest;
import com.neptune.cba.transaction.intra_transfer.IntraTransferResponse;
import com.neptune.cba.transaction.intra_transfer.IntraTransferServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.IntraTransferResponseData;
import com.neptune.cbawrapper.RequestRessponseSchema.IntraTransfer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
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

    public IntraTransferResponseData intraTransfer(IntraTransfer intraTransfer) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(transaction_ip, transaction_port)
                .usePlaintext()
                .build();

        try {
            IntraTransferServiceGrpc.IntraTransferServiceBlockingStub stub =
                    IntraTransferServiceGrpc.newBlockingStub(channel);

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

            IntraTransferResponse response = stub.intraTransfer(request);

            return IntraTransferResponseData.builder()
                    .responsecode(response.getCode())
                    .responsemessage(response.getMessage())
                    .build();
        } catch (StatusRuntimeException e) {

            Status.Code errorCode = e.getStatus().getCode();
            String errorMsg = e.getStatus().getDescription();

            System.out.println("gRPC Error Code = " + errorCode);
            System.out.println("gRPC Error Message = " + errorMsg);

            // ⭐ Build a custom error response instead of returning null
            return IntraTransferResponseData.builder()
                    .responsecode(errorCode.toString())  // e.g. FAILED_PRECONDITION
                    .responsemessage(errorMsg)           // e.g. "Insufficient balance"
                    .build();

        } catch (Exception e) {

            System.out.println("gRPC Error Code = " + e.getCause());
//            System.out.println("gRPC Error Message = " + e.getCause().initCause().getMessage());

            return IntraTransferResponseData.builder()
                    .responsecode("401")
                    .responsemessage("insufficient balance")
                    .build();

        } finally {
            channel.shutdownNow();
        }
    }


}
