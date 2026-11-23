package com.neptune.cbawrapper.RequestRessponseSchema.Reports;

import lombok.Data;

@Data
public class RsmSummaryReportRow {
    private String dateTime;
    private String customerName;
    private String terminalId;
    private String accountNumber;
    private String location;
    private String terminalStatus;
    private long cardTransactionCount;
    private double totalCardTransaction;
    private double cardCharges;
    private long transferCount;
    private double totalTransfer;
    private double transferCharges;
    private String rsm;
}
