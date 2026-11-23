package com.neptune.cbawrapper.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Card health of one issuing bank + card scheme pair across all POS card transactions.
 * There is exactly one document per pair (id = "ISSUER BANK|SCHEME"); each new transaction
 * on that pair increments its counters and recalculates successRate and status.
 * Maintained by BinLookupService.
 */
@Document(collection = "pos_transaction_issuer_banks")
public class PosTransactionIssuerBank {

    @Id
    private String id;
    private String issuerBank;
    private String scheme;
    private long totalTransactions;
    private long successfulTransactions;
    private long failedTransactions;
    // Percentage of successful transactions, one decimal place, e.g. 87.5
    private double successRate;
    // HEALTHY, DEGRADED or DOWN, from successRate
    private String status;
    // When a transaction was last counted into this record
    private String lastChecked;
    private String created_at;

    public PosTransactionIssuerBank() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
