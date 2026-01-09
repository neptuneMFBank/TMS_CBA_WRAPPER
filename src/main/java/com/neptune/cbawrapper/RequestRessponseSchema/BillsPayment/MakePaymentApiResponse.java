package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

import lombok.ToString;

@ToString
public class MakePaymentApiResponse {
    private String transactionRef;
    private String message;
    private String code;
    private String responseCode;
    private String responseDescription;
    private String responseCodeGrouping;
    private ResponseData data;
    private Double approvedAmount;

    public String getTransactionRef() {
        return transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
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

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    public Double getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(Double approvedAmount) {
        this.approvedAmount = approvedAmount;
    }
}
