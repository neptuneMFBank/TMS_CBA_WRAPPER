package com.neptune.cbawrapper.RequestRessponseSchema;

public class Data {

    private Integer savingsId;
    private String walletId;

    public Integer getSavingsId() {
        return savingsId;
    }

    public void setSavingsId(Integer savingsId) {
        this.savingsId = savingsId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public Data(Integer savingsId, String walletId) {
        this.savingsId = savingsId;
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "Data{" +
                "savingsId=" + savingsId +
                ", walletId='" + walletId + '\'' +
                '}';
    }
}
