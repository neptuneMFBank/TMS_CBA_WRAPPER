package com.neptune.cbawrapper.Controllers;

import auth.Auth;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.AuthCredentialsRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.AuthenticationService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/neptunepay")
public class OnboardingController {

    @Value("${grpc.debitCredit.webhook.url}")
    private String debitCredit_webhook_url;

    @Value("${spring.profiles.active}")
    private String env;


    private static final Logger log = LoggerFactory.getLogger(OnboardingController.class);
    private final AuthCredentialsRepository authCredentialsRepository;
    private final AuthenticationService authenticationService;
    private final ErrorLoggingException errorLoggingException;


    public OnboardingController(AuthCredentialsRepository authCredentialsRepository, AuthenticationService authenticationService, ErrorLoggingException errorLoggingException) {
        this.authCredentialsRepository = authCredentialsRepository;
        this.authenticationService = authenticationService;
        this.errorLoggingException = errorLoggingException;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create-tms-account")
    public ResponseEntity<ResponseSchema> createUser(@RequestBody CreateUser user) {
        try {
            System.out.println(user.getAddress());

            Auth.CreateUserResponse response = authenticationService.createUserAccount(user);

            log.info("response = {}", response);

            if (response == null) {
                errorLoggingException.logError("CBA_ACCOUNT_CREATION", "Error occurred, kindly try again", "Error occurred, kindly try again");
                ResponseSchema<?> responseSchema =  new ResponseSchema<>( 409, "Error occurred, kindly try again", response, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
            }

            CreateRes createRes = new CreateRes();
            createRes.setIdxb(response.getIdxsb());

            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "success", createRes, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_ACCOUNT_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-token-on-phone")
    public ResponseEntity<ResponseSchema<?>> getToken(@RequestParam String phoneNumber) {
        try {
            auth.Auth.OtpResponse response = authenticationService.getUserPhoneOtp(phoneNumber);
            log.info("response = {}", response);
            if (response == null) {
                errorLoggingException.logError("CBA_ACCOUNT_CREATION_GET_TOKEN_ON_PHONE", "Error occurred, kindly try again", "Error occurred, kindly try again");
                ResponseSchema<?> responseSchema = new ResponseSchema<>( 409, "Error occurred, kindly try again", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
            }
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "otp sent to phone number kindly use the otp shared to verify your phone number", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_ACCOUNT_CREATION_GET_TOKEN_ON_PHONE", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new  ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/resend-token-on-email")
    public ResponseEntity<ResponseSchema<?>> resendEmailOtp(@RequestParam String email) {
        try {
            auth.Auth.OtpResponse response = authenticationService.resendEmailOtp(email);
            if (response == null) {
                errorLoggingException.logError("CBA_ACCOUNT_CREATION_RESEND_TOKEN_ON_EMAIL", "Error occurred, kindly try again", "Error occurred, kindly try again");
                ResponseSchema<?> responseSchema = new ResponseSchema<>( 409, "Error occurred, kindly try again", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
            }
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "otp sent to email kindly use the otp shared to verify your email", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_ACCOUNT_CREATION_RESEND_TOKEN_ON_EMAIL", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/verify-email")
    public ResponseEntity<ResponseSchema<?>> verifyUserEmail(@RequestBody CreateUser user) {
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setEmail(user.getEmail());
            verifyUser.setOtp(user.getOtp());
            Auth.Empty response = authenticationService.verifyUserEmail(verifyUser);
            System.out.println("response = " + response);
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "email verified successfully", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION_VERIFY_EMAIL", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/verify-phone")
    public ResponseEntity<ResponseSchema<?>> verifyUserPhone(@RequestBody CreateUser user) {
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setPhone(user.getPhone_number());
            verifyUser.setOtp(user.getOtp());
            Auth.Empty response = authenticationService.verifyUserPhone(verifyUser);
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "phone number verified successfully", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION_VERIFY_PHONE", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<ResponseSchema<?>> login(@RequestBody CreateUser user) {
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setEmail(user.getEmail());
            verifyUser.setPassword(user.getPassword());
            System.out.println("verifyUser = " + verifyUser);
            Auth.LoginResponse response = authenticationService.loginUser(verifyUser);
            System.out.println("response = " + response);
            if (response == null) {
                errorLoggingException.logError("CBA_CREATION_LOGIN", "Error occurred, kindly try again", "Error occurred, kindly try again");
                ResponseSchema<?> responseSchema = new ResponseSchema<>( 409, "Error occurred, kindly try again", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
            }

            AuthCredentials authCredentials;
            Optional<AuthCredentials> credentials = authCredentialsRepository.getAuthByEmail(user.getEmail(), env);

            authCredentials = credentials.orElseGet(AuthCredentials::new);
            authCredentials.setEmail(user.getEmail());
            authCredentials.setToken(response.getAccessToken());
            authCredentials.setTwo_fa_token(response.getTwoFaToken());
            Auth.GenerateApiKeyResponse response1 = authenticationService.generateApiKey(response.getAccessToken());
            System.out.println("response1 = " + response1);
            if(response1 == null){
                errorLoggingException.logError("CBA_CREATION_LOGIN", "unable to create API key, kindly contact support", "unable to create API key, kindly contact support");
                log.error("error from cba1 =: {}", "unable to create API key, kindly contact support");
                ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, "unable to create API key, kindly contact support", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (!StringUtils.isBlank(response1.getApiKey())) {
                authCredentials.setAPI_key(response1.getApiKey());
                authCredentials.setClient_id(response1.getClientId());
            }
            Auth.Get3ppUserDataResponse response2 = authenticationService.getUserData(response.getAccessToken());
            System.out.println("response2 = " + response2);
            if (response2.hasUser()) {
                System.out.println("got here 1234567890");
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
                authCredentials.setEnv(env);

                Auth.Get3ppWebhookResponse checkIfWebhookUrlExists = authenticationService.get3ppWebhook(response.getAccessToken(), response2.getUser().getId());
                System.out.println("checkIfWebhookUrlExists = " + checkIfWebhookUrlExists);
                if (checkIfWebhookUrlExists == null) {
                    System.out.println("webhook 1");
                    authenticationService.createWebHookCba(response.getAccessToken(), debitCredit_webhook_url);
                } else if (!checkIfWebhookUrlExists.getUrl().equalsIgnoreCase(debitCredit_webhook_url)) {
                    System.out.println("webhook 2");
                    authenticationService.createWebHookCba(response.getAccessToken(), debitCredit_webhook_url);
                }
            }
            authCredentialsRepository.save(authCredentials);

            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "Login successful", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION_LOGIN", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
