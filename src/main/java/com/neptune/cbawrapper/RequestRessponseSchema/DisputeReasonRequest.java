package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DisputeReasonRequest {
    private String reason;
    private String type;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
