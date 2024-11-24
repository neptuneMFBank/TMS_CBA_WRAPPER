package com.neptune.cbawrapper.RequestRessponseSchema;

import java.time.ZonedDateTime;
import java.util.List;

public class ResponseSchema<T> {

    private String email;
    private String idxsb;
    private String mfa_secret;
    private String mfa_url;
    private int status;
    private List<T> responseData;
    private String message;
    private ZonedDateTime timeStamp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdxsb() {
        return idxsb;
    }

    public void setIdxsb(String idxsb) {
        this.idxsb = idxsb;
    }

    public String getMfa_secret() {
        return mfa_secret;
    }

    public void setMfa_secret(String mfa_secret) {
        this.mfa_secret = mfa_secret;
    }

    public String getMfa_url() {
        return mfa_url;
    }

    public void setMfa_url(String mfa_url) {
        this.mfa_url = mfa_url;
    }


    public List<T> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<T> responseData) {
        this.responseData = responseData;
    }

    public ResponseSchema() {
    }

    public ResponseSchema(String message, Integer Status, ZonedDateTime timeStamp, T responseData) {
        this.message = message;
        this.status = Status;
        this.timeStamp = timeStamp;
    }

    public ResponseSchema(String idxsb, int status, String message, ZonedDateTime timeStamp) {
        this.idxsb = idxsb;
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ResponseSchema(String email, String idxsb, String mfa_secret, String mfa_url, int status, String message, ZonedDateTime timeStamp) {
        this.email = email;
        this.idxsb = idxsb;
        this.mfa_secret = mfa_secret;
        this.mfa_url = mfa_url;
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
