package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Configuration.CoreFeignClientConfig;
import com.neptune.cbawrapper.RequestRessponseSchema.GenerateStatementRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.StatementResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${echannel.api.name}", url = "${echannel.api.base.url}", configuration = CoreFeignClientConfig.class)
public interface EchannelServices {

    @PostMapping
    StatementResponse generateStatement(@RequestBody GenerateStatementRequest request);
}
