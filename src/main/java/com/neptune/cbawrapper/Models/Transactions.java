package com.neptune.cbawrapper.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Document(collection = "transactions")
public class Transactions {

    // okay if successful on the pos side on the middlware it will be pending till we call the cba to credit and debit all required accounts with the wallet account number
    // send all transactions to Ikenna, whether failed or successful.
    @Id
    private String id;
    private String beneficiaryAccountNumber;


    private String event;

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

    private BigDecimal charge;

    private String created_at;
    private String updated_at;

    private boolean isProcessing = false;

    private String processingStartedAt;

    private String processingInstance;

    private String responseCode;

    private boolean isUpdatedToCba;

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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public boolean isUpdatedToCba() {
        return isUpdatedToCba;
    }

    public void setUpdatedToCba(boolean updatedToCba) {
        isUpdatedToCba = updatedToCba;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isProcessing() {
        return isProcessing;
    }

    public void setProcessing(boolean processing) {
        isProcessing = processing;
    }

    public String getProcessingStartedAt() {
        return processingStartedAt;
    }

    public void setProcessingStartedAt(String processingStartedAt) {
        this.processingStartedAt = processingStartedAt;
    }

    public String getProcessingInstance() {
        return processingInstance;
    }

    public void setProcessingInstance(String processingInstance) {
        this.processingInstance = processingInstance;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Transactions() {
    }
}
