package com.neptune.cbawrapper.RequestRessponseSchema;

public class PushyPushRequest {

    public Object to;
    public Object data;

    public Object notification;

    public PushyPushRequest(Object data, Object to, Object notification) {
        this.to = to;
        this.data = data;
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "PushyPushRequest{" +
                "to=" + to +
                ", data=" + data +
                ", notification=" + notification +
                '}';
    }
}
