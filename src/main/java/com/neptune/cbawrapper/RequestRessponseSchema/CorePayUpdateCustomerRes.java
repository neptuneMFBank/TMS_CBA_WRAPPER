package com.neptune.cbawrapper.RequestRessponseSchema;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CorePayUpdateCustomerRes {
    private String requestResponse;

    public String getRequestResponse() {
        return requestResponse;
    }

    public void setRequestResponse(String requestResponse) {
        this.requestResponse = requestResponse;
    }

    @JsonCreator
    public CorePayUpdateCustomerRes(@JsonProperty("requestResponse") String requestResponse) {
        this.requestResponse = requestResponse;
    }


}
