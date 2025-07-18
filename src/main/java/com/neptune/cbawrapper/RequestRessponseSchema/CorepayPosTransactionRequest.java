package com.neptune.cbawrapper.RequestRessponseSchema;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.MakePayment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CorepayPosTransactionRequest implements Serializable {

    private String terminalId;
    private String transactionType;
    private String transactionDate;
    private Double amount;
    private String transactionReference;
    private String reference;
    private String ptad;
    private String responseCode;
    private String pan;
    private String cardExpiry;
    private Double transactionFee;
    private Double processingFee;
    private String retrievalReferenceNumber;
    private String authCode;
    private String merchantCode;
    private Boolean reversal;
    private String merchantName;
    private String stan;
    private String serialNo;
    private String merchantId;
    private String paymentTypeId;
    private String transactionPlatform;
    private String locale;
    private String dateFormat;
    private String status;
    private String narration;
    private String cardScheme;
    private boolean isBillsPayment;

    private MakePayment makePayment;

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    public Double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(Double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(Double processingFee) {
        this.processingFee = processingFee;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
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

    public Boolean getReversal() {
        return reversal;
    }

    public void setReversal(Boolean reversal) {
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

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTransactionPlatform() {
        return transactionPlatform;
    }

    public void setTransactionPlatform(String transactionPlatform) {
        this.transactionPlatform = transactionPlatform;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getCardScheme() {
        return cardScheme;
    }

    public void setCardScheme(String cardScheme) {
        this.cardScheme = cardScheme;
    }

    public boolean isBillsPayment() {
        return isBillsPayment;
    }

    public void setBillsPayment(boolean billsPayment) {
        isBillsPayment = billsPayment;
    }

    public MakePayment getMakePayment() {
        return makePayment;
    }

    public void setMakePayment(MakePayment makePayment) {
        this.makePayment = makePayment;
    }

    @Override
    public String toString() {
        return "CorepayPosTransactionRequest{" +
                "terminalId='" + terminalId + '\'' +
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
                ", retrievalReferenceNumber='" + retrievalReferenceNumber + '\'' +
                ", authCode='" + authCode + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", reversal=" + reversal +
                ", merchantName='" + merchantName + '\'' +
                ", stan='" + stan + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", paymentTypeId='" + paymentTypeId + '\'' +
                ", transactionPlatform='" + transactionPlatform + '\'' +
                ", locale='" + locale + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ", status='" + status + '\'' +
                ", narration='" + narration + '\'' +
                ", cardScheme='" + cardScheme + '\'' +
                '}';
    }
}
