package com.neptune.cbawrapper.RequestRessponseSchema;

public class EncryptedRequest {
    private String request;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public EncryptedRequest(String request) {
        this.request = request;
    }

    public EncryptedRequest() {
    }

    @Override
    public String toString() {
        return "EncryptedRequest{" +
                "request='" + request + '\'' +
                '}';
    }
}
