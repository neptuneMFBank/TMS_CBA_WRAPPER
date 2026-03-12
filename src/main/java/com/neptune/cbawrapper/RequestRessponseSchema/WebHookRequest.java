package com.neptune.cbawrapper.RequestRessponseSchema;

public class WebHookRequest {
    private String event;
    private DebitCreditData payload;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public DebitCreditData getPayload() {
        return payload;
    }

    public void setPayload(DebitCreditData payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper()
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(this);
        } catch (Exception e) {
            return "WebHookRequest{" +
                    "event='" + event + '\'' +
                    ", payload=" + payload +
                    '}';
        }
    }
}
