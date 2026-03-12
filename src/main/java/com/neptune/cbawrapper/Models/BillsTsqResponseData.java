package com.neptune.cbawrapper.Models;

public class BillsTsqResponseData {
    private String message;
    private String code;
    private BillsAdditionalData additionalInfo;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BillsAdditionalData getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(BillsAdditionalData additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
