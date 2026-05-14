package com.neptune.cbawrapper.RequestRessponseSchema;

public class UpdatePaymentHandlers {
    private Boolean bills;
    private Boolean trans;
    private String acctNum;

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public Boolean getBills() {
        return bills;
    }

    public void setBills(Boolean bills) {
        this.bills = bills;
    }

    public Boolean getTrans() {
        return trans;
    }

    public void setTrans(Boolean trans) {
        this.trans = trans;
    }
}
