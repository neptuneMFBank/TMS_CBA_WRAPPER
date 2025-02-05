package com.neptune.cbawrapper.Services;

import com.neptune.cba.transaction.history.HistoryRequest;
import com.neptune.cba.transaction.history.HistoryResponse;
import com.neptune.cba.transaction.history.HistoryServiceGrpc;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Value("${grpc.debitCredit.request.url}")
    private String debitCredit_server_ip;

    @Value("${grpc.debitCredit.request.port}")
    private int debitCredit_server_port;

    private final ErrorLoggingException errorLoggingException;

    public HistoryService(ErrorLoggingException errorLoggingException) {
        this.errorLoggingException = errorLoggingException;
    }

    public HistoryResponse getAcctHistory(String accountNum, String start_date, String narration, String end_date, int page, int size){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(debitCredit_server_ip, debitCredit_server_port).usePlaintext().build();
        HistoryResponse response = null;
        try {
            HistoryServiceGrpc.HistoryServiceBlockingStub stub = HistoryServiceGrpc.newBlockingStub(channel);
            HistoryRequest request = HistoryRequest.newBuilder()
                    .setAcctNo(accountNum)
                    .setNarration(narration)
                    .setPageSize(size)
                    .setFromdate(start_date)
                    .setTodate(end_date)
                    .setPage(page)
                    .build();

            System.out.println("========================= start ===================");
            System.out.println("request = " + request);

            response = stub.history(request);
        }catch (StatusRuntimeException e){
            System.out.println("error1 GET_TRANSACTION_HISTORY_HANDLER = " + e.getMessage());
            errorLoggingException.logError("GET_TRANSACTION_HISTORY_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }catch (Exception e) {
            System.out.println("error2 GET_TRANSACTION_HISTORY_HANDLER = " + e.getMessage());
            errorLoggingException.logError("GET_TRANSACTION_HISTORY_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        }finally {
            channel.shutdownNow();
        }
        System.out.println("response = " + response);
        System.out.println("============================= end =======================");
        return response;

    }
}
