package com.neptune.cbawrapper.RequestRessponseSchema;

public class TerminalData {
    private Integer terminalId;
    private String walletId;

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public TerminalData(Integer terminalId, String walletId) {
        this.terminalId = terminalId;
        this.walletId = walletId;
    }

    public TerminalData() {
    }

    @Override
    public String toString() {
        return "TerminalData{" +
                "terminalId=" + terminalId +
                ", walletId='" + walletId + '\'' +
                '}';
    }
}
