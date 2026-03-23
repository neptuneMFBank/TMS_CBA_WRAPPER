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

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class Printable {

    private final ErrorLoggingException errorLoggingException;

    @Value("${grpc.printable.url}")
    private String printable_server_ip;

    @Value("${grpc.printable.port}")
    private int printable_server_port;

    public PrintableOuterClass.StatementOfAccountResponse generateState(
            GenerateStatementRequest generateStatementRequest,
            String email,
            String name) {

        System.out.println("email = " + email);
        System.out.println("generateStatementRequest.getAcctNo() = " + generateStatementRequest.getAcctNo());
        System.out.println("generateStatementRequest.getFromdate() = " + generateStatementRequest.getFromdate());
        System.out.println("generateStatementRequest.getTodate() = " + generateStatementRequest.getTodate());
        System.out.println("name = " + name);

        log.info("=== STARTING GRPC CALL === Thread: {}", Thread.currentThread().getName());

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(printable_server_ip, printable_server_port)
                .usePlaintext()
                .maxInboundMessageSize(10 * 1024 * 1024)
                .build();

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

            // IMPORTANT: Add deadline to gRPC stub
            PrintableGrpc.PrintableBlockingStub stub = PrintableGrpc.newBlockingStub(channel)
                    .withDeadlineAfter(60, TimeUnit.SECONDS);

            log.info("=== CALLING GRPC SERVICE ===");
            long startTime = System.currentTimeMillis();

            response = stub.statementOfAccount(request);

            long duration = System.currentTimeMillis() - startTime;
            log.info("=== GRPC CALL COMPLETED === Duration: {}ms", duration);

        } catch (StatusRuntimeException e) {
            log.error("=== GRPC ERROR === Status: {}, Message: {}", e.getStatus(), e.getMessage());
            errorLoggingException.logError("PRINTABLE_STATUS_RUNTIME_EXCEPTION_HANDLER",
                    String.valueOf(e.getCause()), e.getMessage());

        } catch (Exception e) {
            log.error("=== GENERAL ERROR ===", e);
            errorLoggingException.logError("PRINTABLE_EXCEPTION_HANDLER",
                    String.valueOf(e.getCause()), e.getMessage());

        } finally {
            try {
                if (!channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)) {
                    channel.shutdownNow();
                }
            } catch (InterruptedException e) {
                channel.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

        log.info("=== RETURNING RESPONSE === IsNull: {}", response == null);
        return response;
    }
}