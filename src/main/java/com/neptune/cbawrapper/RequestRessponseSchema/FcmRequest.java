package com.neptune.cbawrapper.RequestRessponseSchema;

public class FcmRequest {
    private String fcmToken;
    private String accountId;

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public FcmRequest(String fcmToken, String accountId) {
        this.fcmToken = fcmToken;
        this.accountId = accountId;
    }
}
