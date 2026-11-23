package com.neptune.cbawrapper.RequestRessponseSchema;

public class TerminalDetails {

    public TerminalDetails() {
    }

    private Boolean isMessageSent = false;
    private Boolean isOtpUsed;

    public Boolean getMessageSent() {
        return isMessageSent;
    }

    public void setMessageSent(Boolean messageSent) {
        isMessageSent = messageSent;
    }

    public Boolean getOtpUsed() {
        return isOtpUsed;
    }

    public void setOtpUsed(Boolean otpUsed) {
        isOtpUsed = otpUsed;
    }
}
