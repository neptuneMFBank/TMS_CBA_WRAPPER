package com.neptune.cbawrapper.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignHeadersConfig {

    @Bean
    public FeignHeaders feignHeaders() {
        return new FeignHeaders();
    }
}
