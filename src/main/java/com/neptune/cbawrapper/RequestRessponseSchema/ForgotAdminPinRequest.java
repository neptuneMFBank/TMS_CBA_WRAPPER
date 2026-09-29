package com.neptune.cbawrapper.RequestRessponseSchema;

public class ForgotAdminPinRequest {
    private String terminalId;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    @Override
    public String toString() {
        return "ForgotAdminPinRequest{" +
                "terminalId='" + terminalId + '\'' +
                '}';
    }
}
