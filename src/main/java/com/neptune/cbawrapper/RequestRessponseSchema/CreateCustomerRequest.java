package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    private Integer officeId;

    // 38 = merchant, 2 = business, 4 = agent
    private Integer legalFormId;

    private String fullname;

    // businessId or merchantId depending on type
    private Integer externalId;

    private String mobileNo;

    private String emailAddress;

    private Boolean active;

    private List<Address> address;

    private String locale;

    private String dateFormat;

    private String activationDate;

    private String submittedOnDate;

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getLegalFormId() {
        return legalFormId;
    }

    public void setLegalFormId(Integer legalFormId) {
        this.legalFormId = legalFormId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getSubmittedOnDate() {
        return submittedOnDate;
    }

    public void setSubmittedOnDate(String submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }
}
