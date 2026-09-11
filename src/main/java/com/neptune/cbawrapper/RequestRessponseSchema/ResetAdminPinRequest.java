package com.neptune.cbawrapper.RequestRessponseSchema;

public class ResetAdminPinRequest {
    private String terminalId;
    private String otp;
    private String newAdminPin;
    private String confirmAdminPin;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getNewAdminPin() {
        return newAdminPin;
    }

    public void setNewAdminPin(String newAdminPin) {
        this.newAdminPin = newAdminPin;
    }

    public String getConfirmAdminPin() {
        return confirmAdminPin;
    }

    public void setConfirmAdminPin(String confirmAdminPin) {
        this.confirmAdminPin = confirmAdminPin;
    }

    @Override
    public String toString() {
        return "ResetAdminPinRequest{" +
                "terminalId='" + terminalId + '\'' +
                '}';
    }
}
