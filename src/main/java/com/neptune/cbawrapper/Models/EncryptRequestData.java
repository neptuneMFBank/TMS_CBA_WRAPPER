package com.neptune.cbawrapper.Models;

public class EncryptRequestData {
    private String dataSource;
    private String signature;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public EncryptRequestData(String dataSource, String signature) {
        this.dataSource = dataSource;
        this.signature = signature;
    }
}
