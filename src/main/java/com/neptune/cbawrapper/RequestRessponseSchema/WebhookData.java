package com.neptune.cbawrapper.RequestRessponseSchema;

public class WebhookData {
    private String url;
    private String event;
    private String payload;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "WebhookData{" +
                "url='" + url + '\'' +
                ", event='" + event + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
