package com.neptune.cbawrapper.RequestRessponseSchema;

public class NameEnquiryRequestPayload {

    private String accountNumber;
    private String channelCode;
    private String destinationInstitutionCode;
    private String senderBankCode;
    private String platform;

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
