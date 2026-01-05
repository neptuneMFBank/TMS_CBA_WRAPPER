package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.Models.NameEnquiryRequest;
import com.neptune.cbawrapper.Models.NameEnquiryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${nameenquiry.api.name}-enquiry-api", url = "${nameenquiry.api.base.url:162.0.210.95:30209}", configuration = CoreFeignClientConfig.class)
public interface NameEnquiryAPI {

    @PostMapping("/client/name-enquiry")
    NameEnquiryResponse queryAccountEnquiry(NameEnquiryRequest nameEnquiryRequest);
}
