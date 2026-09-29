package com.neptune.cbawrapper.RequestRessponseSchema;

public class CreateAdminPinRequest {
    private String terminalId;
    private String adminPin;
    private String confirmAdminPin;

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

    public String getConfirmAdminPin() {
        return confirmAdminPin;
    }

    public void setConfirmAdminPin(String confirmAdminPin) {
        this.confirmAdminPin = confirmAdminPin;
    }

    @Override
    public String toString() {
        return "CreateAdminPinRequest{" +
                "terminalId='" + terminalId + '\'' +
                '}';
    }
}
