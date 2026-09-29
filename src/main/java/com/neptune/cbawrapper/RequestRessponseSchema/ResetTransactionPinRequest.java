package com.neptune.cbawrapper.RequestRessponseSchema;

public class ResetTransactionPinRequest {
    private String terminalId;
    private String newTransactionPin;
    private String adminPin;

    public String getNewTransactionPin() {
        return newTransactionPin;
    }

    public void setNewTransactionPin(String newTransactionPin) {
        this.newTransactionPin = newTransactionPin;
    }

    public String getAdminPin() {
        return adminPin;
    }

    public void setAdminPin(String adminPin) {
        this.adminPin = adminPin;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
}
