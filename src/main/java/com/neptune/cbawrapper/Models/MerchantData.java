package com.neptune.cbawrapper.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@Document(collection = "merchant_data")
@AllArgsConstructor
public class MerchantData {
    @Id
    private String id;
    private String businessAcct;
    private String merchantId;
    private String merchantName;
    private String contactName;
    private String contactTitle;
    private String mobilePhone;
    private String email;

    private String merchantPhysicalAddr;

    private String terminalId;
    private String bankCode;
    private String bankAccNo;
    private String businessOccupationCode;
    private String merchantCategoryCode;
    private String stateCode;

    private String visaAcquirerIdNumber;
    private String verveAcquirerIdNumber;
    private String mastercardAcquirerIdNumber;
    private String terminalOwnerCode;
    private String merchantAccountName;
    private String ptspCode;
    private String merchantAcctDomicileBankCode;
    private String terminalGroupId;
    private String bvn;
    private String tin;
    private String merchantAddressLgaCode;
    private String agentCode;
    private String gpsInfo;
    private String terminalAddressLgaCode;

    private String terminalAddress;

    private String merchantAcquirerId;
    private String terminalModelDescription;
    private String appName;
    private String appVersion;
    private String terminalType;
    private boolean uploaded;
    @Field("created_at")
    private String createdAt;
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getBusinessAcct() {
        return businessAcct;
    }

    public void setBusinessAcct(String businessAcct) {
        this.businessAcct = businessAcct;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMerchantPhysicalAddr() {
        return merchantPhysicalAddr;
    }

    public void setMerchantPhysicalAddr(String merchantPhysicalAddr) {
        this.merchantPhysicalAddr = merchantPhysicalAddr;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public String getBusinessOccupationCode() {
        return businessOccupationCode;
    }

    public void setBusinessOccupationCode(String businessOccupationCode) {
        this.businessOccupationCode = businessOccupationCode;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getVisaAcquirerIdNumber() {
        return visaAcquirerIdNumber;
    }

    public void setVisaAcquirerIdNumber(String visaAcquirerIdNumber) {
        this.visaAcquirerIdNumber = visaAcquirerIdNumber;
    }

    public String getVerveAcquirerIdNumber() {
        return verveAcquirerIdNumber;
    }

    public void setVerveAcquirerIdNumber(String verveAcquirerIdNumber) {
        this.verveAcquirerIdNumber = verveAcquirerIdNumber;
    }

    public String getMastercardAcquirerIdNumber() {
        return mastercardAcquirerIdNumber;
    }

    public void setMastercardAcquirerIdNumber(String mastercardAcquirerIdNumber) {
        this.mastercardAcquirerIdNumber = mastercardAcquirerIdNumber;
    }

    public String getTerminalOwnerCode() {
        return terminalOwnerCode;
    }

    public void setTerminalOwnerCode(String terminalOwnerCode) {
        this.terminalOwnerCode = terminalOwnerCode;
    }

    public String getMerchantAccountName() {
        return merchantAccountName;
    }

    public void setMerchantAccountName(String merchantAccountName) {
        this.merchantAccountName = merchantAccountName;
    }

    public String getPtspCode() {
        return ptspCode;
    }

    public void setPtspCode(String ptspCode) {
        this.ptspCode = ptspCode;
    }

    public String getMerchantAcctDomicileBankCode() {
        return merchantAcctDomicileBankCode;
    }

    public void setMerchantAcctDomicileBankCode(String merchantAcctDomicileBankCode) {
        this.merchantAcctDomicileBankCode = merchantAcctDomicileBankCode;
    }

    public String getTerminalGroupId() {
        return terminalGroupId;
    }

    public void setTerminalGroupId(String terminalGroupId) {
        this.terminalGroupId = terminalGroupId;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getMerchantAddressLgaCode() {
        return merchantAddressLgaCode;
    }

    public void setMerchantAddressLgaCode(String merchantAddressLgaCode) {
        this.merchantAddressLgaCode = merchantAddressLgaCode;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getGpsInfo() {
        return gpsInfo;
    }

    public void setGpsInfo(String gpsInfo) {
        this.gpsInfo = gpsInfo;
    }

    public String getTerminalAddressLgaCode() {
        return terminalAddressLgaCode;
    }

    public void setTerminalAddressLgaCode(String terminalAddressLgaCode) {
        this.terminalAddressLgaCode = terminalAddressLgaCode;
    }

    public String getTerminalAddress() {
        return terminalAddress;
    }

    public void setTerminalAddress(String terminalAddress) {
        this.terminalAddress = terminalAddress;
    }

    public String getMerchantAcquirerId() {
        return merchantAcquirerId;
    }

    public void setMerchantAcquirerId(String merchantAcquirerId) {
        this.merchantAcquirerId = merchantAcquirerId;
    }

    public String getTerminalModelDescription() {
        return terminalModelDescription;
    }

    public void setTerminalModelDescription(String terminalModelDescription) {
        this.terminalModelDescription = terminalModelDescription;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "MerchantData{" +
                "id='" + id + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTitle='" + contactTitle + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", merchantPhysicalAddr='" + merchantPhysicalAddr + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankAccNo='" + bankAccNo + '\'' +
                ", businessOccupationCode='" + businessOccupationCode + '\'' +
                ", merchantCategoryCode='" + merchantCategoryCode + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", visaAcquirerIdNumber='" + visaAcquirerIdNumber + '\'' +
                ", verveAcquirerIdNumber='" + verveAcquirerIdNumber + '\'' +
                ", mastercardAcquirerIdNumber='" + mastercardAcquirerIdNumber + '\'' +
                ", terminalOwnerCode='" + terminalOwnerCode + '\'' +
                ", merchantAccountName='" + merchantAccountName + '\'' +
                ", ptspCode='" + ptspCode + '\'' +
                ", merchantAcctDomicileBankCode='" + merchantAcctDomicileBankCode + '\'' +
                ", terminalGroupId='" + terminalGroupId + '\'' +
                ", bvn='" + bvn + '\'' +
                ", tin='" + tin + '\'' +
                ", merchantAddressLgaCode='" + merchantAddressLgaCode + '\'' +
                ", agentCode='" + agentCode + '\'' +
                ", gpsInfo='" + gpsInfo + '\'' +
                ", terminalAddressLgaCode='" + terminalAddressLgaCode + '\'' +
                ", terminalAddress='" + terminalAddress + '\'' +
                ", merchantAcquirerId='" + merchantAcquirerId + '\'' +
                ", terminalModelDescription='" + terminalModelDescription + '\'' +
                ", appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", terminalType='" + terminalType + '\'' +
                ", uploaded=" + uploaded +
                '}';
    }
}

