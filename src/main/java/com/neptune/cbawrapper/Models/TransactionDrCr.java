package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cba_transaction_requests")
public class TransactionDrCr {

    @Id
    private String id;

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
    private Boolean isUpdatedToCba;
    private String resourceId;
    private Integer transaction_platform_id;
    private Integer transaction_business_platform_id;

    public String getIsccode() {
        return isccode;
    }

    public void setIsccode(String isccode) {
        this.isccode = isccode;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getUpdatedToCba() {
        return isUpdatedToCba;
    }

    public void setUpdatedToCba(Boolean updatedToCba) {
        isUpdatedToCba = updatedToCba;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getTransaction_platform_id() {
        return transaction_platform_id;
    }

    public void setTransaction_platform_id(Integer transaction_platform_id) {
        this.transaction_platform_id = transaction_platform_id;
    }

    public Integer getTransaction_business_platform_id() {
        return transaction_business_platform_id;
    }

    public void setTransaction_business_platform_id(Integer transaction_business_platform_id) {
        this.transaction_business_platform_id = transaction_business_platform_id;
    }
}