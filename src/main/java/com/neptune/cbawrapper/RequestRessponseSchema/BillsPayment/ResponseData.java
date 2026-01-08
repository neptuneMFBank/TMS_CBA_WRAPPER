package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

import lombok.ToString;

@ToString
public class ResponseData {
    private String transactionRef;
    private double approvedAmount;
    private String responseCode;
    private String responseDescription;
    private String responseCodeGrouping;
    private String message;
    private String code;

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public String getResponseCodeGrouping() {
        return responseCodeGrouping;
    }

    public void setResponseCodeGrouping(String responseCodeGrouping) {
        this.responseCodeGrouping = responseCodeGrouping;
    }

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
}
