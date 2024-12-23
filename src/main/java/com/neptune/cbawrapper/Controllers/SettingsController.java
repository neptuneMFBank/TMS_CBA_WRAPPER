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
    private final TerminalProfileRepository terminalProfileRepository;
    private final MenuDataRepository menuDataRepository;
    private final MenuListRepository menuListRepository;
    private final TmsCoreWalletAccount tmsCoreWalletAccount;

    public SettingsController(TerminalProfileRepository terminalProfileRepository, MenuListRepository menuListRepository, MenuDataRepository menuDataRepository, TmsCoreWalletAccount tmsCoreWalletAccount) {
        this.terminalProfileRepository = terminalProfileRepository;
        this.menuDataRepository = menuDataRepository;
        this.menuListRepository = menuListRepository;
        this.tmsCoreWalletAccount = tmsCoreWalletAccount;
    }

    @GetMapping("/fetch-terminal-menu/{serialNo}")
    public ResponseEntity<ResponseSchema<?>> getMenuData(@PathVariable String serialNo) {
        Optional<TerminalProfileModel> data = terminalProfileRepository.getBySerialNo(serialNo);

        MenuDetails menuDetails = new MenuDetails();
        MenuData menuData = new MenuData();
        if(data.isPresent()) {
            Optional<MenuDataModel> menuDataModel = menuDataRepository.findBySerialNo(data.get().getSerialNo());
            List<MenuListModel> menuList = menuListRepository.findBySerialNo(serialNo);


            if(menuDataModel.isPresent()) {
                menuData.setId(data.get().getMenuId());
                menuData.setMenuName(menuDataModel.get().getMenuName());

                List<MenuList> menuLists = new ArrayList<>();
                for(MenuListModel menuListModel : menuList) {
                    MenuList menuList1 = new MenuList();
                    menuList1.setId(menuListModel.getId());
                    menuList1.setName(menuListModel.getName());
                    menuLists.add(menuList1);
                }
                menuData.setMenuList(menuLists);
                TerminalProfile terminalProfile = getTerminalProfile(serialNo, data);
                menuData.setTerminalProfile(null);
                menuDetails.setMenuData(menuData);
                menuDetails.setTerminalProfile(terminalProfile);
            }

            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "terminal data fetched successfully", menuDetails, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }else {
            menuDetails = tmsCoreWalletAccount.getTerminalMenus(serialNo);

            MenuDataModel menuDataModel = new MenuDataModel();
            menuDataModel.setMenuName(menuData.getMenuName());
            menuDataModel.setSerialNo(menuDetails.getTerminalProfile().getSerialNo());
            List<MenuListModel> menuListArray = new ArrayList<>();
            for (MenuList menuList1 : menuDetails.getMenuData().getMenuList()){
                MenuListModel menuListModel = new MenuListModel();
                menuListModel.setName(menuList1.getName());
                menuListModel.setSerialNo(serialNo);
                menuListRepository.save(menuListModel);
                menuListArray.add(menuListModel);
            }
            menuDataModel.setMenuListList(menuListArray);
            TerminalProfileModel terminalProfileModel = new TerminalProfileModel();
            terminalProfileModel.setSerialNo(serialNo);
            terminalProfileModel.setMenuId(menuDetails.getTerminalProfile().getMenuId());
            terminalProfileModel.setTerminalId(menuDetails.getTerminalProfile().getTerminalId());
            terminalProfileModel.setTerminalName(menuDetails.getTerminalProfile().getTerminalName());
            terminalProfileModel.setParentEntityName(menuDetails.getTerminalProfile().getParentEntityName());
            terminalProfileModel.setEntityType(menuDetails.getTerminalProfile().getEntityType());
            terminalProfileModel.setLogoId(menuDetails.getTerminalProfile().getLogoId());
            terminalProfileModel.setStatus(menuDetails.getTerminalProfile().getStatus());
            terminalProfileModel.setMerchantCode(menuDetails.getTerminalProfile().getMerchantCode());
            terminalProfileRepository.save(terminalProfileModel);
            menuDataModel.setTerminalProfile(terminalProfileModel);
            menuDataRepository.save(menuDataModel);

            ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "terminal data fetched successfully", menuDetails, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }
    }

    private static TerminalProfile getTerminalProfile(String serialNo, Optional<TerminalProfileModel> data) {
        TerminalProfile terminalProfile = new TerminalProfile();
        terminalProfile.setSerialNo(serialNo);
        terminalProfile.setId(data.get().getId());
        terminalProfile.setTerminalId(data.get().getTerminalId());
        terminalProfile.setParentEntityName(data.get().getParentEntityName());
        terminalProfile.setEntityType(data.get().getEntityType());
        terminalProfile.setMenuId(data.get().getMenuId());
        terminalProfile.setLogoId(data.get().getLogoId());
        terminalProfile.setMerchantCode(data.get().getMerchantCode());
        terminalProfile.setTerminalName(data.get().getTerminalName());
        terminalProfile.setStatus(data.get().getStatus());
        return terminalProfile;
    }

}
