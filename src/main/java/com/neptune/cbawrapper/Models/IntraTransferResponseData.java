package com.neptune.cbawrapper.Models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class IntraTransferResponseData {
    private String responsecode;
    private String responsemessage;

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getResponsemessage() {
        return responsemessage;
    }

    public void setResponsemessage(String responsemessage) {
        this.responsemessage = responsemessage;
    }
}
