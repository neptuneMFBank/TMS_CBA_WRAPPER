package com.neptune.cbawrapper.RequestRessponseSchema;

public class ValidateOtpRequest {
    private String terminalId;
    private String otp;

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

    @Override
    public String toString() {
        return "ValidateOtpRequest{" +
                "terminalId='" + terminalId + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }
}
