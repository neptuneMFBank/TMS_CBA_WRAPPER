package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "${corepay.api.name}", url = "${corepay.api.base.url}", configuration = CoreFeignClientConfig.class)
public interface TransactionCoreController {

    @PostMapping("/business/transactions")
    UpdateTransactionResponseSchema createTransaction(@RequestBody TransactionDetails requestSchema);

    @PutMapping("/business/transactions/{id}")
    Object updateTransaction(@PathVariable("id") int id, @RequestBody UpdateTransactionRequestSchema request);
}
