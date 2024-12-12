package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

@Data
public class WebHook {
    private String url;
    private String event;
    private String payload;
}
