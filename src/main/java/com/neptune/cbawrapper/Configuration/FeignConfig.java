package com.neptune.cbawrapper.Configuration;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FeignConfig {

    private final FeignHeaders feignHeaders;

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                feignHeaders.getHeaders().forEach(requestTemplate::header);
            }
        };
    }

}
