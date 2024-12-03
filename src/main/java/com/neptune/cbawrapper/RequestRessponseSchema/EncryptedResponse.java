package com.neptune.cbawrapper.RequestRessponseSchema;

public class EncryptedResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EncryptedResponse(String message) {
        this.message = message;
    }
}
