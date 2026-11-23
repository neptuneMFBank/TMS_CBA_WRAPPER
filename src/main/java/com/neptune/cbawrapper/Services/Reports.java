package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.report.PosTransactionSummaryRequest;
import com.neptune.cba.transaction.report.PosTransactionSummaryResponse;
import com.neptune.cba.transaction.report.ReportServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Reports {

    private final ErrorLoggingException errorLoggingException;

    @Value("${grpc.debitCredit.request.url}")
    private String transaction_ip;

    @Value("${grpc.debitCredit.request.port}")
    private int transaction_port;

    public PosTransactionSummaryResponse getTransactionReports(PosTransactionSummaryRequest request){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(transaction_ip, transaction_port).usePlaintext().build();
        try {
            ReportServiceGrpc.ReportServiceBlockingStub stub = ReportServiceGrpc.newBlockingStub(channel);
            return stub.posTransactionSummary(request);
        } catch (Exception e) {
            errorLoggingException.logError("POS_TRANSACTION_REPORT", String.valueOf(e.getCause()), e.getMessage());
            return null;
        }finally {
            channel.shutdownNow();
        }
    }
}
