package com.neptune.cbawrapper.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The same counters as PosTransactionIssuerBank, but per day: one document per
 * date + issuing bank + card scheme (id = "yyyy-MM-dd|ISSUER BANK|SCHEME").
 * The date is the transaction's date. Used by the date filter on /api/v1/card-issuers.
 */
@Document(collection = "pos_transaction_issuer_bank_daily")
public class PosTransactionIssuerBankDaily {

    @Id
    private String id;
    // yyyy-MM-dd
    @Indexed
    private String date;
    private String issuerBank;
    private String scheme;
    private long totalTransactions;
    private long successfulTransactions;
    private long failedTransactions;
    private double successRate;
    private String status;
    private String lastChecked;

    public PosTransactionIssuerBankDaily() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIssuerBank() {
        return issuerBank;
    }

    public void setIssuerBank(String issuerBank) {
        this.issuerBank = issuerBank;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public long getSuccessfulTransactions() {
        return successfulTransactions;
    }

    public void setSuccessfulTransactions(long successfulTransactions) {
        this.successfulTransactions = successfulTransactions;
    }

    public long getFailedTransactions() {
        return failedTransactions;
    }

    public void setFailedTransactions(long failedTransactions) {
        this.failedTransactions = failedTransactions;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }
}
