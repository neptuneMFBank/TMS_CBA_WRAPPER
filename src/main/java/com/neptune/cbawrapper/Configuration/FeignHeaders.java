package com.neptune.cbawrapper.Configuration;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class FeignHeaders {
    @Value("${feign.auth}")
    private String feign_auth;

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic Y2Jhc2VydmljZWV4dDpwYXNzd29yZA=="); // Your base64-encoded credentials
        headers.put("Fineract-Platform-TenantId", "default");
        return headers;
    }
}
