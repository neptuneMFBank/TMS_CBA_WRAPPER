package com.neptune.cbawrapper.RequestRessponseSchema;

public class PinUpdate {
    private String pin;
    private String confirmOldPin;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getConfirmOldPin() {
        return confirmOldPin;
    }

    public void setConfirmOldPin(String confirmOldPin) {
        this.confirmOldPin = confirmOldPin;
    }
}
