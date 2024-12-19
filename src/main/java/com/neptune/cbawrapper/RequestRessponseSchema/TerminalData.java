package com.neptune.cbawrapper.RequestRessponseSchema;

public class TerminalData {
    private String terminalId;
    private String walletId;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public TerminalData(String terminalId, String walletId) {
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
