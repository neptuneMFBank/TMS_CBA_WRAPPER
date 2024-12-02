package com.neptune.cbawrapper.RequestRessponseSchema;

import java.time.ZonedDateTime;
import java.util.List;

public class ResponseSchema<T> {

    private int status;
    private String message;
    private T data;
    private String uri;
    private ZonedDateTime timeStamp;
    private boolean enc;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(ZonedDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isEnc() {
        return enc;
    }

    public void setEnc(boolean enc) {
        this.enc = enc;
    }

    @Override
    public String toString() {
        return "ResponseSchema{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", uri='" + uri + '\'' +
                ", timeStamp=" + timeStamp +
                ", enc=" + enc +
                '}';
    }

    public ResponseSchema(int status, String message, T data, String uri, ZonedDateTime timeStamp, boolean enc) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.uri = uri;
        this.timeStamp = timeStamp;
        this.enc = enc;
    }

    public ResponseSchema() {
    }
}
