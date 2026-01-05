package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.ToString;

@ToString
public class NameEnquiryRequestPayload {

    private String accountNumber;
    private String destinationInstitutionCode;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDestinationInstitutionCode() {
        return destinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        this.destinationInstitutionCode = destinationInstitutionCode;
    }
}
