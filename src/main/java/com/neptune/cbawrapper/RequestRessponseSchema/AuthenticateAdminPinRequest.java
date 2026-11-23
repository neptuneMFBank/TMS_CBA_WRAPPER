package com.neptune.cbawrapper.RequestRessponseSchema;

public class AuthenticateAdminPinRequest {
    private String terminalId;
    private String adminPin;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAdminPin() {
        return adminPin;
    }

    public void setAdminPin(String adminPin) {
        this.adminPin = adminPin;
    }

    @Override
    public String toString() {
        return "AuthenticateAdminPinRequest{" +
                "terminalId='" + terminalId + '\'' +
                '}';
    }
}
