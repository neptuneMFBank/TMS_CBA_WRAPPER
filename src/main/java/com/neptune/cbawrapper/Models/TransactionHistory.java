package com.neptune.cbawrapper.Models;

public class TransactionHistory {
    private String accountnumber;
    private String bankname;
    private Double bkbalance;
    private Integer  idno;
    private String narration;
    private String refno;
    private Integer  rn;
    private Double tranamount;
    private String trandate;
    private String valuedate;
    private String transactionType;
    private String status;
    private String session_id;

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

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

    public Double getTranamount() {
        return tranamount;
    }

    public void setTranamount(Double tranamount) {
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TransactionHistory(String accountnumber, String bankname, Double bkbalance, Integer idno, String narration, String refno, Integer rn, Double tranamount, String trandate, String valuedate, String transactionType, String status) {
        this.accountnumber = accountnumber;
        this.bankname = bankname;
        this.bkbalance = bkbalance;
        this.narration = narration;
        this.idno = idno;
        this.refno = refno;
        this.rn = rn;
        this.tranamount = tranamount;
        this.trandate = trandate;
        this.valuedate = valuedate;
        this.transactionType = transactionType;
        this.status = status;
    }
}
