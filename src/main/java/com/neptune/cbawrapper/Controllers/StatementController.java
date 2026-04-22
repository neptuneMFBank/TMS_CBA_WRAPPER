package com.neptune.cbawrapper.Controllers;

import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Models.CustomersModel;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import com.neptune.cbawrapper.Repository.VirtualAccountRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.GenerateStatementRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import com.neptune.cbawrapper.RequestRessponseSchema.SendNotifications;
import com.neptune.cbawrapper.Services.Notifications;
import com.neptune.cbawrapper.Services.PrintableAsyncService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import printable.PrintableOuterClass;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
public class StatementController {

    private final VirtualAccountRepository virtualAccountRepository;
    private final Helpers helpers;
    private final PrintableAsyncService printableAsyncService;  // Inject the async service
    private final Notifications notifications;

    public StatementController(
            VirtualAccountRepository virtualAccountRepository,
            Helpers helpers,
            PrintableAsyncService printableAsyncService,  // Change this
            Notifications notifications) {
        this.virtualAccountRepository = virtualAccountRepository;
        this.helpers = helpers;
        this.printableAsyncService = printableAsyncService;
        this.notifications = notifications;
    }

    @PostMapping("/generate-statement")
    public ResponseEntity<ResponseSchema<?>> generateStatement(
            @Valid @RequestBody GenerateStatementRequest request) {

        log.info("=== CONTROLLER STARTED === Thread: {}", Thread.currentThread().getName());

        // Validate account
        Optional<VirtualAccountModel> accountModel =
                virtualAccountRepository.getVirtualAccountModelByAccount(request.getAcctNo());

        if (accountModel.isEmpty()) {
            log.warn("Account not found: {}", request.getAcctNo());
            ResponseSchema<?> responseSchema = new ResponseSchema<>(
                    404, "Account not found", null, "", ZonedDateTime.now(), false
            );
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        // Validate customer
        Optional<CustomersModel> customersModel =
                helpers.getCustomerBySavingsId(accountModel.get().getBusinessSavingsId());

        if (customersModel.isEmpty()) {
            log.warn("Customer not found for account: {}", request.getAcctNo());
            ResponseSchema<?> responseSchema = new ResponseSchema<>(
                    404, "Customer not found", null, "", ZonedDateTime.now(), false
            );
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }
        String email = customersModel.get().getEmail_address();
        System.out.println("customersModel = " + email);

        try {
            log.info("=== CALLING ASYNC METHOD ===");
            long startTime = System.currentTimeMillis();
            System.out.println("customersModel.get().getEmailAddress() = " + email);

            // Call async method from SEPARATE service (not same class)
            CompletableFuture<PrintableOuterClass.StatementOfAccountResponse> futureResponse =
                    printableAsyncService.generateStateAsync(
                            request,
                            email,
                            accountModel.get().getAccount_name()
                    );

            log.info("=== WAITING FOR RESPONSE (max 60s) ===");

            // Wait for up to 60 seconds for the response
            PrintableOuterClass.StatementOfAccountResponse res =
                    futureResponse.get(60, TimeUnit.SECONDS);

            System.out.println("res = " + res);

            long duration = System.currentTimeMillis() - startTime;
            log.info("=== RECEIVED RESPONSE === Duration: {}ms, IsNull: {}", duration, res == null);

            if (res != null && res.getPdf() != null && !res.getPdf().isEmpty()) {
                log.info("=== SENDING NOTIFICATION ===");

                System.out.println("pdf = " + res.getPdf());
                System.out.println("email = " + email);

                // Send notification
                SendNotifications notifications1 = SendNotifications.builder()
                        .title("Statement Of Account")
                        .file(res.getPdf())
                        .receiver_email(email)
                        .sendmail(true)
                        .attachment(true)
                        .build();

                notification_service.Notifications.NotificationResponse notificationResponse =
                        notifications.sendNotification(notifications1);

                log.info("=== NOTIFICATION SENT === Response: {}", notificationResponse);

                ResponseSchema<?> responseSchema = new ResponseSchema<>(
                        200,
                        "Statement of account sent to your business email",
                        null,
                        "",
                        ZonedDateTime.now(),
                        true
                );
                return new ResponseEntity<>(responseSchema, HttpStatus.OK);
            }

            log.warn("=== STATEMENT GENERATION FAILED === Response was null or empty");
            ResponseSchema<?> responseSchema = new ResponseSchema<>(
                    400,
                    "Failed to generate statement. Please try again later",
                    null,
                    "",
                    ZonedDateTime.now(),
                    false
            );
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);

        } catch (TimeoutException e) {
            log.error("=== TIMEOUT AFTER 60 SECONDS ===", e);
            ResponseSchema<?> responseSchema = new ResponseSchema<>(
                    408,
                    "Statement generation timeout. Please try again later",
                    null,
                    "",
                    ZonedDateTime.now(),
                    false
            );
            return new ResponseEntity<>(responseSchema, HttpStatus.REQUEST_TIMEOUT);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("=== INTERRUPTED ===", e);
            ResponseSchema<?> responseSchema = new ResponseSchema<>(
                    500,
                    "Statement generation interrupted",
                    null,
                    "",
                    ZonedDateTime.now(),
                    false
            );
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (ExecutionException e) {
            log.error("=== EXECUTION ERROR ===", e.getCause());
            ResponseSchema<?> responseSchema = new ResponseSchema<>(
                    500,
                    "Error generating statement: " + e.getCause().getMessage(),
                    null,
                    "",
                    ZonedDateTime.now(),
                    false
            );
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
