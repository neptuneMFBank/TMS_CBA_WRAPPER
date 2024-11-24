package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "3ppuser")
public class Create3ppUser {


    @Id
    private String id;
    private String email;
    private String phone_number;
    private String country;
    private String address;
    private String password;
    private String business_name;
    private String settlement_account_number;

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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getSettlement_account_number() {
        return settlement_account_number;
    }

    public void setSettlement_account_number(String settlement_account_number) {
        this.settlement_account_number = settlement_account_number;
    }

    public Create3ppUser(String email, String phone_number, String country, String address, String password, String business_name, String settlement_account_number) {
        this.email = email;
        this.phone_number = phone_number;
        this.country = country;
        this.address = address;
        this.password = password;
        this.business_name = business_name;
        this.settlement_account_number = settlement_account_number;
    }
}
