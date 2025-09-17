package com.neptune.cbawrapper.RequestRessponseSchema;

public class EasyPayRequest {

    private String sourceInstitutionCode;
    private String beneficiaryAccountName;
    private String beneficiaryAccountNumber;
    private String beneficiaryBankVerificationNumber;
    private String beneficiaryKYCLevel;
    private String originatorAccountName;
    private String destinationInstitutionCode;
    private String originatorAccountNumber;
    private String originatorBankVerificationNumber;
    private int originatorKYCLevel;
    private String mandateReferenceNumber;
    private String nameEnquiryRef;
    private String originatorNarration;
    private String paymentReference;
    private String transactionLocation;
    private String beneficiaryNarration;
    private String billerId;
    private String customerAccountName;
    private String customerAccountNumber;
    private double amount;
    private long id;
    private String nipResponse;
    private String status;
    private String sessionId;
    private String transactionId;

    // Getters and Setters
    public String getSourceInstitutionCode() { return sourceInstitutionCode; }
    public void setSourceInstitutionCode(String sourceInstitutionCode) { this.sourceInstitutionCode = sourceInstitutionCode; }

    public String getBeneficiaryAccountName() { return beneficiaryAccountName; }
    public void setBeneficiaryAccountName(String beneficiaryAccountName) { this.beneficiaryAccountName = beneficiaryAccountName; }

    public String getBeneficiaryAccountNumber() { return beneficiaryAccountNumber; }
    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) { this.beneficiaryAccountNumber = beneficiaryAccountNumber; }

    public String getBeneficiaryBankVerificationNumber() { return beneficiaryBankVerificationNumber; }
    public void setBeneficiaryBankVerificationNumber(String beneficiaryBankVerificationNumber) { this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber; }

    public String getBeneficiaryKYCLevel() { return beneficiaryKYCLevel; }
    public void setBeneficiaryKYCLevel(String beneficiaryKYCLevel) { this.beneficiaryKYCLevel = beneficiaryKYCLevel; }

    public String getOriginatorAccountName() { return originatorAccountName; }
    public void setOriginatorAccountName(String originatorAccountName) { this.originatorAccountName = originatorAccountName; }

    public String getDestinationInstitutionCode() { return destinationInstitutionCode; }
    public void setDestinationInstitutionCode(String destinationInstitutionCode) { this.destinationInstitutionCode = destinationInstitutionCode; }

    public String getOriginatorAccountNumber() { return originatorAccountNumber; }
    public void setOriginatorAccountNumber(String originatorAccountNumber) { this.originatorAccountNumber = originatorAccountNumber; }

    public String getOriginatorBankVerificationNumber() { return originatorBankVerificationNumber; }
    public void setOriginatorBankVerificationNumber(String originatorBankVerificationNumber) { this.originatorBankVerificationNumber = originatorBankVerificationNumber; }

    public int getOriginatorKYCLevel() { return originatorKYCLevel; }
    public void setOriginatorKYCLevel(int originatorKYCLevel) { this.originatorKYCLevel = originatorKYCLevel; }

    public String getMandateReferenceNumber() { return mandateReferenceNumber; }
    public void setMandateReferenceNumber(String mandateReferenceNumber) { this.mandateReferenceNumber = mandateReferenceNumber; }

    public String getNameEnquiryRef() { return nameEnquiryRef; }
    public void setNameEnquiryRef(String nameEnquiryRef) { this.nameEnquiryRef = nameEnquiryRef; }

    public String getOriginatorNarration() { return originatorNarration; }
    public void setOriginatorNarration(String originatorNarration) { this.originatorNarration = originatorNarration; }

    public String getPaymentReference() { return paymentReference; }
    public void setPaymentReference(String paymentReference) { this.paymentReference = paymentReference; }

    public String getTransactionLocation() { return transactionLocation; }
    public void setTransactionLocation(String transactionLocation) { this.transactionLocation = transactionLocation; }

    public String getBeneficiaryNarration() { return beneficiaryNarration; }
    public void setBeneficiaryNarration(String beneficiaryNarration) { this.beneficiaryNarration = beneficiaryNarration; }

    public String getBillerId() { return billerId; }
    public void setBillerId(String billerId) { this.billerId = billerId; }

    public String getCustomerAccountName() { return customerAccountName; }
    public void setCustomerAccountName(String customerAccountName) { this.customerAccountName = customerAccountName; }

    public String getCustomerAccountNumber() { return customerAccountNumber; }
    public void setCustomerAccountNumber(String customerAccountNumber) { this.customerAccountNumber = customerAccountNumber; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNipResponse() { return nipResponse; }
    public void setNipResponse(String nipResponse) { this.nipResponse = nipResponse; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    @Override
    public String toString() {
        return "EasyPayRequest{" +
                "sourceInstitutionCode='" + sourceInstitutionCode + '\'' +
                ", beneficiaryAccountName='" + beneficiaryAccountName + '\'' +
                ", beneficiaryAccountNumber='" + beneficiaryAccountNumber + '\'' +
                ", amount=" + amount +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}

