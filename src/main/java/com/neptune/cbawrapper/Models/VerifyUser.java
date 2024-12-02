package com.neptune.cbawrapper.Models;

public class VerifyUser {

    private String phone;
    private String email;
    private Integer is_email;
    private Boolean is_phone;
    private String otp;
    private String token;
    private String password;
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
    private String message;
    private String account;
    private String ref;

    private String transactionReference;
    private String reference;
    private String ptad;
    private String transactionType;
    private String transactionDate;
    private String responseCode;
    private String terminalId;
    private String pan;
    private String cardExpiry;
    private Double transactionFee;
    private Double processingFee;
    private String retrievalReferenceNumber;
    private String authCode;
    private String merchantCode;
    private Boolean reversal;
    private String merchantName;
    private String stan;
    private String serialno;

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIs_email() {
        return is_email;
    }

    public void setIs_email(Integer is_email) {
        this.is_email = is_email;
    }

    public Boolean getIs_phone() {
        return is_phone;
    }

    public void setIs_phone(Boolean is_phone) {
        this.is_phone = is_phone;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public VerifyUser(String phone, Boolean is_phone, String otp) {
        this.phone = phone;
        this.is_phone = is_phone;
        this.otp = otp;
    }

    public VerifyUser(String email, Integer is_email, String otp) {
        this.email = email;
        this.is_email = is_email;
        this.otp = otp;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPtad() {
        return ptad;
    }

    public void setPtad(String ptad) {
        this.ptad = ptad;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public Double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(Double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(Double processingFee) {
        this.processingFee = processingFee;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public Boolean getReversal() {
        return reversal;
    }

    public void setReversal(Boolean reversal) {
        this.reversal = reversal;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public VerifyUser(String token) {
        this.token = token;
    }

    public VerifyUser() {
    }

    public VerifyUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "VerifyUser{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", is_email=" + is_email +
                ", is_phone=" + is_phone +
                ", otp='" + otp + '\'' +
                ", token='" + token + '\'' +
                ", password='" + password + '\'' +
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
                ", event='" + event + '\'' +
                ", message='" + message + '\'' +
                ", account='" + account + '\'' +
                ", ref='" + ref + '\'' +
                ", transactionReference='" + transactionReference + '\'' +
                ", reference='" + reference + '\'' +
                ", ptad='" + ptad + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", terminalId=" + terminalId +
                ", pan='" + pan + '\'' +
                ", cardExpiry='" + cardExpiry + '\'' +
                ", transactionFee=" + transactionFee +
                ", processingFee=" + processingFee +
                ", retrievalReferenceNumber='" + retrievalReferenceNumber + '\'' +
                ", authCode='" + authCode + '\'' +
                ", merchantCode='" + merchantCode + '\'' +
                ", reversal=" + reversal +
                ", merchantName='" + merchantName + '\'' +
                ", stan='" + stan + '\'' +
                ", serialno='" + serialno + '\'' +
                '}';
    }
}
