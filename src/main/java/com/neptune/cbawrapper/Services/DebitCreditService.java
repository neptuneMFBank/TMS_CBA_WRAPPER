package com.neptune.cbawrapper.Services;


import com.neptune.cba.transaction.balance.BalanceRequest;
import com.neptune.cba.transaction.balance.BalanceResponse;
import com.neptune.cba.transaction.balance.BalanceServiceGrpc;
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

        System.out.println("transactionDrCr.getAccountnumber() = " + transactionDrCr.getAccountnumber());
        System.out.println("transactionDrCr.getAccountstatus() = " + transactionDrCr.getAccountstatus());
        System.out.println("transactionDrCr.getAcctname() = " + transactionDrCr.getAcctname());
        System.out.println("transactionDrCr.getDrcr() = " + transactionDrCr.getDrcr());
        System.out.println("transactionDrCr.getAcctype() = " + transactionDrCr.getAcctype());
        System.out.println("transactionDrCr.getAmount() = " + transactionDrCr.getAmount());
        System.out.println("transactionDrCr.getTransactionreference() = " + transactionDrCr.getTransactionreference());
        System.out.println("transactionDrCr.getNarration() = " + transactionDrCr.getNarration());
        System.out.println("transactionDrCr.getChannel() = " + transactionDrCr.getChannel());
        System.out.println("transactionDrCr.getEid() = " + transactionDrCr.getEid());
        try {
            DebitCreditRequest request = DebitCreditRequest.newBuilder()
                    .setAccountnumber(transactionDrCr.getAccountnumber())
                    .setIsccode("7002")
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
            System.out.println("error1 = " + e.getMessage());
            errorLoggingException.logError("DEBIT_CREDIT_STATUS_RUNTIME_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            System.out.println("error2 = " + e.getMessage());
            errorLoggingException.logError("DEBIT_CREDIT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        }
        channel.shutdownNow();
        return response;
    }

    public BalanceResponse getBalance(String acct_num, String customer_id) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(debitCredit_server_ip, debitCredit_server_port).usePlaintext().build();
        BalanceResponse response = null;
        System.out.println("kkkkkkkkkkkkkkkk");
       try {
           BalanceServiceGrpc.BalanceServiceBlockingStub stub = BalanceServiceGrpc.newBlockingStub(channel);
           BalanceRequest request = BalanceRequest.newBuilder().setAccountId(customer_id).setAccountNumber(acct_num).build();
           System.out.println("requesst = " + request);
           response = stub.balance(request);
           System.out.println("ksssssssssss");
       } catch (Exception e) {
           System.out.println("error2 = " + e.getMessage());
           errorLoggingException.logError("DEBIT_CREDIT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
       }
        System.out.println("kkkkkkkkkaaaaaaak");
        channel.shutdownNow();
        return response;
    }
}
