package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

public class BillInfoData {
    private String amount;
    private String name;
    private String fee;
    private String id;
    private String paymentCode;
    private String customerIdField;
    private String isAmountFixed;
    private String currencySymbol;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public String getCustomerIdField() {
        return customerIdField;
    }

    public void setCustomerIdField(String customerIdField) {
        this.customerIdField = customerIdField;
    }

    public String getIsAmountFixed() {
        return isAmountFixed;
    }

    public void setIsAmountFixed(String isAmountFixed) {
        this.isAmountFixed = isAmountFixed;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public BillInfoData() {
    }
}
