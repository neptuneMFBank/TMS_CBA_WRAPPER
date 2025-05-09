package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Document("pos_transaction_requests")
public class TransactionRequestSchema {

    @Id
    private String id;
    private String terminalId;
    private String narration;
    private String status;
    private String dateFormat;
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
    private String retrievalReferencenumber;
    private String authCode;
    private String merchantCode;
    private Boolean reversal;
    private String merchantName;
    private String stan;
    private String serialNo;
    private String locale;
    private String merchantId;
    private String paymentTypeId;
//    private String transactionPlatformId;
    private String cardScheme;

    private String created_at;
    private String updated_at;

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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

//    public String getTransactionPlatformId() {
//        return transactionPlatformId;
//    }
//
//    public void setTransactionPlatformId(String transactionPlatformId) {
//        this.transactionPlatformId = transactionPlatformId;
//    }

    public String getCardScheme() {
        return cardScheme;
    }

    public void setCardScheme(String cardScheme) {
        this.cardScheme = cardScheme;
    }

    @Override
    public String toString() {
        return "TransactionRequestSchema{" +
                "id='" + id + '\'' +
                ", terminalId='" + terminalId + '\'' +
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
                ", merchantId='" + merchantId + '\'' +
                ", paymentTypeId='" + paymentTypeId + '\'' +
                ", cardScheme='" + cardScheme + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
