package com.neptune.cbawrapper.RequestRessponseSchema;

import java.util.ArrayList;
import java.util.List;

/** One issuing bank and the health of each card scheme seen on it. Returned by /api/v1/card-issuers. */
public class IssuerBankHealth {

    private String bankName;
    private List<SchemeHealth> cardSchemes = new ArrayList<>();

    public IssuerBankHealth() {
    }

    public IssuerBankHealth(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<SchemeHealth> getCardSchemes() {
        return cardSchemes;
    }

    public void setCardSchemes(List<SchemeHealth> cardSchemes) {
        this.cardSchemes = cardSchemes;
    }

    public static class SchemeHealth {
        private String scheme;
        private String status;
        private double successRate;
        private long totalTransactions;
        private long successfulTransactions;
        private long failedTransactions;
        private String lastChecked;

        public SchemeHealth() {
        }

        public String getScheme() {
            return scheme;
        }

        public void setScheme(String scheme) {
            this.scheme = scheme;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public double getSuccessRate() {
            return successRate;
        }

        public void setSuccessRate(double successRate) {
            this.successRate = successRate;
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

        public String getLastChecked() {
            return lastChecked;
        }

        public void setLastChecked(String lastChecked) {
            this.lastChecked = lastChecked;
        }
    }
}
