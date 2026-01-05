package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.easy_pay.*;
import com.neptune.cba.transaction.type.Empty;
import com.neptune.cba.transaction.type.TransactionTypeResponse;
import com.neptune.cba.transaction.type.TransactionTypeServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.EasypayTransactionsModel;
import com.neptune.cbawrapper.RequestRessponseSchema.EasyPayHistoryRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.EasyPayTransferRequestPayload;
import com.neptune.cbawrapper.RequestRessponseSchema.NameEnquiryRequestPayload;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Easypay {

    private final ErrorLoggingException errorLoggingException;

    public Easypay(ErrorLoggingException errorLoggingException) {
        this.errorLoggingException = errorLoggingException;
    }

    @Value("${grpc.easypay.request.url}")
    private String easy_pay_ip;

    @Value("${grpc.easypay.request.port}")
    private int easy_pay_port;

    public EasyPayResponse transferOutward(EasypayTransactionsModel payload){
        System.out.println("payload = " + payload);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(easy_pay_ip, easy_pay_port).usePlaintext().build();
        EasyPayResponse response = null;
        System.out.println("payload.getAmount() = " + payload.getAmount());
        try {
            EasyPayServiceGrpc.EasyPayServiceBlockingStub stub = EasyPayServiceGrpc.newBlockingStub(channel);

            EasyPayRequest request = EasyPayRequest.newBuilder()
                    .setBeneficiaryAccountName(safe(payload.getBeneficiaryAccountName()))
                    .setBeneficiaryAccountNumber(safe(payload.getBeneficiaryAccountNumber()))
                    .setBeneficiaryBankVerificationNumber(safe(payload.getBeneficiaryBankVerificationNumber()))
                    .setBeneficiaryKYCLevel(safe(payload.getBeneficiaryKYCLevel()))
                    .setOriginatorAccountName(safe(payload.getOriginatorAccountName()))
                    .setOriginatorAccountNumber(safe(payload.getOriginatorAccountNumber()))
                    .setOriginatorBankVerificationNumber(safe(payload.getOriginatorBankVerificationNumber()))
                    .setOriginatorKYCLevel(payload.getOriginatorKYCLevel())
                    .setBeneficiaryNarration(safe(payload.getOriginatorNarration()))
                    .setNameEnquiryRef(safe(payload.getNameEnquiryRef()))
                    .setDestinationInstitutionCode(payload.getDestinationInstitutionCode())
                    .setOriginatorNarration(safe(payload.getOriginatorNarration()))
                    .setPaymentReference(safe(payload.getPaymentReference()))
                    .setTransactionLocation(safe(payload.getTransactionLocation()))
                    .setCustomerAccountName(safe(payload.getCustomerAccountName()))
                    .setCustomerAccountNumber(safe(payload.getCustomerAccountNumber()))
                    .setAmount(payload.getAmount())
                    .build();

            System.out.println("request = " + request);

            response = stub.easyPay(request);

        }catch (StatusRuntimeException e){
            Status status = Status.fromThrowable(e);
            errorLoggingException.logError("EASY_PAY_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());

            String fullMessage = e.getMessage(); // "INTERNAL: Duplicate transaction"

            String userMessage = fullMessage;
            if (fullMessage != null && fullMessage.contains(":")) {
                userMessage = fullMessage.substring(fullMessage.indexOf(":") + 1).trim();
            }
            String code = status.getCode().name();

            System.out.println("Clean error = " + userMessage); // "Duplicate transaction"

            errorLoggingException.logError(
                    "EASY_PAY_STATUS_RUNTIME_EXCEPTION_HANDLER",
                    String.valueOf(e.getCause()),
                    userMessage
            );

            response = EasyPayResponse.newBuilder()
                    .setCode(code)
                    .setMessage(userMessage)
                    .build();
//            EasyPayResponse response1 = EasyPayResponse.newBuilder().setCode().build();
        } catch (Exception e) {
            Status status = Status.fromThrowable(e);
            System.out.println("error 2 = " + e.getMessage());
            String fullMessage = e.getMessage(); // "INTERNAL: Duplicate transaction"
            String code = status.getCode().name();

            String userMessage = fullMessage;
            if (fullMessage != null && fullMessage.contains(":")) {
                userMessage = fullMessage.substring(fullMessage.indexOf(":") + 1).trim();
            }

            System.out.println("Clean 2 error = " + userMessage); // "Duplicate transaction"

            errorLoggingException.logError(
                    "EASY_PAY_STATUS_RUNTIME_EXCEPTION_HANDLER",
                    String.valueOf(e.getCause()),
                    userMessage
            );
            response = EasyPayResponse.newBuilder()
                    .setCode(code)
                    .setMessage(userMessage)
                    .build();
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }

    public Institutions getInstitutions(){
        System.out.println("easy_pay_ip = " + easy_pay_ip + " easy_pay_port = " + easy_pay_port);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(easy_pay_ip, easy_pay_port).usePlaintext().build();
        EasyPayServiceGrpc.EasyPayServiceBlockingStub stub = EasyPayServiceGrpc.newBlockingStub(channel);
        Institutions response = null;
        try {
            getInstEmpty empty = getInstEmpty.newBuilder().build();
            response = stub.institutions(empty);
        }catch (StatusRuntimeException e){
            System.out.println("GRPC Status Code: " + e.getStatus().getCode());
            errorLoggingException.logError("GET_INSTITUTIONS_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }catch (Exception e){
            System.out.println("message = " + e.getMessage());
            errorLoggingException.logError("GET_INSTITUTIONS_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public NameEnquiryResponse nameEnquiry(NameEnquiryRequestPayload request){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(easy_pay_ip, easy_pay_port).usePlaintext().build();
        EasyPayServiceGrpc.EasyPayServiceBlockingStub stub = EasyPayServiceGrpc.newBlockingStub(channel);
        NameEnquiryResponse response = null;
        try {
            NameEnquiryRpcRequest rpcRequest = NameEnquiryRpcRequest.newBuilder()
                    .setAccountNumber(request.getAccountNumber())
                    .setChannelCode("1")
                    .setDestinationInstitutionCode(request.getDestinationInstitutionCode())
                    .setSenderBankCode("BANK002")
                    .setPlatform("MOBILE")
                    .build();
            response = stub.nameEnquiry(rpcRequest);
        }catch (StatusRuntimeException e){
            errorLoggingException.logError("NAME_ENQUIRY_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }catch (Exception e){
            errorLoggingException.logError("NAME_ENQUIRY_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public EasyPayListResponse getEasyPayHistory(EasyPayHistoryRequest request){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(easy_pay_ip, easy_pay_port).usePlaintext().build();
        EasyPayServiceGrpc.EasyPayServiceBlockingStub stub = EasyPayServiceGrpc.newBlockingStub(channel);
        EasyPayListResponse response = null;
        try {
            EasyPayListRequest request1 = EasyPayListRequest.newBuilder()
                    .setFromdate(request.getFromdate())
                    .setTodate(request.getTodate())
                    .setAccount(request.getAccount())
                    .setPage(request.getPage())
                    .setPageSize(request.getPageSize())
                    .build();
            response = stub.listEasyPay(request1);
        }catch (StatusRuntimeException e){
            errorLoggingException.logError("EASY_PAY_HISTORY_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }catch (Exception e){
            errorLoggingException.logError("EASY_PAY_HISTORY_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public ReverseResponse reverseTransaction(String ref){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(easy_pay_ip, easy_pay_port).usePlaintext().build();
        EasyPayServiceGrpc.EasyPayServiceBlockingStub stub = EasyPayServiceGrpc.newBlockingStub(channel);
        ReverseResponse response = null;
        try {
            ReverseRequest request1 = ReverseRequest.newBuilder()
                    .setRef(ref)
                    .build();
            response = stub.reverseEasyPay(request1);
        }catch (StatusRuntimeException e){
            errorLoggingException.logError("REVERSE_EASY_PAY_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }catch (Exception e){
            errorLoggingException.logError("REVERSE_EASY_PAY_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public EasyPayStatusResponse getEasyPayStatus(String ref){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(easy_pay_ip, easy_pay_port).usePlaintext().build();
        EasyPayServiceGrpc.EasyPayServiceBlockingStub stub = EasyPayServiceGrpc.newBlockingStub(channel);
        EasyPayStatusResponse response = null;
        try {
            EasyPayStatusRequest request1 = EasyPayStatusRequest.newBuilder().setTransactionRef(ref).build();
            response = stub.easyPayStatus(request1);
        }catch (StatusRuntimeException e){
            errorLoggingException.logError("EASY_PAY_STATUS_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }catch (Exception e){
            errorLoggingException.logError("EASY_PAY_STATUS_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }

    public TransactionTypeResponse getTransactionType(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(easy_pay_ip, easy_pay_port).usePlaintext().build();
        TransactionTypeServiceGrpc.TransactionTypeServiceBlockingStub stub = TransactionTypeServiceGrpc.newBlockingStub(channel);
        TransactionTypeResponse response = null;
        try {
            Empty request = Empty.newBuilder().build();
            response = stub.transactionType(request);
        }catch (StatusRuntimeException e){
            errorLoggingException.logError("TRANSACTION_TYPE_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }catch (Exception e){
            errorLoggingException.logError("TRANSACTION_TYPE_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }
}
