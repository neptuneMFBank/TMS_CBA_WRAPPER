package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.Models.NameEnquiryRequest;
import com.neptune.cbawrapper.Models.NameEnquiryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${nameenquiry.api.name}-enquiry-api", url = "${nameenquiry.api.base.url}", configuration = CoreFeignClientConfig.class)
public interface NameEnquiryAPI {

    @PostMapping("/client/name-enquiry")
    NameEnquiryResponse queryAccountEnquiry(@RequestBody NameEnquiryRequest nameEnquiryRequest);
}
