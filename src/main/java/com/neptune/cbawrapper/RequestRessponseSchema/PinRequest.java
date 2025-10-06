package com.neptune.cbawrapper.RequestRessponseSchema;

public class PinRequest {
    private String pin;
    private String genericCode;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getGenericCode() {
        return genericCode;
    }

    public void setGenericCode(String genericCode) {
        this.genericCode = genericCode;
    }
}
