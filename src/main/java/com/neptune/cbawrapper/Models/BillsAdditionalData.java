package com.neptune.cbawrapper.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillsAdditionalData {
    @JsonProperty("Pin")
    private String pin;

    @JsonProperty("vatAmount")
    private String vatAmount;

    @JsonProperty("tariffClass")
    private String tariffClass;

    @JsonProperty("tariff")
    private String tariff;

    @JsonProperty("arrears")
    private String arrears;

    @JsonProperty("unitsIssued")
    private String unitsIssued;

    @JsonProperty("costOfUnits")
    private String costOfUnits;

    @JsonProperty("token")
    private String token;

    @JsonProperty("receiptNo")
    private String receiptNo;

    @JsonProperty("dealerName")
    private String dealerName;

    @JsonProperty("agentName")
    private String agentName;

    @JsonProperty("agentCode")
    private String agentCode;

    @JsonProperty("customerCareNo")
    private String customerCareNo;

    @JsonProperty("Order Number")
    private String orderNumber;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("Account Type")
    private String accountType;

    @JsonProperty("Service Address")
    private String serviceAddress;

    @JsonProperty("Minimum Payable")
    private String minimumPayable;
}
