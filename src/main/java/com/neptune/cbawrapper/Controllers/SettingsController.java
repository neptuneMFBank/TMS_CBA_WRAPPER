package com.neptune.cbawrapper.Controllers;

import com.neptune.cbawrapper.Models.MenuDataModel;
import com.neptune.cbawrapper.Models.MenuListModel;
import com.neptune.cbawrapper.Models.TerminalProfileModel;
import com.neptune.cbawrapper.Repository.MenuDataRepository;
import com.neptune.cbawrapper.Repository.MenuListRepository;
import com.neptune.cbawrapper.Repository.TerminalProfileRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.TmsCoreWalletAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/settings")
public class SettingsController {
    private final TmsCoreWalletAccount tmsCoreWalletAccount;

    public SettingsController(TmsCoreWalletAccount tmsCoreWalletAccount) {
        this.tmsCoreWalletAccount = tmsCoreWalletAccount;
    }

    @GetMapping("/fetch-terminal-menu/{serialNo}")
    public ResponseEntity<ResponseSchema<?>> getMenuData(@PathVariable String serialNo) {
        MenuDetails menuDetails = tmsCoreWalletAccount.getTerminalMenus(serialNo);
        ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "terminal data fetched successfully", menuDetails, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

}
