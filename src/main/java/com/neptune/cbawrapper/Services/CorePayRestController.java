package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.Models.PendingRequestResponse;
import com.neptune.cbawrapper.RequestRessponseSchema.CreateCustomerRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.CreateCustomerResponse;
import com.neptune.cbawrapper.RequestRessponseSchema.CustomerData;
import com.neptune.cbawrapper.RequestRessponseSchema.Dispute;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${corepay.api.name}-customer-service", url = "${corepay.api.base.url}", configuration = CoreFeignClientConfig.class)
public interface CorePayRestController {

    @GetMapping("/clients/business/pending-ex-sync")
    PendingRequestResponse getPending();

    @PutMapping("/deposits/bulk-wallet-sync")
    Object postCustomers(@RequestBody CustomerData customerData);

    @PostMapping("/clients")
    CreateCustomerResponse createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest);
}
