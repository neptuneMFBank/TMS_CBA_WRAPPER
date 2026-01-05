package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.balance.BalanceRequest;
import com.neptune.cba.transaction.balance.BalanceResponse;
import com.neptune.cba.transaction.balance.BalanceServiceGrpc;
import com.neptune.cba.transaction.debit_credit.*;
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

    @Value("${grpc.debitCredit.request.url}")
    private String debitCredit_server_ip;

    @Value("${grpc.debitCredit.request.port}")
    private int debitCredit_server_port;

    @Value("${grpc.debitCredit.charge.ledger_code}")
    private String charge_ledger_code;

    @Value("${grpc.debitCredit.transaction.ledger_code}")
    private String transaction_ledger_code;

    private final ErrorLoggingException errorLoggingException;

    public DebitCreditResponse debitCredit(TransactionDrCr transactionDrCr, double platformCharge, double businessCharge, String businessAcct){
        double amount = 0.0;
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
//        System.out.println("transactionDrCr.getEid() = " + transactionDrCr.getEid());

        try {
            Charge charge = Charge.newBuilder().setAmount(platformCharge).setLedger(charge_ledger_code).setIsFixed(true).setPercentage(0).addNestedCharges(NestedCharge.newBuilder().setAmount(businessCharge).setAccountnumber(businessAcct).setIsFixed(true).setPercentage(0).build()).setDescription("Platform charge").setLedger("").build();
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
                    .build();

            DebitCreditServiceGrpc.DebitCreditServiceBlockingStub stub = DebitCreditServiceGrpc.newBlockingStub(channel);
            response = stub.debitCredit(request);
            System.out.println("response = " + response);
        }catch (StatusRuntimeException e) {
            System.out.println("StatusRuntimeException = " +e.getMessage() );
            errorLoggingException.logError("DEBIT_CREDIT_STATUS_RUNTIME_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception = " + e.getMessage());
            errorLoggingException.logError("DEBIT_CREDIT_EXCEPTION_ERROR", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
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
