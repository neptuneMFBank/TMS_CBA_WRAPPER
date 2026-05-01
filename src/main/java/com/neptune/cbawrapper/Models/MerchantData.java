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
    private String title;
    private String emailAddress;
    private String officeName;
    private String state;
    private String incorpNo;
    private String terminalAddressLga;
    private String merchantAddressLga;
    private String rcNumber;
    private String officeAddress;
    private Double gpsLatitude;
    private Double gpsLongitude;
    private String dateOfIncorporation;
    private String industryType;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIncorpNo() {
        return incorpNo;
    }

    public void setIncorpNo(String incorpNo) {
        this.incorpNo = incorpNo;
    }

    public String getTerminalAddressLga() {
        return terminalAddressLga;
    }

    public void setTerminalAddressLga(String terminalAddressLga) {
        this.terminalAddressLga = terminalAddressLga;
    }

    public String getMerchantAddressLga() {
        return merchantAddressLga;
    }

    public void setMerchantAddressLga(String merchantAddressLga) {
        this.merchantAddressLga = merchantAddressLga;
    }

    public String getRcNumber() {
        return rcNumber;
    }

    public void setRcNumber(String rcNumber) {
        this.rcNumber = rcNumber;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }
}

