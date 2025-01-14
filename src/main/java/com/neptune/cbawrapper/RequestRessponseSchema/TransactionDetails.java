package com.neptune.cbawrapper.RequestRessponseSchema;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;



@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TransactionDetails implements Serializable {

    private String terminalId;
    private String narration;
    private String status;
    private String dateFormat;
    private String transactionType;
    private String transactionDate;
    private double amount;
    private String transactionReference;
    private String reference;
    private String ptad;
    private String responseCode;
    private String pan;
    private String cardExpiry;
    private double transactionFee;
    private double processingFee;
    private String retrievalReferencenumber;
    private String authCode;
    private String merchantCode;
    private boolean reversal;
    private String merchantName;
    private String stan;
    private String serialNo;
    private String locale;
    private String cardScheme;

    // Getters and Setters
    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPtad() {
        return ptad;
    }

    public void setPtad(String ptad) {
        this.ptad = ptad;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public String getRetrievalReferencenumber() {
        return retrievalReferencenumber;
    }

    public void setRetrievalReferencenumber(String retrievalReferencenumber) {
        this.retrievalReferencenumber = retrievalReferencenumber;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public boolean isReversal() {
        return reversal;
    }

    public void setReversal(boolean reversal) {
        this.reversal = reversal;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCardScheme() {
        return cardScheme;
    }

    public void setCardScheme(String cardScheme) {
        this.cardScheme = cardScheme;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "terminalId='" + terminalId + '\'' +
                ", narration='" + narration + '\'' +
                ", status='" + status + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", amount=" + amount +
                ", transactionReference='" + transactionReference + '\'' +
                ", reference='" + reference + '\'' +
                ", ptad='" + ptad + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", pan='" + pan + '\'' +
                ", cardExpiry='" + cardExpiry + '\'' +
                ", transactionFee=" + transactionFee +
                ", processingFee=" + processingFee +
                ", retrievalReferencenumber='" + retrievalReferencenumber + '\'' +
                ", authCode='" + authCode + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", reversal=" + reversal +
                ", merchantName='" + merchantName + '\'' +
                ", stan='" + stan + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", locale='" + locale + '\'' +
                ", cardScheme='" + cardScheme + '\'' +
                '}';
    }
}
