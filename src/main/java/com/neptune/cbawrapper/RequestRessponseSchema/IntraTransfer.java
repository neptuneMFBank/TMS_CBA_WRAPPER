package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IntraTransfer {
    private String customerId;
    private String mobilekey;
    private String fromaccount;
    private String fromacctname;
    private String fromaccountstatus;
    private String fromaccountemail;
    private String fromacctype;
    private String toaccount;
    private String toacctname;
    private String toacctype;
    private Double amount;
    private String tokenType;
    private String transactionreference;
    private String narration;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMobilekey() {
        return mobilekey;
    }

    public void setMobilekey(String mobilekey) {
        this.mobilekey = mobilekey;
    }

    public String getFromaccount() {
        return fromaccount;
    }

    public void setFromaccount(String fromaccount) {
        this.fromaccount = fromaccount;
    }

    public String getFromacctname() {
        return fromacctname;
    }

    public void setFromacctname(String fromacctname) {
        this.fromacctname = fromacctname;
    }

    public String getFromaccountstatus() {
        return fromaccountstatus;
    }

    public void setFromaccountstatus(String fromaccountstatus) {
        this.fromaccountstatus = fromaccountstatus;
    }

    public String getFromaccountemail() {
        return fromaccountemail;
    }

    public void setFromaccountemail(String fromaccountemail) {
        this.fromaccountemail = fromaccountemail;
    }

    public String getFromacctype() {
        return fromacctype;
    }

    public void setFromacctype(String fromacctype) {
        this.fromacctype = fromacctype;
    }

    public String getToaccount() {
        return toaccount;
    }

    public void setToaccount(String toaccount) {
        this.toaccount = toaccount;
    }

    public String getToacctname() {
        return toacctname;
    }

    public void setToacctname(String toacctname) {
        this.toacctname = toacctname;
    }

    public String getToacctype() {
        return toacctype;
    }

    public void setToacctype(String toacctype) {
        this.toacctype = toacctype;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTransactionreference() {
        return transactionreference;
    }

    public void setTransactionreference(String transactionreference) {
        this.transactionreference = transactionreference;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }
}
