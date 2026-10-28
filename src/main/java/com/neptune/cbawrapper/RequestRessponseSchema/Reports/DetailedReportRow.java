package com.neptune.cbawrapper.RequestRessponseSchema.Reports;

import lombok.Data;

@Data
public class DetailedReportRow {
    private int sn;
    private String customerName;
    private String terminalId;
    private double amount;
    private String date;
    private String reference;
    private String narration;
    private String transactionType; // WITHDRAWAL or TRANSFER
    private String transactionStatus; // SUCCESSFUL, FAILED, REVERSED, PENDING
    private String rsm;
}
