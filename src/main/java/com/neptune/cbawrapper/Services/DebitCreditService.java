package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.balance.BalanceRequest;
import com.neptune.cba.transaction.balance.BalanceResponse;
import com.neptune.cba.transaction.balance.BalanceServiceGrpc;
import com.neptune.cba.transaction.debit_credit.*;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.CbaTransactionRequestLogs;
import com.neptune.cbawrapper.Models.TransactionDrCr;
import com.neptune.cbawrapper.Models.VerifyUser;
import com.neptune.cbawrapper.Repository.CbaTransactionRequestLogsRepository;
import com.neptune.cbawrapper.Repository.CbaTransactionRequestsRepository;
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

import java.time.LocalDateTime;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DebitCreditService {

    @Value("${grpc.debitCredit.request.url}")
    private String debitCredit_server_ip;

    @Value("${grpc.debitCredit.request.port}")
    private int debitCredit_server_port;

    @Value("${grpc.debitCredit.charge.ledger_code}")
    private String charge_ledger_code;

    @Value("${grpc.debitCredit.transaction.ledger_code}")
    private String transaction_ledger_code;

    private final CbaTransactionRequestLogsRepository cbaTransactionRequestLogsRepository;

    private final ErrorLoggingException errorLoggingException;

    private static final Logger log = LoggerFactory.getLogger(DebitCreditService.class);

    public DebitCreditResponse debitCredit(TransactionDrCr transactionDrCr, double platformCharge, double nestedCharge, String businessAcct) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(debitCredit_server_ip, debitCredit_server_port).usePlaintext().build();
        DebitCreditResponse response = null;

        Charge charge = Charge.newBuilder()
                .setAmount(platformCharge)
                .setLedger(charge_ledger_code)
                .setIsFixed(true)
                .addNestedCharges(
                        NestedCharge.newBuilder()
                                .setPercentage(0)
                                .setIsFixed(true)
                                .setAccountnumber("502010059")
                                .setAmount(nestedCharge)
                                .build())
                .setPercentage(0)
                .setDescription("Platform charge")
                .build();

        DebitCreditRequest request = DebitCreditRequest.newBuilder()
                .setAccountnumber(transactionDrCr.getAccountnumber())
                .setIsccode(transaction_ledger_code)
                .setAccountstatus(transactionDrCr.getAccountstatus())
                .setAcctname(transactionDrCr.getAcctname())
                .setDrcr(transactionDrCr.getDrcr())
                .setAcctype(transactionDrCr.getAcctype())
                .setAmount(transactionDrCr.getAmount())
                .addCharge(charge)
                .setTransactionreference(transactionDrCr.getTransactionreference())
                .setNarration(transactionDrCr.getNarration())
                .setChannel(transactionDrCr.getChannel())
                .setEid(transactionDrCr.getEid())
                .setIsPos(true)
                .build();

        log.info("request ${} ", request);

        try {
            DebitCreditServiceGrpc.DebitCreditServiceBlockingStub stub = DebitCreditServiceGrpc.newBlockingStub(channel);
            response = stub.debitCredit(request);

            // ✅ Log request and response to MongoDB after successful call
            saveLog(request.toString(), response.toString(), transactionDrCr.getTransactionreference());

        } catch (StatusRuntimeException e) {
            log.error("StatusRuntimeException: {}", e.getMessage());
            errorLoggingException.logError("DEBIT_CREDIT_STATUS_RUNTIME_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
            response = DebitCreditResponse.newBuilder().setMessage(e.getMessage()).setCode("500").build();

            // ✅ Log failed request and error response
            saveLog(request.toString(), response.toString(), transactionDrCr.getTransactionreference());

        } catch (Exception e) {
            log.error("Exception: {}", e.getMessage());
            errorLoggingException.logError("DEBIT_CREDIT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());

            // ✅ Log failed request with exception message
            saveLog(request.toString(), "EXCEPTION: " + e.getMessage(), transactionDrCr.getTransactionreference());

        } finally {
            channel.shutdownNow();
        }

        return response;
    }

    private void saveLog(String request, String response, String ref) {
        try {
            CbaTransactionRequestLogs log = CbaTransactionRequestLogs.builder()
                    .request(request)
                    .transaction_reference(ref)
                    .response(response)
                    .createdAt(LocalDateTime.now().toString())
                    .updatedAt(LocalDateTime.now().toString())
                    .build();
            cbaTransactionRequestLogsRepository.save(log);
        } catch (Exception e) {
            // ✅ Never let logging failure break the main transaction flow
            log.error("Failed to save transaction log: {}", e.getMessage());
        }
    }

    public BalanceResponse getBalance(String acct_num, String customer_id) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(debitCredit_server_ip, debitCredit_server_port).usePlaintext().build();
        BalanceResponse response = null;
       try {
           System.out.println("acct_num = " + acct_num);
           System.out.println("customer_id = " + customer_id);
           BalanceServiceGrpc.BalanceServiceBlockingStub stub = BalanceServiceGrpc.newBlockingStub(channel);
           BalanceRequest request = BalanceRequest.newBuilder().setAccountId(customer_id).setAccountNumber(acct_num).build();
           response = stub.balance(request);
       } catch (Exception e) {
           errorLoggingException.logError("DEBIT_CREDIT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
       }finally {
           channel.shutdownNow();
       }
        return response;
    }

    public DebitCreditStatusResponse debitCreditStatusResponse (String transferRef) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(debitCredit_server_ip, debitCredit_server_port).usePlaintext().build();
        DebitCreditStatusResponse response = null;
        try {
            DebitCreditServiceGrpc.DebitCreditServiceBlockingStub stub = DebitCreditServiceGrpc.newBlockingStub(channel);
            DebitCreditStatusRequest request = DebitCreditStatusRequest.newBuilder().setTransactionRef(transferRef).build();
            response = stub.debitCreditStatus(request);
        } catch (Exception e) {
            errorLoggingException.logError("DEBIT_CREDIT_STATUS_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }
}
