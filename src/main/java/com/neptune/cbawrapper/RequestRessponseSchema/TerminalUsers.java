package com.neptune.cbawrapper.RequestRessponseSchema;

public class TerminalUsers {
    private String businessAcct;
    private String title;
    private String displayName;
    private String mobileNo;
    private String emailAddress;
    private String officeName;
    private String tin;
    private String state;
    private String incorpNo;
    private String terminalAddress;
    private String terminalAddressLga;
    private String merchantAddressLga;
    private String rcNumber;
    private String officeAddress;
    private String gpsLatitude;
    private String gpsLongitude;
    private String dateOfIncorporation;
    private String industryType;

    public String getBusinessAcct() {
        return businessAcct;
    }

    public void setBusinessAcct(String businessAcct) {
        this.businessAcct = businessAcct;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getIncorpNo() {
        return incorpNo;
    }

    public void setIncorpNo(String incorpNo) {
        this.incorpNo = incorpNo;
    }

    public String getTerminalAddress() {
        return terminalAddress;
    }

    public void setTerminalAddress(String terminalAddress) {
        this.terminalAddress = terminalAddress;
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

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
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

    public TerminalUsers() {
    }

    @Override
    public String toString() {
        return "TerminalUsers{" +
                "businessAcct='" + businessAcct + '\'' +
                ", title='" + title + '\'' +
                ", displayName='" + displayName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", officeName='" + officeName + '\'' +
                ", tin='" + tin + '\'' +
                ", state='" + state + '\'' +
                ", incorpNo='" + incorpNo + '\'' +
                ", terminalAddress='" + terminalAddress + '\'' +
                ", terminalAddressLga='" + terminalAddressLga + '\'' +
                ", merchantAddressLga='" + merchantAddressLga + '\'' +
                ", rcNumber='" + rcNumber + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", gpsLatitude='" + gpsLatitude + '\'' +
                ", gpsLongitude='" + gpsLongitude + '\'' +
                ", dateOfIncorporation='" + dateOfIncorporation + '\'' +
                ", industryType='" + industryType + '\'' +
                '}';
    }
}
