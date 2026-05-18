package com.neptune.cbawrapper.RequestRessponseSchema;

public class ResetPin {
    private String newPin;
    private String account;

    public String getNewPin() {
        return newPin;
    }

    public void setNewPin(String newPin) {
        this.newPin = newPin;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "ResetPin{" +
                "newPin='" + newPin + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
