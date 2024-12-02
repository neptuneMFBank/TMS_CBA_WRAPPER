package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.Models.PendingRequestResponse;
import com.neptune.cbawrapper.Models.PendingTerminalData;
import com.neptune.cbawrapper.RequestRessponseSchema.CustomerData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "${corepay.api.name}-tms-service", url = "${corepay.api.base.url}", configuration = CoreFeignClientConfig.class)
public interface TmsCoreWalletAccount {

    @GetMapping("/business/terminals/pending-wallet-sync")
    List<PendingTerminalData> getPending();

    @PutMapping("/business/terminals/bulk-wallet-update")
    List<PendingTerminalData> postWallets(@RequestBody CustomerData customerData);
}
