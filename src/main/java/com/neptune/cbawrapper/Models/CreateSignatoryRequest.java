package com.neptune.cbawrapper.Models;

import java.util.List;

public class CreateSignatoryRequest {

    private Integer id;
    private String last_name;
    private String first_name;
    private String middle_name;
    private String sex;
    private String date_of_birth;
    private String title;
    private String contact_phone_number;
    private String alternate_phone;
    private String email_address;
    private String bvn;
    private String address;
    private String signature;
    private String passport_photograph;
    private String nin;
    private String customer_id;
    private List<CreateDocumentData> documents_and_identity;
    private String father_name;
    private String mother_name;
    private String nationality;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContact_phone_number() {
        return contact_phone_number;
    }

    public void setContact_phone_number(String contact_phone_number) {
        this.contact_phone_number = contact_phone_number;
    }

    public String getAlternate_phone() {
        return alternate_phone;
    }

    public void setAlternate_phone(String alternate_phone) {
        this.alternate_phone = alternate_phone;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPassport_photograph() {
        return passport_photograph;
    }

    public void setPassport_photograph(String passport_photograph) {
        this.passport_photograph = passport_photograph;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public List<CreateDocumentData> getDocuments_and_identity() {
        return documents_and_identity;
    }

    public void setDocuments_and_identity(List<CreateDocumentData> documents_and_identity) {
        this.documents_and_identity = documents_and_identity;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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

    public CreateSignatoryRequest(String last_name, String first_name, String middle_name, String sex, String date_of_birth, String title, String contact_phone_number, String alternate_phone, String email_address, String bvn, String address, String signature, String passport_photograph, String customer_id, String nin, List<CreateDocumentData> documents_and_identity, String father_name, String mother_name, String nationality) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.sex = sex;
        this.date_of_birth = date_of_birth;
        this.title = title;
        this.contact_phone_number = contact_phone_number;
        this.alternate_phone = alternate_phone;
        this.email_address = email_address;
        this.bvn = bvn;
        this.address = address;
        this.signature = signature;
        this.passport_photograph = passport_photograph;
        this.customer_id = customer_id;
        this.nin = nin;
        this.documents_and_identity = documents_and_identity;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.nationality = nationality;
    }
}
