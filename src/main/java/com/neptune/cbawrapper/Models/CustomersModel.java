package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document(collection = "customers")
public class CustomersModel {

    @Id
    private String id;
    private String company_name;
    private String company_registration_no;
    private String date_of_registration;
    private String country_of_registration;
    private String company_address;
    private String state;
    private String city;
    private String country;
    private String last_name;
    private String bvn;
    private String tin;
    private String address;

    private List<CreateDirectorRequest> director_data;
    private String principal_officer_middle_name;
    private String sex;
    private String date_of_birth;
    private String title;
    private String contact_phone_number;
    private String alternate_phone;
    private String office_phone_number;
    private String email_address;
    private String nin;
    private String id_type;
    private String date_of_expiration;
    private String place_of_issuance;
    private String id_number;
    private String country_of_issuance;
    private String date_of_issuance;
    private String fathers_name;
    private String mothers_name;
    private String nationality;
    private String business_category;
    private String ownership_structure;
    private String Product;
    private String branch_id;
    private String signature;
    private String Photo_upload;
    private String introducer;
    private String rsm;
    private String restriction;
    private String principal_officer_lastname;
    private String principal_officer_first_name;
    private String primary_company_address;
    private String primary_company_state;
    private String primary_company_city;
    private String primary_company_country;
    private String first_name;
    private String middle_name;
    private String product_id;
    private Boolean block_view; // true or false
    private List<CreateDocumentData> documents; // array of doc data
    private String  no_of_signatory;
    private Boolean sms_notification; // true or false
    private Boolean email_notification;
    private List<Reference> referenceData;
    private List<CreateSignatoryRequest> signatoriesData;
    private CustomerOptions customer_options;
    private CustomerProductOptions product_options;
    private Boolean is_linked_account;
    private String  linked_account_number;
    private String  creation_channel_code;
    private String  primary_company_lga; // 22/07/24
    private String  sector_code;
    private String  driving_license;
    private Boolean is_updated;
    private String account_num;
    private String cba_customer_id;
    private String savingsAccountId;

    private String incorpNo;
    private String dateOfBirth;
    private String countryOfRegistration;
    private String mobileNo;
    private Integer savingsId;
    private String firstname;
    private String middlename;
    private String lastname;
    private String displayName;
    private String emailAddress;

    private String createdAt;

    private String updatedAt;

    public CustomersModel(String incorpNo, String dateOfBirth, String countryOfRegistration, String mobileNo, Integer savingsId, String firstname, String middlename, String lastname, String displayName, String emailAddress) {
        this.incorpNo = incorpNo;
        this.dateOfBirth = dateOfBirth;
        this.countryOfRegistration = countryOfRegistration;
        this.mobileNo = mobileNo;
        this.savingsId = savingsId;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.displayName = displayName;
        this.emailAddress = emailAddress;
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

    public String getIncorpNo() {
        return incorpNo;
    }

    public void setIncorpNo(String incorpNo) {
        this.incorpNo = incorpNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfRegistration() {
        return countryOfRegistration;
    }

    public void setCountryOfRegistration(String countryOfRegistration) {
        this.countryOfRegistration = countryOfRegistration;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Integer getSavingsId() {
        return savingsId;
    }

    public void setSavingsId(Integer savingsId) {
        this.savingsId = savingsId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSavingsAccountId() {
        return savingsAccountId;
    }

    public void setSavingsAccountId(String savingsAccountId) {
        this.savingsAccountId = savingsAccountId;
    }

    public String getCba_customer_id() {
        return cba_customer_id;
    }

    public void setCba_customer_id(String cba_customer_id) {
        this.cba_customer_id = cba_customer_id;
    }

    public String getAccount_num() {
        return account_num;
    }

    public void setAccount_num(String account_num) {
        this.account_num = account_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_registration_no() {
        return company_registration_no;
    }

    public void setCompany_registration_no(String company_registration_no) {
        this.company_registration_no = company_registration_no;
    }

    public String getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(String date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    public String getCountry_of_registration() {
        return country_of_registration;
    }

    public void setCountry_of_registration(String country_of_registration) {
        this.country_of_registration = country_of_registration;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CreateDirectorRequest> getDirector_data() {
        return director_data;
    }

    public void setDirector_data(List<CreateDirectorRequest> director_data) {
        this.director_data = director_data;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPrincipal_officer_middle_name() {
        return principal_officer_middle_name;
    }

    public void setPrincipal_officer_middle_name(String principal_officer_middle_name) {
        this.principal_officer_middle_name = principal_officer_middle_name;
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

    public String getOffice_phone_number() {
        return office_phone_number;
    }

    public void setOffice_phone_number(String office_phone_number) {
        this.office_phone_number = office_phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getDate_of_expiration() {
        return date_of_expiration;
    }

    public void setDate_of_expiration(String date_of_expiration) {
        this.date_of_expiration = date_of_expiration;
    }

    public String getPlace_of_issuance() {
        return place_of_issuance;
    }

    public void setPlace_of_issuance(String place_of_issuance) {
        this.place_of_issuance = place_of_issuance;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getCountry_of_issuance() {
        return country_of_issuance;
    }

    public void setCountry_of_issuance(String country_of_issuance) {
        this.country_of_issuance = country_of_issuance;
    }

    public String getDate_of_issuance() {
        return date_of_issuance;
    }

    public void setDate_of_issuance(String date_of_issuance) {
        this.date_of_issuance = date_of_issuance;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }

    public String getMothers_name() {
        return mothers_name;
    }

    public void setMothers_name(String mothers_name) {
        this.mothers_name = mothers_name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBusiness_category() {
        return business_category;
    }

    public void setBusiness_category(String business_category) {
        this.business_category = business_category;
    }

    public String getOwnership_structure() {
        return ownership_structure;
    }

    public void setOwnership_structure(String ownership_structure) {
        this.ownership_structure = ownership_structure;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    public String getPhoto_upload() {
        return Photo_upload;
    }

    public void setPhoto_upload(String photo_upload) {
        Photo_upload = photo_upload;
    }

    public String getRsm() {
        return rsm;
    }

    public void setRsm(String rsm) {
        this.rsm = rsm;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }

    public String getPrincipal_officer_lastname() {
        return principal_officer_lastname;
    }

    public void setPrincipal_officer_lastname(String principal_officer_lastname) {
        this.principal_officer_lastname = principal_officer_lastname;
    }

    public String getPrincipal_officer_first_name() {
        return principal_officer_first_name;
    }

    public void setPrincipal_officer_first_name(String principal_officer_first_name) {
        this.principal_officer_first_name = principal_officer_first_name;
    }

    public String getPrimary_company_address() {
        return primary_company_address;
    }

    public void setPrimary_company_address(String primary_company_address) {
        this.primary_company_address = primary_company_address;
    }

    public String getPrimary_company_state() {
        return primary_company_state;
    }

    public void setPrimary_company_state(String primary_company_state) {
        this.primary_company_state = primary_company_state;
    }

    public String getPrimary_company_city() {
        return primary_company_city;
    }

    public void setPrimary_company_city(String primary_company_city) {
        this.primary_company_city = primary_company_city;
    }

    public String getPrimary_company_country() {
        return primary_company_country;
    }

    public void setPrimary_company_country(String primary_company_country) {
        this.primary_company_country = primary_company_country;
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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Boolean getBlock_view() {
        return block_view;
    }

    public void setBlock_view(Boolean block_view) {
        this.block_view = block_view;
    }

    public List<CreateDocumentData> getDocuments() {
        return documents;
    }

    public void setDocuments(List<CreateDocumentData> documents) {
        this.documents = documents;
    }

    public String getNo_of_signatory() {
        return no_of_signatory;
    }

    public void setNo_of_signatory(String no_of_signatory) {
        this.no_of_signatory = no_of_signatory;
    }

    public Boolean getEmail_notification() {
        return email_notification;
    }

    public void setEmail_notification(Boolean email_notification) {
        this.email_notification = email_notification;
    }

    public Boolean getSms_notification() {
        return sms_notification;
    }

    public void setSms_notification(Boolean sms_notification) {
        this.sms_notification = sms_notification;
    }

    public List<Reference> getReferenceData() {
        return referenceData;
    }

    public void setReferenceData(List<Reference> referenceData) {
        this.referenceData = referenceData;
    }

    public List<CreateSignatoryRequest> getSignatoriesData() {
        return signatoriesData;
    }

    public void setSignatoriesData(List<CreateSignatoryRequest> signatoriesData) {
        this.signatoriesData = signatoriesData;
    }

    public CustomerOptions getCustomer_options() {
        return customer_options;
    }

    public void setCustomer_options(CustomerOptions customer_options) {
        this.customer_options = customer_options;
    }

    public CustomerProductOptions getProduct_options() {
        return product_options;
    }

    public void setProduct_options(CustomerProductOptions product_options) {
        this.product_options = product_options;
    }

    public Boolean getIs_linked_account() {
        return is_linked_account;
    }

    public void setIs_linked_account(Boolean is_linked_account) {
        this.is_linked_account = is_linked_account;
    }

    public String getLinked_account_number() {
        return linked_account_number;
    }

    public void setLinked_account_number(String linked_account_number) {
        this.linked_account_number = linked_account_number;
    }

    public String getCreation_channel_code() {
        return creation_channel_code;
    }

    public void setCreation_channel_code(String creation_channel_code) {
        this.creation_channel_code = creation_channel_code;
    }

    public String getPrimary_company_lga() {
        return primary_company_lga;
    }

    public void setPrimary_company_lga(String primary_company_lga) {
        this.primary_company_lga = primary_company_lga;
    }

    public String getSector_code() {
        return sector_code;
    }

    public void setSector_code(String sector_code) {
        this.sector_code = sector_code;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public void setDriving_license(String driving_license) {
        this.driving_license = driving_license;
    }

    public Boolean getIs_updated() {
        return is_updated;
    }

    public void setIs_updated(Boolean is_updated) {
        this.is_updated = is_updated;
    }

    public CustomersModel(String first_name, String middle_name, String company_name, String company_registration_no, String date_of_registration, String country_of_registration, Boolean sms_notification, Boolean email_notification, String tin, String email_address, String contact_phone_number, boolean is_updated, int savingsId, String createdAt, String updatedAt) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.company_name = company_name;
        this.company_registration_no = company_registration_no;
        this.date_of_registration = date_of_registration;
        this.country_of_registration = country_of_registration;
        this.sms_notification = sms_notification;
        this.email_notification = email_notification;
        this.tin = tin;
        this.email_address = email_address;
        this.contact_phone_number = contact_phone_number;
        this.is_updated = is_updated;
        this.savingsId = savingsId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public CustomersModel() {
    }

    public CustomersModel(String first_name, String last_name, String company_name, String company_registration_no, String date_of_registration, String country_of_registration, Boolean sms_notification, Boolean email_notification, String tin, String email_address, String contact_phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_name = company_name;
        this.company_registration_no = company_registration_no;
        this.date_of_registration = date_of_registration;
        this.country_of_registration = country_of_registration;
        this.sms_notification = sms_notification;
        this.email_notification = email_notification;
        this.tin = tin;
        this.email_address = email_address;
        this.contact_phone_number = contact_phone_number;
    }

    public CustomersModel(String company_name, String company_registration_no, String date_of_registration, String company_address, String country_of_registration, String state, String city, String country, String last_name, String bvn, String tin, String address, List<CreateDirectorRequest> director_data, String principal_officer_middle_name, String sex, String date_of_birth, String title, String contact_phone_number, String alternate_phone, String office_phone_number, String email_address, String nin, String id_type, String date_of_expiration, String place_of_issuance, String id_number, String country_of_issuance, String date_of_issuance, String fathers_name, String mothers_name, String nationality, String business_category, String ownership_structure, String product, String branch_id, String signature, String photo_upload, String introducer, String rsm, String restriction, String principal_officer_lastname, String principal_officer_first_name, String primary_company_address, String primary_company_state, String primary_company_city, String primary_company_country, String first_name, String middle_name, String product_id, Boolean block_view, List<CreateDocumentData> documents, String no_of_signatory, Boolean sms_notification, Boolean email_notification, List<Reference> referenceData, List<CreateSignatoryRequest> signatoriesData, CustomerOptions customer_options, CustomerProductOptions product_options, Boolean is_linked_account, String linked_account_number, String creation_channel_code, String primary_company_lga, String driving_license, String sector_code) {
        this.company_name = company_name;
        this.company_registration_no = company_registration_no;
        this.date_of_registration = date_of_registration;
        this.company_address = company_address;
        this.country_of_registration = country_of_registration;
        this.state = state;
        this.city = city;
        this.country = country;
        this.last_name = last_name;
        this.bvn = bvn;
        this.tin = tin;
        this.address = address;
        this.director_data = director_data;
        this.principal_officer_middle_name = principal_officer_middle_name;
        this.sex = sex;
        this.date_of_birth = date_of_birth;
        this.title = title;
        this.contact_phone_number = contact_phone_number;
        this.alternate_phone = alternate_phone;
        this.office_phone_number = office_phone_number;
        this.email_address = email_address;
        this.nin = nin;
        this.id_type = id_type;
        this.date_of_expiration = date_of_expiration;
        this.place_of_issuance = place_of_issuance;
        this.id_number = id_number;
        this.country_of_issuance = country_of_issuance;
        this.date_of_issuance = date_of_issuance;
        this.fathers_name = fathers_name;
        this.mothers_name = mothers_name;
        this.nationality = nationality;
        this.business_category = business_category;
        this.ownership_structure = ownership_structure;
        Product = product;
        this.branch_id = branch_id;
        this.signature = signature;
        Photo_upload = photo_upload;
        this.introducer = introducer;
        this.rsm = rsm;
        this.restriction = restriction;
        this.principal_officer_lastname = principal_officer_lastname;
        this.principal_officer_first_name = principal_officer_first_name;
        this.primary_company_address = primary_company_address;
        this.primary_company_state = primary_company_state;
        this.primary_company_city = primary_company_city;
        this.primary_company_country = primary_company_country;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.product_id = product_id;
        this.block_view = block_view;
        this.documents = documents;
        this.no_of_signatory = no_of_signatory;
        this.sms_notification = sms_notification;
        this.email_notification = email_notification;
        this.referenceData = referenceData;
        this.signatoriesData = signatoriesData;
        this.customer_options = customer_options;
        this.product_options = product_options;
        this.is_linked_account = is_linked_account;
        this.linked_account_number = linked_account_number;
        this.creation_channel_code = creation_channel_code;
        this.primary_company_lga = primary_company_lga;
        this.driving_license = driving_license;
        this.sector_code = sector_code;
    }
}
