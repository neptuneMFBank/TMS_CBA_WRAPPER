package com.neptune.cbawrapper.Models;

public class TransactionHistory {
    private String accountnumber;
    private String bankname;
    private Double bkbalance;
    private Integer  idno;
    private String narration;
    private String refno;
    private Integer  rn;
    private Float tranamount;
    private String trandate;
    private String valuedate;

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public Double getBkbalance() {
        return bkbalance;
    }

    public void setBkbalance(Double bkbalance) {
        this.bkbalance = bkbalance;
    }

    public Integer getIdno() {
        return idno;
    }

    public void setIdno(Integer idno) {
        this.idno = idno;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public Float getTranamount() {
        return tranamount;
    }

    public void setTranamount(Float tranamount) {
        this.tranamount = tranamount;
    }

    public String getTrandate() {
        return trandate;
    }

    public void setTrandate(String trandate) {
        this.trandate = trandate;
    }

    public String getValuedate() {
        return valuedate;
    }

    public void setValuedate(String valuedate) {
        this.valuedate = valuedate;
    }

    public TransactionHistory(String accountnumber, String bankname, Double bkbalance, Integer idno, String narration, String refno, Integer rn, Float tranamount, String trandate, String valuedate) {
        this.accountnumber = accountnumber;
        this.bankname = bankname;
        this.bkbalance = bkbalance;
        this.idno = idno;
        this.narration = narration;
        this.refno = refno;
        this.rn = rn;
        this.tranamount = tranamount;
        this.trandate = trandate;
        this.valuedate = valuedate;
    }
}
