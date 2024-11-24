package com.neptune.cbawrapper.Models;


public class CreateDocumentData {

    private Integer id;
    private String document_name;
    private String document_url;
    private String expiration_date;
    private String document_number;
    private String country_of_issuance;
    private String date_of_issuance;
    private String place_of_issuance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public String getDocument_url() {
        return document_url;
    }

    public void setDocument_url(String document_url) {
        this.document_url = document_url;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getCountry_of_issuance() {
        return country_of_issuance;
    }

    public void setCountry_of_issuance(String country_of_issuance) {
        this.country_of_issuance = country_of_issuance;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getDate_of_issuance() {
        return date_of_issuance;
    }

    public void setDate_of_issuance(String date_of_issuance) {
        this.date_of_issuance = date_of_issuance;
    }

    public String getPlace_of_issuance() {
        return place_of_issuance;
    }

    public void setPlace_of_issuance(String place_of_issuance) {
        this.place_of_issuance = place_of_issuance;
    }

    public CreateDocumentData(String document_name, String document_url, String expiration_date, String document_number, String country_of_issuance, String date_of_issuance, String place_of_issuance) {
        this.document_name = document_name;
        this.document_url = document_url;
        this.expiration_date = expiration_date;
        this.document_number = document_number;
        this.country_of_issuance = country_of_issuance;
        this.date_of_issuance = date_of_issuance;
        this.place_of_issuance = place_of_issuance;
    }
}
