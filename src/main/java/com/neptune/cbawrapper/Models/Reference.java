/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neptune.cbawrapper.Models;

/**
 *
 * @author Gasper Thompson
 */
public class Reference {

    private Integer id;
    private String reference_lastname;
    private String reference_first_name;
    private String reference_middle_name;
    private String bank_name;
    private String bank_address;
    private String account_number;
    private String phone_number;
    private String email;
    private String reference_form;
    private String father_name;
    private String mother_name;
    private String nationality;
    private Boolean reference_verified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference_lastname() {
        return reference_lastname;
    }

    public void setReference_lastname(String reference_lastname) {
        this.reference_lastname = reference_lastname;
    }

    public String getReference_middle_name() {
        return reference_middle_name;
    }

    public void setReference_middle_name(String reference_middle_name) {
        this.reference_middle_name = reference_middle_name;
    }

    public String getReference_first_name() {
        return reference_first_name;
    }

    public void setReference_first_name(String reference_first_name) {
        this.reference_first_name = reference_first_name;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_address() {
        return bank_address;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getReference_form() {
        return reference_form;
    }

    public void setReference_form(String reference_form) {
        this.reference_form = reference_form;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getReference_verified() {
        return reference_verified;
    }

    public void setReference_verified(Boolean reference_verified) {
        this.reference_verified = reference_verified;
    }

    public Reference(String reference_lastname, String reference_first_name, String reference_middle_name, String bank_name, String bank_address, String account_number, String phone_number, String email, String reference_form, String father_name, String mother_name, String nationality, Boolean reference_verified) {
        this.reference_lastname = reference_lastname;
        this.reference_first_name = reference_first_name;
        this.reference_middle_name = reference_middle_name;
        this.bank_name = bank_name;
        this.bank_address = bank_address;
        this.account_number = account_number;
        this.phone_number = phone_number;
        this.email = email;
        this.reference_form = reference_form;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.nationality = nationality;
        this.reference_verified = reference_verified;
    }
}
