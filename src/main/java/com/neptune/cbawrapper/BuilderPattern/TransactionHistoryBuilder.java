package com.neptune.cbawrapper.BuilderPattern;

import com.neptune.cbawrapper.Models.TransactionHistory;

public class TransactionHistoryBuilder {
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

    public TransactionHistoryBuilder setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
        return this;
    }

    public TransactionHistoryBuilder setBankname(String bankname) {
        this.bankname = bankname;
        return this;
    }

    public TransactionHistoryBuilder setBkbalance(Double bkbalance) {
        this.bkbalance = bkbalance;
        return this;
    }

    public TransactionHistoryBuilder setIdno(Integer idno) {
        this.idno = idno;
        return this;
    }

    public TransactionHistoryBuilder setNarration(String narration) {
        this.narration = narration;
        return this;
    }

    public TransactionHistoryBuilder setRefno(String refno) {
        this.refno = refno;
        return this;
    }

    public TransactionHistoryBuilder setRn(Integer rn) {
        this.rn = rn;
        return this;
    }

    public TransactionHistoryBuilder setTranamount(Double tranamount) {
        this.tranamount = tranamount;
        return this;
    }

    public TransactionHistoryBuilder setTrandate(String trandate) {
        this.trandate = trandate;
        return this;
    }

    public TransactionHistoryBuilder setValuedate(String valuedate) {
        this.valuedate = valuedate;
        return this;
    }

    public TransactionHistoryBuilder setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public TransactionHistoryBuilder setStatus(String status){
        this.status = status;
        return this;
    }

    public TransactionHistory build(){
        return new TransactionHistory(accountnumber, bankname, bkbalance, idno, narration, refno, rn, tranamount, trandate, valuedate, transactionType, status);
    }
}
