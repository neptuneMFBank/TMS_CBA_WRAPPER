package com.neptune.cbawrapper.RequestRessponseSchema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DebitCreditData {
    private String beneficiaryAccountNumber;

    @JsonProperty("source_account_number")
    private String sourceAccountNumber;

    @JsonProperty("source_account_name")
    private String sourceAccountName;

    @JsonProperty("source_bank")
    private String sourceBank;

    private String reference;

    @JsonProperty("session_id")
    private String sessionId;

    private String narration;

    @JsonProperty("date_time")
    private String dateTime;

    private BigDecimal amount;

    private String transactionType;

    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    public String getSourceBank() {
        return sourceBank;
    }

    public void setSourceBank(String sourceBank) {
        this.sourceBank = sourceBank;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "DebitCreditData{" +
                "beneficiaryAccountNumber='" + beneficiaryAccountNumber + '\'' +
                ", sourceAccountNumber='" + sourceAccountNumber + '\'' +
                ", sourceAccountName='" + sourceAccountName + '\'' +
                ", sourceBank='" + sourceBank + '\'' +
                ", reference='" + reference + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", narration='" + narration + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
