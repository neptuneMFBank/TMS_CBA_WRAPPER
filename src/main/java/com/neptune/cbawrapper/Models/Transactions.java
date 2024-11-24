package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document(collection = "transactions")
public class Transactions {

    // okay if successful on the pos side on the middlware it will be pending till we call the cba to credit and debit all required accounts with the wallet account number
    // send all transactions to Ikenna, whether failed or successful.
    @Id
    private String id;
    private String event;
    private String message;
    private String status;
    private String account;
    private String ref;

    private String transactionReference;
    private String reference;
    private String ptad;
    private String transactionType;
    private String transactionDate;
    private String responseCode;
    private String terminalId;
    private String pan;
    private Double amount;
    private String cardExpiry;
    private String transactionFee;
    private String processingFee;
    private String retrievalReferenceNumber;
    private String authCode;
    private String merchantCode;
    private String reversal;
    private String merchantName;
    private String stan;
    private String serialno;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Transactions() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Transactions(String event, String message, String account, String ref, Double amount, String status) {
        this.event = event;
        this.message = message;
        this.status = status;
        this.account = account;
        this.ref = ref;
        this.amount = amount;
    }
}
