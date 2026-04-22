package com.neptune.cbawrapper.RequestRessponseSchema;

public class WebHookRequest {
    private String event;
    private DebitCreditData data;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public DebitCreditData getData() {
        return data;
    }

    public void setData(DebitCreditData data) {
        this.data = data;
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
                    ", data=" + data.toString() +
                    '}';
        }
    }
}
