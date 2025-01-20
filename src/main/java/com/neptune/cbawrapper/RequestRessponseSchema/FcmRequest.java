package com.neptune.cbawrapper.RequestRessponseSchema;

public class FcmRequest {
    private String fcmToken;
    private String terminalId;

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public FcmRequest(String fcmToken, String terminalId) {
        this.fcmToken = fcmToken;
        this.terminalId = terminalId;
    }
}
