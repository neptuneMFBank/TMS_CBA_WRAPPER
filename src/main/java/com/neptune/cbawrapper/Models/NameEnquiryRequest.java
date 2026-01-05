package com.neptune.cbawrapper.Models;

import lombok.ToString;

@ToString
public class NameEnquiryRequest {
    private String accountNumber;
    private String channelCode;
    private String destinationInstitutionCode;
    private String senderBankCode;
    private String requestId;
    private String platform;

    // No-args constructor
    public NameEnquiryRequest() {
    }

    // All-args constructor
    public NameEnquiryRequest(String accountNumber, String channelCode,
                              String destinationInstitutionCode, String senderBankCode,
                              String requestId, String platform) {
        this.accountNumber = accountNumber;
        this.channelCode = channelCode;
        this.destinationInstitutionCode = destinationInstitutionCode;
        this.senderBankCode = senderBankCode;
        this.requestId = requestId;
        this.platform = platform;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getDestinationInstitutionCode() {
        return destinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        this.destinationInstitutionCode = destinationInstitutionCode;
    }

    public String getSenderBankCode() {
        return senderBankCode;
    }

    public void setSenderBankCode(String senderBankCode) {
        this.senderBankCode = senderBankCode;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
