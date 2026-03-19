package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.RequestRessponseSchema.GenerateStatementRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import printable.PrintableOuterClass;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class PrintableAsyncService {
    private final Printable printable;

    public PrintableAsyncService(Printable printable) {
        this.printable = printable;
    }

    @Async("statementExecutor")
    public CompletableFuture<PrintableOuterClass.StatementOfAccountResponse> generateStateAsync(
            GenerateStatementRequest request,
            String email,
            String name) {

        log.info("=== ASYNC METHOD STARTED === Thread: {}", Thread.currentThread().getName());

        try {
            // This will wait up to 60 seconds due to gRPC deadline
            PrintableOuterClass.StatementOfAccountResponse response =
                    printable.generateState(request, email, name);

            log.info("=== ASYNC METHOD COMPLETED === Response: {}", response != null);
            return CompletableFuture.completedFuture(response);

        } catch (Exception e) {
            log.error("=== ASYNC METHOD FAILED ===", e);
            return CompletableFuture.completedFuture(null);
        }
    }
}
