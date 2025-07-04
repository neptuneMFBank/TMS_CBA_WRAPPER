package com.neptune.cbawrapper.RequestRessponseSchema;

public class EasyPayTransferRequestPayload {
    private String beneficiaryAccountName;
    private String beneficiaryAccountNumber;
    private String beneficiaryBankVerificationNumber;
    private String beneficiaryKYCLevel;
    private String originatorAccountName;
    private String destinationInstitutionCode;
    private String originatorAccountNumber;
    private String originatorBankVerificationNumber;
    private Integer originatorKYCLevel;
    private String nameEnquiryRef;
    private String originatorNarration;
    private String paymentReference;
    private String transactionLocation;
    private String customerAccountName;
    private String customerAccountNumber;
    private Double amount;

    public String getBeneficiaryAccountName() {
        return beneficiaryAccountName;
    }

    public void setBeneficiaryAccountName(String beneficiaryAccountName) {
        this.beneficiaryAccountName = beneficiaryAccountName;
    }

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getBeneficiaryBankVerificationNumber() {
        return beneficiaryBankVerificationNumber;
    }

    public void setBeneficiaryBankVerificationNumber(String beneficiaryBankVerificationNumber) {
        this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
    }

    public String getBeneficiaryKYCLevel() {
        return beneficiaryKYCLevel;
    }

    public void setBeneficiaryKYCLevel(String beneficiaryKYCLevel) {
        this.beneficiaryKYCLevel = beneficiaryKYCLevel;
    }

    public String getOriginatorAccountName() {
        return originatorAccountName;
    }

    public void setOriginatorAccountName(String originatorAccountName) {
        this.originatorAccountName = originatorAccountName;
    }

    public String getDestinationInstitutionCode() {
        return destinationInstitutionCode;
    }

    public void setDestinationInstitutionCode(String destinationInstitutionCode) {
        this.destinationInstitutionCode = destinationInstitutionCode;
    }

    public String getOriginatorAccountNumber() {
        return originatorAccountNumber;
    }

    public void setOriginatorAccountNumber(String originatorAccountNumber) {
        this.originatorAccountNumber = originatorAccountNumber;
    }

    public String getOriginatorBankVerificationNumber() {
        return originatorBankVerificationNumber;
    }

    public void setOriginatorBankVerificationNumber(String originatorBankVerificationNumber) {
        this.originatorBankVerificationNumber = originatorBankVerificationNumber;
    }

    public Integer getOriginatorKYCLevel() {
        return originatorKYCLevel;
    }

    public void setOriginatorKYCLevel(Integer originatorKYCLevel) {
        this.originatorKYCLevel = originatorKYCLevel;
    }

    public String getNameEnquiryRef() {
        return nameEnquiryRef;
    }

    public void setNameEnquiryRef(String nameEnquiryRef) {
        this.nameEnquiryRef = nameEnquiryRef;
    }

    public String getOriginatorNarration() {
        return originatorNarration;
    }

    public void setOriginatorNarration(String originatorNarration) {
        this.originatorNarration = originatorNarration;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getTransactionLocation() {
        return transactionLocation;
    }

    public void setTransactionLocation(String transactionLocation) {
        this.transactionLocation = transactionLocation;
    }

    public String getCustomerAccountName() {
        return customerAccountName;
    }

    public void setCustomerAccountName(String customerAccountName) {
        this.customerAccountName = customerAccountName;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "EasyPayTransferRequestPayload{" +
                "beneficiaryAccountName='" + beneficiaryAccountName + '\'' +
                ", beneficiaryAccountNumber='" + beneficiaryAccountNumber + '\'' +
                ", beneficiaryBankVerificationNumber='" + beneficiaryBankVerificationNumber + '\'' +
                ", beneficiaryKYCLevel='" + beneficiaryKYCLevel + '\'' +
                ", originatorAccountName='" + originatorAccountName + '\'' +
                ", destinationInstitutionCode='" + destinationInstitutionCode + '\'' +
                ", originatorAccountNumber='" + originatorAccountNumber + '\'' +
                ", originatorBankVerificationNumber='" + originatorBankVerificationNumber + '\'' +
                ", originatorKYCLevel=" + originatorKYCLevel +
                ", nameEnquiryRef='" + nameEnquiryRef + '\'' +
                ", originatorNarration='" + originatorNarration + '\'' +
                ", paymentReference='" + paymentReference + '\'' +
                ", transactionLocation='" + transactionLocation + '\'' +
                ", customerAccountName='" + customerAccountName + '\'' +
                ", customerAccountNumber='" + customerAccountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
