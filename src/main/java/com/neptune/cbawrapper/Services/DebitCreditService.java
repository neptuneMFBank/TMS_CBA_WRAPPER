package com.neptune.cbawrapper.Services;


import com.neptune.cba.transaction.debit_credit.DebitCreditRequest;
import com.neptune.cba.transaction.debit_credit.DebitCreditResponse;
import com.neptune.cba.transaction.debit_credit.DebitCreditServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.TransactionDrCr;
import com.neptune.cbawrapper.Models.VerifyUser;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DebitCreditService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    @Value("${grpc.debitCredit.request.url}")
    private String debitCredit_server_ip;

    @Value("${grpc.debitCredit.request.port}")
    private int debitCredit_server_port;

    private final ErrorLoggingException errorLoggingException;

    public DebitCreditResponse debitCredit(TransactionDrCr transactionDrCr){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(debitCredit_server_ip, debitCredit_server_port).usePlaintext().build();
        DebitCreditResponse response = null;
        try {
            DebitCreditRequest request = DebitCreditRequest.newBuilder()
                    .setAccountnumber(transactionDrCr.getAccountnumber())
                    .setIsccode(transactionDrCr.getIsccode())
                    .setAccountstatus(transactionDrCr.getAccountstatus())
                    .setAcctname(transactionDrCr.getAcctname())
                    .setDrcr(transactionDrCr.getDrcr())
                    .setAcctype(transactionDrCr.getAcctype())
                    .setAmount(transactionDrCr.getAmount())
                    .setTransactionreference(transactionDrCr.getTransactionreference())
                    .setNarration(transactionDrCr.getNarration())
                    .setChannel(transactionDrCr.getChannel())
                    .setEid(transactionDrCr.getEid())
                    .build();

            DebitCreditServiceGrpc.DebitCreditServiceBlockingStub stub = DebitCreditServiceGrpc.newBlockingStub(channel);
            response = stub.debitCredit(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("DEBIT_CREDIT_STATUS_RUNTIME_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("DEBIT_CREDIT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        }
        channel.shutdownNow();
        return response;
    }
}
