package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "auth_credentials")
public class AuthCredentials {

    @Id
    private String id;
    private String token;
    private String email;
    private String client_id;
    private String customer_id;
    private String API_key;
    private String two_fa_token;
    private String first_name;
    private String last_name;
    private String business_name;
    private String phone_number;
    private String active_status;
    private Boolean phone_number_verified;
    private Boolean email_verified;
    private Boolean bvn_verified;
    private String status;
    private String channel_code;
    private String settlement_account_number;
    private String created_at;
    private String updated_at;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAPI_key() {
        return API_key;
    }

    public void setAPI_key(String API_key) {
        this.API_key = API_key;
    }

    public String getTwo_fa_token() {
        return two_fa_token;
    }

    public void setTwo_fa_token(String two_fa_token) {
        this.two_fa_token = two_fa_token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public Boolean getPhone_number_verified() {
        return phone_number_verified;
    }

    public void setPhone_number_verified(Boolean phone_number_verified) {
        this.phone_number_verified = phone_number_verified;
    }

    public Boolean getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(Boolean email_verified) {
        this.email_verified = email_verified;
    }

    public Boolean getBvn_verified() {
        return bvn_verified;
    }

    public void setBvn_verified(Boolean bvn_verified) {
        this.bvn_verified = bvn_verified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code;
    }

    public String getSettlement_account_number() {
        return settlement_account_number;
    }

    public void setSettlement_account_number(String settlement_account_number) {
        this.settlement_account_number = settlement_account_number;
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

    public AuthCredentials() {
    }

    public AuthCredentials(String token, String email, String client_id, String customer_id, String API_key, String two_fa_token, String first_name, String last_name, String business_name, String phone_number, String active_status, Boolean phone_number_verified, Boolean email_verified, Boolean bvn_verified, String status, String channel_code, String settlement_account_number, String created_at, String updated_at) {
        this.token = token;
        this.email = email;
        this.client_id = client_id;
        this.customer_id = customer_id;
        this.API_key = API_key;
        this.two_fa_token = two_fa_token;
        this.first_name = first_name;
        this.last_name = last_name;
        this.business_name = business_name;
        this.phone_number = phone_number;
        this.active_status = active_status;
        this.phone_number_verified = phone_number_verified;
        this.email_verified = email_verified;
        this.bvn_verified = bvn_verified;
        this.status = status;
        this.channel_code = channel_code;
        this.settlement_account_number = settlement_account_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
