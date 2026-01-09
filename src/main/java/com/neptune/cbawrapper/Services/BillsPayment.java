package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${bills.api.name}-bills-payment", url = "${bills.payment.api.base.url:199.85.210.4:30191/api/v1/}", configuration = CoreFeignClientConfig.class)
public interface BillsPayment {

    @GetMapping("/bill/categories")
    Categories getBillsCategories();

    @GetMapping("/bill/category-service/{categoryId}")
    CategoryServices getCategoryServices(@PathVariable("categoryId") String categoryId);

    @GetMapping("/bill/info/{billId}")
    BillInfo getBillerInfo(@PathVariable("billId") String billId);

    @PostMapping("/bill/validate-customer")
    Object validateCustomer(@RequestBody ValidateCustomerRequest request);

    @PostMapping("/bill/make-payment")
    MakePaymentApiResponse makePayment(@RequestBody MakePayment request);

}
