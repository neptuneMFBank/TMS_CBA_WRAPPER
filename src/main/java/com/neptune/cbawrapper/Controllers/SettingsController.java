package com.neptune.cbawrapper.Controllers;

import com.neptune.cbawrapper.Models.VirtualAccountModel;
import com.neptune.cbawrapper.Repository.VirtualAccountRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.Cron;
import com.neptune.cbawrapper.Services.TmsCoreWalletAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/settings")
public class SettingsController {
    private final TmsCoreWalletAccount tmsCoreWalletAccount;
    private final PasswordEncoder passwordEncoder;
    private final VirtualAccountRepository virtualAccountRepository;
    private final Cron cron;

    public SettingsController(TmsCoreWalletAccount tmsCoreWalletAccount, Cron cron, VirtualAccountRepository virtualAccountRepository, PasswordEncoder passwordEncoder) {
        this.tmsCoreWalletAccount = tmsCoreWalletAccount;
        this.cron = cron;
        this.virtualAccountRepository = virtualAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/fetch-terminal-menu/{serialNo}")
    public ResponseEntity<ResponseSchema<?>> getMenuData(@PathVariable String serialNo) {
        MenuDetails menuDetails = tmsCoreWalletAccount.getTerminalMenus(serialNo);
        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "terminal data fetched successfully", menuDetails, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/set-password")
    public ResponseEntity<ResponseSchema<?>> setPassword(@RequestBody PinRequest request) {
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByGenericCode(request.getGenericCode());

        if(virtualAccountModel.isEmpty()){
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 404, "account number invalid", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        if(virtualAccountModel.get().getGenericCode().equalsIgnoreCase(request.getGenericCode())){
            if(LocalDateTime.parse(virtualAccountModel.get().getToken_expiry()).isBefore(LocalDateTime.now())){
                cron.sendPasswordMail(virtualAccountModel.get());

                ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "Password expired, kindly check your mail for new password link", "", "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.OK);
            }

            VirtualAccountModel virtualAccountModel1 = new VirtualAccountModel();
            String hashedPassword = passwordEncoder.encode(request.getPin());
            virtualAccountModel1.setPin(hashedPassword);
            virtualAccountRepository.save(virtualAccountModel1);

            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "Password set successfully", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        ResponseSchema<?> responseSchema = new ResponseSchema<>( 501, "Code mismatch", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
