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
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/neptunepay")
public class OnboardingController {

    @Value("${grpc.debitCredit.webhook.url}")
    private String debitCredit_webhook_url;


    private static final Logger log = LoggerFactory.getLogger(OnboardingController.class);
    private final AuthCredentialsRepository authCredentialsRepository;
    private final AuthenticationService authenticationService;
    private final ErrorLoggingException errorLoggingException;


    public OnboardingController(AuthCredentialsRepository authCredentialsRepository, AuthenticationService authenticationService, ErrorLoggingException errorLoggingException) {
        this.authCredentialsRepository = authCredentialsRepository;
        this.authenticationService = authenticationService;
        this.errorLoggingException = errorLoggingException;
    }

    @PostMapping("/create-tms-account")
    public ResponseSchema createUser(@RequestBody CreateUser user) {
        try {
            System.out.println(user.getAddress());

            Auth.CreateUserResponse response = authenticationService.createUserAccount(user);

            log.info("response = {}", response);

            if (response == null) {
                return new ResponseSchema<>( 500, "Error occurred, kindly try again", response, "", ZonedDateTime.now(), false);
            }

            return new ResponseSchema<>( 200, "success", response, "", ZonedDateTime.now(), false);

        } catch (Exception e) {
            errorLoggingException.logError("CBA_ACCOUNT_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
        }
    }

    @GetMapping("/get-token-on-phone")
    public ResponseSchema getToken(@RequestParam String phoneNumber) {
        try {
            auth.Auth.OtpResponse response = authenticationService.getUserPhoneOtp(phoneNumber);
            log.info("response = {}", response);
            if (response == null) {
                return new ResponseSchema<>( 500, "Error occurred, kindly try again", null, "", ZonedDateTime.now(), false);
            }
            return new ResponseSchema<>( 200, "otp sent to phone number kindly use the otp shared to verify your phone number", null, "", ZonedDateTime.now(), false);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
        }
    }

    @GetMapping("/resend-token-on-email")
    public ResponseSchema resendEmailOtp(@RequestParam String email) {
        try {
            auth.Auth.OtpResponse response = authenticationService.resendEmailOtp(email);
            if (response == null) {
                return new ResponseSchema<>( 500, "Error occurred, kindly try again", null, "", ZonedDateTime.now(), false);
            }
            return new ResponseSchema<>( 200, "otp sent to email kindly use the otp shared to verify your email", null, "", ZonedDateTime.now(), false);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
        }
    }

    @PostMapping("/verify-email")
    public ResponseSchema verifyUserEmail(@RequestBody CreateUser user) {
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setEmail(user.getEmail());
            verifyUser.setOtp(user.getOtp());
            Auth.Empty response = authenticationService.verifyUserEmail(verifyUser);
            System.out.println("response = " + response);
            return new ResponseSchema<>( 200, "email verified successfully", null, "", ZonedDateTime.now(), false);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
        }
    }

    @PostMapping("/verify-phone")
    public ResponseSchema verifyUserPhone(@RequestBody CreateUser user) {
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setPhone(user.getPhone_number());
            verifyUser.setOtp(user.getOtp());
            Auth.Empty response = authenticationService.verifyUserPhone(verifyUser);
            return new ResponseSchema<>( 200, "phone number verified successfully", null, "", ZonedDateTime.now(), false);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
        }
    }

    @PostMapping("/login")
    public ResponseSchema login(@RequestBody CreateUser user) {
        try {
            VerifyUser verifyUser = new VerifyUser();
            verifyUser.setEmail(user.getEmail());
            verifyUser.setPassword(user.getPassword());
            Auth.LoginResponse response = authenticationService.loginUser(verifyUser);
            System.out.println("response = " + response);
            if (response == null) {
                return new ResponseSchema<>( 500, "Error occurred, kindly try again", null, "", ZonedDateTime.now(), false);
            }

            AuthCredentials authCredentials;
            Optional<AuthCredentials> credentials = authCredentialsRepository.getAuthByBusinessName(user.getBusiness_name());

            authCredentials = credentials.orElseGet(AuthCredentials::new);
            authCredentials.setEmail(user.getEmail());
            authCredentials.setToken(response.getAccessToken());
            authCredentials.setTwo_fa_token(response.getTwoFaToken());
            Auth.GenerateApiKeyResponse response1 = authenticationService.generateApiKey(response.getAccessToken());
            if (!StringUtils.isBlank(response1.getApiKey())) {
                authCredentials.setAPI_key(response1.getApiKey());
                authCredentials.setClient_id(response1.getClientId());
            }
            Auth.Get3ppUserDataResponse response2 = authenticationService.getUserData(response.getAccessToken());
            System.out.println("response2 = " + response2);
            if (response2.hasUser()) {
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

                if (checkIfWebhookUrlExists == null) {
                    authenticationService.createWebHookCba(response.getAccessToken(), debitCredit_webhook_url);
                } else if (!checkIfWebhookUrlExists.getUrl().equalsIgnoreCase(debitCredit_webhook_url)) {
                    authenticationService.createWebHookCba(response.getAccessToken(), debitCredit_webhook_url);
                }
            }
            authCredentialsRepository.save(authCredentials);

            return new ResponseSchema<>( 200, "Login successful", null, "", ZonedDateTime.now(), false);
        } catch (Exception e) {
            errorLoggingException.logError("CBA_CREATION", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from cba1 =: {}", e.getMessage());
            return new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
        }
    }


}