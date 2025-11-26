package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.type.AddChargeRequest;
import com.neptune.cba.transaction.type.AddChargeResponse;
import com.neptune.cba.transaction.type.TransactionTypeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionTypeService {

    public AddChargeResponse addCharge(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("", 10001).usePlaintext().build();
        AddChargeResponse response = null;

        try {
            AddChargeRequest request = AddChargeRequest.newBuilder()
                    .setAmount(0.0)
                    .setDescription("")
                    .setTransactionType("")
                    .setId(0)
                    .build();

            TransactionTypeServiceGrpc.TransactionTypeServiceBlockingStub stub = TransactionTypeServiceGrpc.newBlockingStub(channel);
            response = stub.addCharge(request);
        }catch (StatusRuntimeException e){
            System.out.println("status runtime exception " + e.getMessage());
        }catch (Exception e){
            System.out.println("error occurred " + e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        return response;
    }
}
