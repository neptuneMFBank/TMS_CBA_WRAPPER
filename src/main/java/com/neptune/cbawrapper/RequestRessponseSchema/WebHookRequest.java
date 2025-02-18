package com.neptune.cbawrapper.RequestRessponseSchema;

public class WebHookRequest {
    private String accountnumber;
    private String isccode;
    private String accountstatus;
    private String acctname;
    private String drcr;
    private String acctype;
    private Double amount;
    private String transactionreference;
    private String narration;
    private String channel;
    private String eid;
    private String event;


    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getIsccode() {
        return isccode;
    }

    public void setIsccode(String isccode) {
        this.isccode = isccode;
    }

    public String getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(String accountstatus) {
        this.accountstatus = accountstatus;
    }

    public String getAcctname() {
        return acctname;
    }

    public void setAcctname(String acctname) {
        this.acctname = acctname;
    }

    public String getDrcr() {
        return drcr;
    }

    public void setDrcr(String drcr) {
        this.drcr = drcr;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public WebHookRequest() {
    }
}
