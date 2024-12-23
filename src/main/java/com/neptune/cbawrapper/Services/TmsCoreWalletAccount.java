package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.Models.PendingRequestResponse;
import com.neptune.cbawrapper.Models.PendingTerminalData;
import com.neptune.cbawrapper.RequestRessponseSchema.CustomerData;
import com.neptune.cbawrapper.RequestRessponseSchema.MenuData;
import com.neptune.cbawrapper.RequestRessponseSchema.MenuDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${corepay.api.name}-tms-service", url = "${corepay.api.base.url}", configuration = CoreFeignClientConfig.class)
public interface TmsCoreWalletAccount {

    @GetMapping("/business/terminals/pending-wallet-sync")
    List<PendingTerminalData> getPending();

    @PutMapping("/business/terminals/bulk-wallet-update")
    Object postWallets(@RequestBody CustomerData customerData);

    @GetMapping("/business/terminals/{serialNo}/settings")
    MenuDetails getTerminalMenus(@PathVariable("serialNo") String serialNo);
}
