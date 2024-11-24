package com.neptune.cbawrapper.Configuration;

import java.util.HashMap;
import java.util.Map;

public class FeignHeaders {
    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic bWlmb3M6cGFzc3dvcmQ="); // Your base64-encoded credentials
        headers.put("Fineract-Platform-TenantId", "default");
        return headers;
    }
}
