package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "virtual_accounts")
public class VirtualAccountModel {

    @Id
    private String id;
    private String phone_number;
    private String account_name;
    private String email;
    private String bvn;
    private String nin;
    private String tin;
    private Boolean is_updated;
    private String parent_id;
    private String parent_account;
    private String business_id;
    private String business_wallet;
    private String savingsId;
    private String virtual_account_number;
    private String terminalId;
    private String businessName;
    private Integer businessSavingsId;
    private String businessWalletId;
    private String fcmToken;
    private String created_at;
    private String updated_at;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public Boolean getIs_updated() {
        return is_updated;
    }

    public void setIs_updated(Boolean is_updated) {
        this.is_updated = is_updated;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_account() {
        return parent_account;
    }

    public void setParent_account(String parent_account) {
        this.parent_account = parent_account;
    }

    public String getVirtual_account_number() {
        return virtual_account_number;
    }

    public String getSavingsId() {
        return savingsId;
    }

    public void setSavingsId(String savingsId) {
        this.savingsId = savingsId;
    }

    public void setVirtual_account_number(String virtual_account_number) {
        this.virtual_account_number = virtual_account_number;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_wallet() {
        return business_wallet;
    }

    public void setBusiness_wallet(String business_wallet) {
        this.business_wallet = business_wallet;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getBusinessSavingsId() {
        return businessSavingsId;
    }

    public void setBusinessSavingsId(Integer businessSavingsId) {
        this.businessSavingsId = businessSavingsId;
    }

    public String getBusinessWalletId() {
        return businessWalletId;
    }

    public void setBusinessWalletId(String businessWalletId) {
        this.businessWalletId = businessWalletId;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public VirtualAccountModel() {
    }

    public VirtualAccountModel(String phone_number, String account_name, String email, String bvn, String nin) {
        this.phone_number = phone_number;
        this.account_name = account_name;
        this.email = email;
        this.bvn = bvn;
        this.nin = nin;
    }

    public VirtualAccountModel(String phone_number, String account_name, String email, String bvn, String nin, String parent_id, String parent_account) {
        this.phone_number = phone_number;
        this.account_name = account_name;
        this.email = email;
        this.bvn = bvn;
        this.nin = nin;
        this.parent_id = parent_id;
        this.parent_account = parent_account;
    }
}
