package com.neptune.cbawrapper.RequestRessponseSchema;

public class SupportBypassRequest {
    private String terminalId;
    private String supportAgentId;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getSupportAgentId() {
        return supportAgentId;
    }

    public void setSupportAgentId(String supportAgentId) {
        this.supportAgentId = supportAgentId;
    }

    @Override
    public String toString() {
        return "SupportBypassRequest{" +
                "terminalId='" + terminalId + '\'' +
                ", supportAgentId='" + supportAgentId + '\'' +
                '}';
    }
}
