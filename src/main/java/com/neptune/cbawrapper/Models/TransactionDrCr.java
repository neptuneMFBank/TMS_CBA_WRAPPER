package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

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
    private String terminalId;
    private String type; // type of transaction either transaction or charge
    private Boolean isUpdatedToCba;
    private String cbaMessage;
    private String status_response_message;
    private String status_response_code;
    private Integer resourceId;
    private String posRef;
    private String transaction_platform_id;
    private String transaction_business_platform_id;
    private String cardScheme;
    private String responseCode;
    private String parent_id;
    private String created_at;
    private String updated_at;

    public String getType() {
        return type;
    }

    public String getPosRef() {
        return posRef;
    }

    public void setPosRef(String posRef) {
        this.posRef = posRef;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getIsccode() {
        return isccode;
    }

    public void setIsccode(String isccode) {
        this.isccode = isccode;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public String getCbaMessage() {
        return cbaMessage;
    }

    public void setCbaMessage(String cbaMessage) {
        this.cbaMessage = cbaMessage;
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

    public String getStatus_response_message() {
        return status_response_message;
    }

    public void setStatus_response_message(String status_response_message) {
        this.status_response_message = status_response_message;
    }

    public String getStatus_response_code() {
        return status_response_code;
    }

    public void setStatus_response_code(String status_response_code) {
        this.status_response_code = status_response_code;
    }

    public Boolean getUpdatedToCba() {
        return isUpdatedToCba;
    }

    public void setUpdatedToCba(Boolean updatedToCba) {
        isUpdatedToCba = updatedToCba;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getTransaction_platform_id() {
        return transaction_platform_id;
    }

    public void setTransaction_platform_id(String transaction_platform_id) {
        this.transaction_platform_id = transaction_platform_id;
    }

    public String getTransaction_business_platform_id() {
        return transaction_business_platform_id;
    }

    public void setTransaction_business_platform_id(String transaction_business_platform_id) {
        this.transaction_business_platform_id = transaction_business_platform_id;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getCardScheme() {
        return cardScheme;
    }

    public void setCardScheme(String cardScheme) {
        this.cardScheme = cardScheme;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }



    @Override
    public String toString() {
        return "TransactionDrCr{" +
                "id='" + id + '\'' +
                ", accountnumber='" + accountnumber + '\'' +
                ", isccode='" + isccode + '\'' +
                ", accountstatus='" + accountstatus + '\'' +
                ", acctname='" + acctname + '\'' +
                ", drcr='" + drcr + '\'' +
                ", acctype='" + acctype + '\'' +
                ", amount=" + amount +
                ", transactionreference='" + transactionreference + '\'' +
                ", narration='" + narration + '\'' +
                ", channel='" + channel + '\'' +
                ", eid='" + eid + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", isUpdatedToCba=" + isUpdatedToCba +
                ", resourceId=" + resourceId +
                ", transaction_platform_id='" + transaction_platform_id + '\'' +
                ", transaction_business_platform_id='" + transaction_business_platform_id + '\'' +
                ", cardScheme='" + cardScheme + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
