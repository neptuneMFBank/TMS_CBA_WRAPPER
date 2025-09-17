package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class StatementResponse {
    private boolean success;
    private String message;
    private String status;
    private DataPayload data;

    @Data
    public static class DataPayload {
        private String pdf;
        private AccountInfo accountInfo;
    }

    @Data
    public static class AccountInfo {
        private List<Transaction> transactions;
        private CustomerDetails customerDetails;
        private AccountSummary accountSummary;
    }

    @Data
    public static class Transaction {
        private String date;
        private String reference;
        private String details;
        private BigDecimal debit;
        private BigDecimal credit;
        private BigDecimal balance;
    }

    @Data
    public static class CustomerDetails {
        private String name;
        private String accountNumber;
        private String address;
    }

    @Data
    public static class AccountSummary {
        private String statementPeriod;
        private String currency;
        private BigDecimal openingBalance;
        private BigDecimal totalCredit;
        private BigDecimal totalDebit;
        private BigDecimal closingBalance;
        private String datePrinted;
        private String accountType;
    }
}

