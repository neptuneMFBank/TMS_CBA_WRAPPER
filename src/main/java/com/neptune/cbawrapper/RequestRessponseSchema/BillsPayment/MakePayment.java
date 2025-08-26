package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MakePayment {
    private String paymentCode;
    private String customerId;
    private String email;
    private String mobile;
    private String amount;
    private String customerAccountNumber;
    private String billType;
    private String requestReference;

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getRequestReference() {
        return requestReference;
    }

    public void setRequestReference(String requestReference) {
        this.requestReference = requestReference;
    }

    public MakePayment(String paymentCode, String customerId, String email, String mobile, String amount, String customerAccountNumber, String billType, String requestReference) {
        this.paymentCode = paymentCode;
        this.customerId = customerId;
        this.email = email;
        this.mobile = mobile;
        this.amount = amount;
        this.customerAccountNumber = customerAccountNumber;
        this.billType = billType;
        this.requestReference = requestReference;
    }
}
