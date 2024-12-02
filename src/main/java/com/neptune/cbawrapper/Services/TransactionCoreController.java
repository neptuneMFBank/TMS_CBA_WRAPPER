package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.RequestRessponseSchema.CorepayPosTransactionRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.TransactionRequestSchema;
import com.neptune.cbawrapper.RequestRessponseSchema.UpdateTransactionRequestSchema;
import com.neptune.cbawrapper.RequestRessponseSchema.UpdateTransactionResponseSchema;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "${corepay.api.name}", url = "${corepay.api.base.url}", configuration = CoreFeignClientConfig.class)
public interface TransactionCoreController {

    @PostMapping("/business/transactions")
    UpdateTransactionResponseSchema createTransaction(@RequestBody CorepayPosTransactionRequest requestSchema);

    @PutMapping("/business/transactions/{id}")
    UpdateTransactionResponseSchema updateTransaction(@PathVariable("id") String id, @RequestBody UpdateTransactionRequestSchema request);
}
