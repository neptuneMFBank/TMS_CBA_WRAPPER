package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.RequestRessponseSchema.GenerateStatementRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import printable.PrintableGrpc;
import printable.PrintableOuterClass;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class Printable {
    private final ErrorLoggingException errorLoggingException;
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    @Value("${grpc.printable.url}")
    private String printable_server_ip;

    @Value("${grpc.printable.port}")
    private int printable_server_port;

    public PrintableOuterClass.StatementOfAccountResponse generateState(GenerateStatementRequest generateStatementRequest, String email, String name){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(printable_server_ip, printable_server_port).usePlaintext().build();

        PrintableOuterClass.StatementOfAccountResponse response = null;
        try {
            PrintableOuterClass.StatementRequest request = PrintableOuterClass.StatementRequest.newBuilder()
                    .setAcctNo(generateStatementRequest.getAcctNo())
                    .setFromdate(generateStatementRequest.getFromdate())
                    .setTodate(generateStatementRequest.getTodate())
                    .setEmail(email)
                    .setName(name)
                    .setAddress("N/A")
                    .setAccountType("Savings")
                    .build();
            PrintableGrpc.PrintableBlockingStub stub = PrintableGrpc.newBlockingStub(channel);
            response = stub.statementOfAccount(request);
        }catch (StatusRuntimeException e) {
            errorLoggingException.logError("PRINTABLE_STATUS_RUNTIME_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } catch (Exception e) {
            errorLoggingException.logError("PRINTABLE_EXCEPTION_HANDLER", String.valueOf(e.getCause()), e.getMessage());
        } finally {
            channel.shutdownNow();
        }
        return response;
    }
}
