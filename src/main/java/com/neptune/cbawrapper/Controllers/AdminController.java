package com.neptune.cbawrapper.Controllers;

import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import com.neptune.cbawrapper.Repository.VirtualAccountRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.Cron;
import com.neptune.cbawrapper.Services.Notifications;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Value("${admin.pin.reset.otp.expiry.minutes:10}")
    private long adminPinResetOtpExpiryMinutes;

    @Value("${admin.pin.support.bypass.minutes:6}")
    private long supportBypassMinutes;

    @Value("${admin.pin.support.fallback}")
    private String adminPinSupportFallback;

    private final VirtualAccountRepository virtualAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final Helpers helpers;
    private final Notifications notifications;

    public AdminController(VirtualAccountRepository virtualAccountRepository, PasswordEncoder passwordEncoder, Helpers helpers, Notifications notifications) {
        this.virtualAccountRepository = virtualAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.helpers = helpers;
        this.notifications = notifications;
    }

    // ==============================
    // Terminal Setup Code (Agent Setup Verification) - PRD Section 3.1
    // ==============================
    @CrossOrigin(origins = "*")
    @PostMapping("/validate-otp")
    public ResponseEntity<ResponseSchema<?>> validateOtp(@RequestBody ValidateOtpRequest request) {
        System.out.println("request = " + request.toString());
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid terminal id", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        boolean matches = passwordEncoder.matches(request.getOtp(), virtualAccountModel.get().getOtp());

        if (!matches) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "invalid otp", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        if (Boolean.FALSE.equals(virtualAccountModel.get().getOtpUsed())) {
            virtualAccountModel.get().setOtpUsed(true);
            virtualAccountRepository.save(virtualAccountModel.get());

            logAudit(request.getTerminalId(), "SETUP_CODE_VALIDATION", "SYSTEM", "SUCCESS");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "otp validated successfully", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        logAudit(request.getTerminalId(), "SETUP_CODE_VALIDATION", "SYSTEM", "FAILED_ALREADY_USED");

        ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "otp already used", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
    }

    // ==============================
    // First-Time Admin PIN Setup - PRD Section 3.2
    // ==============================
    @CrossOrigin(origins = "*")
    @PostMapping("/create-admin-pin")
    public ResponseEntity<ResponseSchema<?>> createAdminPin(@RequestBody CreateAdminPinRequest request) {
        System.out.println("request = " + request.toString());
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid terminal id", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        if (!Boolean.TRUE.equals(virtualAccountModel.get().getOtpUsed())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "setup code has not been verified for this terminal", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isNotBlank(virtualAccountModel.get().getAdminPin())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "admin pin has already been set for this terminal", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(request.getAdminPin()) || !request.getAdminPin().equals(request.getConfirmAdminPin())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "admin pin and confirmation pin do not match", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        String hashedAdminPin = passwordEncoder.encode(request.getAdminPin());
        virtualAccountModel.get().setAdminPin(hashedAdminPin);
        virtualAccountRepository.save(virtualAccountModel.get());

        logAudit(request.getTerminalId(), "ADMIN_PIN_CREATED", "SYSTEM", "SUCCESS");

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "admin pin created successfully", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    // ==============================
    // Daily Access to Admin Settings - PRD Section 3.3
    // ==============================
    @CrossOrigin(origins = "*")
    @PostMapping("/authenticate-admin-pin")
    public ResponseEntity<ResponseSchema<?>> authenticateAdminPin(@RequestBody AuthenticateAdminPinRequest request) {
        System.out.println("request = " + request.toString());
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid terminal id", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        // Internal Neptune Support fallback PIN - grants access on any terminal for field maintenance
        if (StringUtils.isNotBlank(adminPinSupportFallback) && adminPinSupportFallback.equals(request.getAdminPin())) {
            logAudit(request.getTerminalId(), "ADMIN_PIN_AUTHENTICATION", "NEPTUNE_SUPPORT_FALLBACK", "SUCCESS");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "authenticated successfully", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        if (StringUtils.isBlank(virtualAccountModel.get().getAdminPin())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "admin pin has not been set for this terminal", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        boolean matches = passwordEncoder.matches(request.getAdminPin(), virtualAccountModel.get().getAdminPin());

        if (!matches) {
            logAudit(request.getTerminalId(), "ADMIN_PIN_AUTHENTICATION", "SYSTEM", "FAILED");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(401, "invalid admin pin", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.UNAUTHORIZED);
        }

        logAudit(request.getTerminalId(), "ADMIN_PIN_AUTHENTICATION", "SYSTEM", "SUCCESS");

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "authenticated successfully", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    // ==============================
    // Admin PIN Recovery - Automated OTP Recovery (SMS) - PRD Section 3.5.1
    // ==============================
    @CrossOrigin(origins = "*")
    @PostMapping("/forgot-admin-pin")
    public ResponseEntity<ResponseSchema<?>> forgotAdminPin(@RequestBody ForgotAdminPinRequest request) {
        System.out.println("request = " + request.toString());
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid terminal id", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(virtualAccountModel.get().getPhone_number())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "no phone number is registered for this terminal", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        try {
            String token = Cron.generateRandom8DigitNumber();
            String hashedToken = passwordEncoder.encode(token);

            virtualAccountModel.get().setAdminPinResetOtp(hashedToken);
            virtualAccountModel.get().setAdminPinResetOtpExpiry(LocalDateTime.now().plusMinutes(adminPinResetOtpExpiryMinutes).toString());
            virtualAccountRepository.save(virtualAccountModel.get());

            String phoneNumber = helpers.normalizePhoneNumber(virtualAccountModel.get().getPhone_number());
            String message = "Your OTP to reset your Admin PIN is " + token + ". It expires in " + adminPinResetOtpExpiryMinutes + " minutes. Do not share this code with anyone.";

            SendNotifications notification = SendNotifications.builder()
                    .title("Admin PIN Reset OTP")
                    .message(message)
                    .receiverPhoneNumber(phoneNumber)
                    .receiverPhoneCountry("234")
                    .sendtext(true)
                    .sendmail(false)
                    .attachment(false)
                    .file("")
                    .build();

            notifications.sendNotification(notification);

            logAudit(request.getTerminalId(), "ADMIN_PIN_RESET_OTP_SENT", "SYSTEM", "SUCCESS");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "otp sent successfully", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Failed to send admin pin reset otp for terminal: {}", request.getTerminalId(), e);
            logAudit(request.getTerminalId(), "ADMIN_PIN_RESET_OTP_SENT", "SYSTEM", "FAILED");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "failed to send otp", "", e.getMessage(), ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ==============================
    // Admin PIN Recovery - Reset (via OTP or Support Bypass) - PRD Section 3.4 / 3.5
    // ==============================
    @CrossOrigin(origins = "*")
    @PostMapping("/reset-admin-pin")
    public ResponseEntity<ResponseSchema<?>> resetAdminPin(@RequestBody ResetAdminPinRequest request) {
        System.out.println("request = " + request.toString());
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid terminal id", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(request.getNewAdminPin()) || !request.getNewAdminPin().equals(request.getConfirmAdminPin())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "admin pin and confirmation pin do not match", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        VirtualAccountModel account = virtualAccountModel.get();
        boolean bypassValid = Boolean.TRUE.equals(account.getBypassActive())
                && StringUtils.isNotBlank(account.getBypassExpiry())
                && LocalDateTime.parse(account.getBypassExpiry()).isAfter(LocalDateTime.now());

        if (bypassValid) {
            String bypassAgentId = account.getBypassAgentId();

            account.setAdminPin(passwordEncoder.encode(request.getNewAdminPin()));
            account.setBypassActive(false);
            account.setBypassExpiry(null);
            account.setBypassAgentId(null);
            virtualAccountRepository.save(account);

            logAudit(request.getTerminalId(), "ADMIN_PIN_RESET_VIA_SUPPORT_BYPASS", bypassAgentId, "SUCCESS");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "admin pin reset successfully", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        if (StringUtils.isBlank(account.getAdminPinResetOtp())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "no otp requested, kindly request an otp first", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(account.getAdminPinResetOtpExpiry()) || LocalDateTime.parse(account.getAdminPinResetOtpExpiry()).isBefore(LocalDateTime.now())) {
            logAudit(request.getTerminalId(), "ADMIN_PIN_RESET_VIA_OTP", "SYSTEM", "FAILED_EXPIRED_OTP");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "otp has expired, kindly request a new one", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        if (!passwordEncoder.matches(request.getOtp(), account.getAdminPinResetOtp())) {
            logAudit(request.getTerminalId(), "ADMIN_PIN_RESET_VIA_OTP", "SYSTEM", "FAILED_INVALID_OTP");

            ResponseSchema<?> responseSchema = new ResponseSchema<>(401, "invalid otp", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.UNAUTHORIZED);
        }

        account.setAdminPin(passwordEncoder.encode(request.getNewAdminPin()));
        account.setAdminPinResetOtp(null);
        account.setAdminPinResetOtpExpiry(null);
        virtualAccountRepository.save(account);

        logAudit(request.getTerminalId(), "ADMIN_PIN_RESET_VIA_OTP", "SYSTEM", "SUCCESS");

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "admin pin reset successfully", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    // ==============================
    // Support-Assisted Recovery Bypass - PRD Section 3.5.2 / 4
    // ==============================
    @CrossOrigin(origins = "*")
    @PostMapping("/support-bypass")
    public ResponseEntity<ResponseSchema<?>> supportBypass(@RequestBody SupportBypassRequest request) {
        System.out.println("request = " + request.toString());
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid terminal id", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(request.getSupportAgentId())) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "support agent name/id is required to authorize a bypass", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        VirtualAccountModel account = virtualAccountModel.get();
        account.setBypassActive(true);
        account.setBypassAgentId(request.getSupportAgentId());
        account.setBypassExpiry(LocalDateTime.now().plusMinutes(supportBypassMinutes).toString());
        virtualAccountRepository.save(account);

        logAudit(request.getTerminalId(), "SUPPORT_BYPASS_ACTIVATION", request.getSupportAgentId(), "SUCCESS");

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "support bypass activated, expires in " + supportBypassMinutes + " minutes", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    // ==============================
    // Audit Trail - PRD Section 4 (Audit Trail Requirements)
    // Records: Terminal ID, Action Type, Support Agent Identifier, Timestamp, Status
    // ==============================
    private void logAudit(String terminalId, String action, String agentIdentifier, String status) {
        log.info("AUDIT | terminalId={} | action={} | agent={} | status={} | timestamp={}",
                terminalId, action, agentIdentifier, status, ZonedDateTime.now());
    }
}
