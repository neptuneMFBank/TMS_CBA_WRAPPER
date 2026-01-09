package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.bills.BillType;
import com.neptune.cba.transaction.bills.BillsServiceGrpc;
import com.neptune.cba.transaction.bills.MakePaymentRequest;
import com.neptune.cba.transaction.bills.MakePaymentResponse;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.MakePayment;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillsService {
    @Value("${grpc.easypay.request.url}")
    private String bills_payment_ip;

    @Value("${grpc.easypay.request.port}")
    private int bills_payment_port;

    public MakePaymentResponse makePayment(MakePayment request, double charge, BillType billType){
        System.out.println("request = " + request);
        System.out.println("charge = " + charge);
        System.out.println("billType = " + billType.name());
        ManagedChannel channel = ManagedChannelBuilder.forAddress(bills_payment_ip, bills_payment_port).usePlaintext().build();
        MakePaymentResponse makePaymentResponse;

        try {
            BillsServiceGrpc.BillsServiceBlockingStub stub = BillsServiceGrpc.newBlockingStub(channel);

            MakePaymentRequest request1 = MakePaymentRequest.newBuilder()
                    .setAmount(Double.parseDouble(request.getAmount()))
                    .setBillType(billType)
                    .setCharge(charge)
                    .setEmail(request.getEmail())
                    .setStatus("00")
                    .setBillsResponse("00")
                    .setRequestReference(request.getRequestReference())
                    .setCustomerAccountNumber(request.getCustomerAccountNumber())
                    .setCustomerId(request.getCustomerId())
                    .setPaymentCode(request.getPaymentCode())
                    .build();

            makePaymentResponse = stub.makePayment(request1);
        } catch (Exception e){
            Status status = Status.fromThrowable(e);
            String fullMessage = e.getMessage(); // "INTERNAL: Duplicate transaction"

            String userMessage = fullMessage;
            if (fullMessage != null && fullMessage.contains(":")) {
                userMessage = fullMessage.substring(fullMessage.indexOf(":") + 1).trim();
            }
            String code = status.getCode().name();

            makePaymentResponse = MakePaymentResponse.newBuilder()
                    .setCode(code)
                    .setMessage(userMessage)
                    .setApprovedAmount(0)
                    .setTransactionRef("")
                    .setResponseCode(code)
                    .setResponseCodeGrouping("")
                    .build();
        } finally {
            channel.shutdownNow();
        }
        return makePaymentResponse;
    }
}
