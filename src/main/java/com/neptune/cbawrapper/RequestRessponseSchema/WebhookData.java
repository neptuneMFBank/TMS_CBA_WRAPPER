package com.neptune.cbawrapper.RequestRessponseSchema;

public class WebhookData {
    private String event;
    private WebHookRequest payload;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public WebHookRequest getPayload() {
        return payload;
    }

    public void setPayload(WebHookRequest payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "WebhookData{" +
                "event='" + event + '\'' +
                ", payload=" + payload.toString() +
                '}';
    }
}
