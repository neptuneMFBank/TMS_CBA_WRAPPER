package com.neptune.cbawrapper.Controllers;

import auth.Auth;
import com.neptune.cba.transaction.debit_credit.DebitCreditResponse;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.AuthCredentials;
import com.neptune.cbawrapper.Models.Transactions;
import com.neptune.cbawrapper.Models.VerifyUser;
import com.neptune.cbawrapper.Repository.AuthCredentialsRepository;
import com.neptune.cbawrapper.Repository.TransactionsRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.CreateUser;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import com.neptune.cbawrapper.Services.AuthenticationService;
import com.neptune.cbawrapper.Services.CustomerService;
import com.neptune.cbawrapper.Services.DebitCreditService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class Requests {

    @Value("${grpc.debitCredit.webhook.url}")
    private String debitCredit_webhook_url;

    private static final Logger log = LoggerFactory.getLogger(Requests.class);
    private final CustomerService customerService;
    private final AuthCredentialsRepository authCredentialsRepository;
    private final AuthenticationService authenticationService;
    private final DebitCreditService debitCreditService;
    private final ErrorLoggingException errorLoggingException;
    private final TransactionsRepository transactionsRepository;

    public Requests(CustomerService customerService, TransactionsRepository transactionsRepository, DebitCreditService debitCreditService, AuthCredentialsRepository authCredentialsRepository, AuthenticationService authenticationService, ErrorLoggingException errorLoggingException) {
        this.customerService = customerService;
        this.transactionsRepository = transactionsRepository;
        this.debitCreditService = debitCreditService;
        this.authCredentialsRepository = authCredentialsRepository;
        this.authenticationService = authenticationService;
        this.errorLoggingException = errorLoggingException;
    }

    @PostMapping("/create-tms-account")
    public ResponseSchema createUser(@RequestBody CreateUser user){
        try {
            System.out.println(user.getAddress());

            Auth.CreateUserResponse response = authenticationService.createUserAccount(user);

            log.info("response = {}", response);

            if(response == null){
                return new ResponseSchema("Error occurred, kindly try again", 500, ZonedDateTime.now(), response);
            }

            return new ResponseSchema("success", 200, ZonedDateTime.now(), response);

        } catch (Exception e) {
            errorLoggingException.logError("CBA_ACCOUNT_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
        }
    }

    @GetMapping("/get-token-on-phone")
    public ResponseSchema getToken(@RequestParam String phoneNumber){
        try {
            auth.Auth.OtpResponse response = authenticationService.getUserPhoneOtp(phoneNumber);
            log.info("response = {}", response);
            if(response == null){
                return new ResponseSchema("Error occurred, kindly try again", 500, ZonedDateTime.now(), null);
            }
            return new ResponseSchema(response.getIdxsb(), 200, "otp sent to phone number kindly use the otp shared to verify your phone number", ZonedDateTime.now());
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
        }
    }

    @GetMapping("/resend-token-on-email")
    public ResponseSchema resendEmailOtp(@RequestParam String email){
       try {
           auth.Auth.OtpResponse response = authenticationService.resendEmailOtp(email);
           if(response == null){
               return new ResponseSchema("Error occurred, kindly try again", 500, ZonedDateTime.now(), response);
           }
           return new ResponseSchema("otp sent to email kindly use the otp shared to verify your email", 200, ZonedDateTime.now(), response);
       } catch (Exception e) {
           errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
           log.error("error from cba1 =: {}", e.getMessage());
           return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
       }
    }

    @PostMapping("/verify-email")
    public ResponseSchema verifyUserEmail(@RequestBody CreateUser user){
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setEmail(user.getEmail());
            verifyUser.setOtp(user.getOtp());
            Auth.Empty response = authenticationService.verifyUserEmail(verifyUser);
            System.out.println("response = " + response);
            return new ResponseSchema("email verified successfully",200, ZonedDateTime.now(), null);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
        }
    }

    @PostMapping("/verify-phone")
    public ResponseSchema verifyUserPhone(@RequestBody CreateUser user){
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setPhone(user.getPhone_number());
            verifyUser.setOtp(user.getOtp());
            Auth.Empty response = authenticationService.verifyUserPhone(verifyUser);
            return new ResponseSchema( "phone number verified successfully",200, ZonedDateTime.now(), null);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
        }
    }

    @PostMapping("/login")
    public ResponseSchema login(@RequestBody CreateUser user){
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setEmail(user.getEmail());
            verifyUser.setPassword(user.getPassword());
            Auth.LoginResponse response = authenticationService.loginUser(verifyUser);
            System.out.println("response = " + response);
            if(response == null){
                return new ResponseSchema( "Error occurred please try again",500, ZonedDateTime.now(), null);
            }

            AuthCredentials authCredentials;
            Optional<AuthCredentials> credentials = authCredentialsRepository.getAuthByBusinessName(user.getBusiness_name());

            authCredentials = credentials.orElseGet(AuthCredentials::new);
            authCredentials.setEmail(user.getEmail());
            authCredentials.setToken(response.getAccessToken());
            authCredentials.setTwo_fa_token(response.getTwoFaToken());
            Auth.GenerateApiKeyResponse response1 = authenticationService.generateApiKey(response.getAccessToken());
            if(!StringUtils.isBlank(response1.getApiKey())){
                authCredentials.setAPI_key(response1.getApiKey());
                authCredentials.setClient_id(response1.getClientId());
            }
            Auth.Get3ppUserDataResponse response2 = authenticationService.getUserData(response.getAccessToken());
            System.out.println("response2 = " + response2);
            if(response2.hasUser()){
                authCredentials.setFirst_name(response2.getUser().getFirstName());
                authCredentials.setLast_name(response2.getUser().getLastName());
                authCredentials.setBusiness_name(response2.getUser().getBusinessName());
                authCredentials.setPhone_number(response2.getUser().getPhoneNumber());
                authCredentials.setPhone_number_verified(response2.getUser().getPhoneNumberVerified());
                authCredentials.setActive_status(response2.getUser().getActiveStatus());
                authCredentials.setEmail_verified(response2.getUser().getEmailVerified());
                authCredentials.setCustomer_id(response2.getUser().getId());
                authCredentials.setBvn_verified(response2.getUser().getBvnVerified());
                authCredentials.setStatus(response2.getUser().getStatus());
                authCredentials.setChannel_code(response2.getUser().getChannelCode());
                authCredentials.setSettlement_account_number(response2.getUser().getSettlementAccountNumber());
                authCredentials.setCreated_at(response2.getUser().getCreatedAt());
                authCredentials.setUpdated_at(response2.getUser().getUpdatedAt());

                Auth.Get3ppWebhookResponse checkIfWebhookUrlExists = authenticationService.get3ppWebhook(response.getAccessToken(), response2.getUser().getId());

                if(checkIfWebhookUrlExists == null){
                    authenticationService.createWebHookCba(response.getAccessToken(), debitCredit_webhook_url);
                }else if(!checkIfWebhookUrlExists.getUrl().equalsIgnoreCase(debitCredit_webhook_url)){
                    authenticationService.createWebHookCba(response.getAccessToken(), debitCredit_webhook_url);
                }
            }
            authCredentialsRepository.save(authCredentials);

            return new ResponseSchema(  "Login successful",200, ZonedDateTime.now(), null);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
        }
    }

    @PostMapping("/credit-debit-account")
    public ResponseSchema creditDebitAcct(@RequestBody VerifyUser verifyUser){
        try {

            DebitCreditResponse response = debitCreditService.debitCredit(verifyUser);
            if(response == null){
                errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_1", "response is null", "no response returned");
                log.error("error from debit credit =: {}","response is null");
                return new ResponseSchema("error occurred please try again", 500, ZonedDateTime.now(), null);
            }
            return new ResponseSchema("success", 200, ZonedDateTime.now(), response);
        } catch (Exception e) {
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from debit credit1 =: {}", e.getMessage());
            return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
        }
    }

    @PostMapping("/pos-credit-webhook")
    public ResponseSchema getCreditUpdate(VerifyUser verifyUser){
        try {
            Optional<Transactions> checkIfTransactionWithRefExists = transactionsRepository.checkIfTransactionWithRefExists(verifyUser.getRef());

            Transactions transactions;
            if(checkIfTransactionWithRefExists.isEmpty()) {
                transactions = new Transactions();
                transactions.setEvent(verifyUser.getEvent());
                transactions.setMessage(verifyUser.getMessage());
                transactions.setStatus("Pending");
                transactions.setAccount(verifyUser.getAccount());
                transactions.setRef(verifyUser.getRef());
            }else {
                transactions = checkIfTransactionWithRefExists.get();
                transactions.setAmount(verifyUser.getAmount());
                transactions.setEvent(verifyUser.getEvent());
            }
            transactionsRepository.save(transactions);
            String event;
            int status_code;

            if(verifyUser.getEvent().equalsIgnoreCase("transaction.init")){
                event = "Transaction initialized";
                status_code = 201;
            }else if ((verifyUser.getEvent().equalsIgnoreCase("transaction.successful"))){
                event = "Transaction successful";
                status_code = 200;
            }else if(verifyUser.getEvent().equalsIgnoreCase("transaction.failed")) {
                event = "Transaction failed";
                status_code = 500;
            }else {
                event = "Unknown event occured";
                status_code = 500;
            }

            return new ResponseSchema(event, status_code, ZonedDateTime.now(), null);
        } catch (Exception e) {
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from debit credit1 =: {}", e.getMessage());
            return new ResponseSchema(e.getMessage(), 500, ZonedDateTime.now(), null);
        }
    }

    @GetMapping("/pending-transactions-notification")
    public ResponseSchema<List<Transactions>> posTransactionNotification(){
        ResponseSchema<List<Transactions>> response = new ResponseSchema<>();
        try {
            List<Transactions> checkTransactionStatus = transactionsRepository.checkTransactionStatus("pending");

            if(checkTransactionStatus.isEmpty()){
                return new ResponseSchema<>();
            }

            for (Transactions t : checkTransactionStatus) {
                t.setStatus("approved");
                transactionsRepository.save(t);
            }
            response = new ResponseSchema<>("success", 200, ZonedDateTime.now(), checkTransactionStatus);

        } catch (Exception e) {
            System.out.println("hello world");
        }
        return response;
    }

}

