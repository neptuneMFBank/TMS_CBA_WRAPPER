package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

public class Customer {
    private String TerminalId;
    private int BillerId;
    private String PaymentCode;
    private String CustomerId;
    private String ResponseCode;
    private String ResponseDescription;
    private String FullName;
    private double Amount;
    private int AmountType;
    private String AmountTypeDescription;
    private double Surcharge;

    public String getTerminalId() {
        return TerminalId;
    }

    public void setTerminalId(String terminalId) {
        TerminalId = terminalId;
    }

    public int getBillerId() {
        return BillerId;
    }

    public void setBillerId(int billerId) {
        BillerId = billerId;
    }

    public String getPaymentCode() {
        return PaymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        PaymentCode = paymentCode;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseDescription() {
        return ResponseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        ResponseDescription = responseDescription;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public int getAmountType() {
        return AmountType;
    }

    public void setAmountType(int amountType) {
        AmountType = amountType;
    }

    public String getAmountTypeDescription() {
        return AmountTypeDescription;
    }

    public void setAmountTypeDescription(String amountTypeDescription) {
        AmountTypeDescription = amountTypeDescription;
    }

    public double getSurcharge() {
        return Surcharge;
    }

    public void setSurcharge(double surcharge) {
        Surcharge = surcharge;
    }
}
