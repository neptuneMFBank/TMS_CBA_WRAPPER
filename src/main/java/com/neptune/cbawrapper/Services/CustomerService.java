package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.CustomersModel;
import customers.Customer;
import customers.CustomerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    @Value("${grpc.customer.request.url}")
    private String customer_server_ip;

    @Value("${grpc.customer.request.port}")
    private int customer_server_port;

    private final ErrorLoggingException errorLoggingException;

    public Customer.CreateBulkCorpCustomerResponse createCustomers(List<CustomersModel> customers) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(customer_server_ip, customer_server_port).usePlaintext().build();
        Customer.CreateBulkCorpCustomerResponse response = null;
        try {

            Customer.CreateCorporateAccountRequest.Builder CorporateAcctbuilder = Customer.CreateCorporateAccountRequest.newBuilder();

            for (CustomersModel customers1 : customers) {
                Customer.CustomerOptions customerOptions1 = null;
                Customer.CustomerProductOptions customerProductOptions1 = null;

                if (customers1.getCustomer_options() != null) {
                    customerOptions1 = Customer.CustomerOptions.newBuilder().setIsActive(customers1.getCustomer_options().getIs_active()).setCustomerCreatedAt(customers1.getCustomer_options().getCustomer_created_at()).build(); //new CustomerOptions(customers.get(i).getCustomer_options().getCustomer_created_at(), customers.get(i).getCustomer_options().getIs_active());
                }
                if (customers1.getProduct_options() != null) {
                    customerProductOptions1 = Customer.CustomerProductOptions.newBuilder().setProductCreatedAt(customers1.getProduct_options().getProduct_created_at()).setOldAccountNumber(customers1.getProduct_options().getOld_account_number()).setAccountNumber(customers1.getProduct_options().getAccount_number()).build();
                }

                CorporateAcctbuilder
                        .setCompanyName(customers1.getCompany_name() != null ? customers1.getCompany_name() : "")
                        .setCompanyRegistrationNo(customers1.getCompany_registration_no() != null ? customers1.getCompany_registration_no() : "")
                        .setDateOfRegistration(customers1.getDate_of_registration() != null ? customers1.getDate_of_registration() : "")
                        .setCountryOfRegistration(customers1.getCountry_of_registration() != null ? customers1.getCountry_of_registration() : "")
                        .setCompanyAddress(customers1.getCompany_address() != null ? customers1.getCompany_address() : "")
                        .setState(customers1.getState() != null ? customers1.getState() : "")
                        .setCity(customers1.getCity() != null ? customers1.getCity() : "")
                        .setCountry(customers1.getCountry() != null ? customers1.getCountry() : "")
                        .setLastName(customers1.getLast_name() != null ? customers1.getLast_name() : "")
                        .setBvn(customers1.getBvn() != null ? customers1.getBvn() : "")
                        .setTin(customers1.getTin() != null ? customers1.getTin() : "")
                        .setAddress(customers1.getAddress() != null ? customers1.getAddress() : "")
                        .addAllDirectorData(customers1.getDirector_data() != null && !customers1.getDirector_data().isEmpty() ? customers1.getDirector_data().stream().map(createDirectorRequestSchema1 -> {
                            Customer.CreateDirectorRequest.Builder createDirectorBuilder = Customer.CreateDirectorRequest.newBuilder();
                            return createDirectorBuilder
                                    .setNin(createDirectorRequestSchema1.getNin())
                                    .setCustomerId(createDirectorRequestSchema1.getCustomer_id())
                                    .setIsPrincipal(createDirectorRequestSchema1.getIs_principal())
                                    .setAddress(createDirectorRequestSchema1.getAddress())
                                    .setSignature(createDirectorRequestSchema1.getSignature())
                                    .setPassportPhotograph(createDirectorRequestSchema1.getPassport_photograph())
                                    .setEmail(createDirectorRequestSchema1.getEmail())
                                    .setBvn(createDirectorRequestSchema1.getBvn())
                                    .setMiddleName(createDirectorRequestSchema1.getMiddle_name())
                                    .setContactPhone(createDirectorRequestSchema1.getContact_phone())
                                    .setAlternatePhone(createDirectorRequestSchema1.getAlternate_phone())
                                    .setSex(createDirectorRequestSchema1.getSex())
                                    .setDateOfBirth(createDirectorRequestSchema1.getDate_of_birth())
                                    .setTitle(createDirectorRequestSchema1.getTitle())
                                    .setLastName(createDirectorRequestSchema1.getLast_name())
                                    .setFirstName(createDirectorRequestSchema1.getFirst_name())
                                    .setAddress(createDirectorRequestSchema1.getAddress())
                                    .addAllDocumentsAndIdentity(
                                            customers1.getDocuments() != null && !customers1.getDocuments().isEmpty() ? customers1.getDocuments().stream().map(createDocumentData -> {
                                        Customer.CreateDocumentData.Builder createDocumentBuilder = Customer.CreateDocumentData.newBuilder();
                                        return createDocumentBuilder
                                                .setDocumentName(createDocumentData.getDocument_name())
                                                .setDocumentUrl(createDocumentData.getDocument_url())
                                                .setExpirationDate(createDocumentData.getExpiration_date())
                                                .setDocumentNumber(createDocumentData.getDocument_number())
                                                .setCountryOfIssuance(createDocumentData.getCountry_of_issuance())
                                                .setDateOfIssuance(createDocumentData.getDate_of_issuance())
                                                .setPlaceOfIssuance(createDocumentData.getPlace_of_issuance())
                                                .build();
                                    }
                                    ).collect(Collectors.toList()) : new ArrayList<>()
                                    )
                                    .build();
                        }
                        ).collect(Collectors.toList()) : new ArrayList<>())
                        .setPrincipalOfficerFirstName(customers1.getPrincipal_officer_lastname() != null ? customers1.getPrincipal_officer_lastname() : "")
                        .setSex(customers1.getSex() != null ? customers1.getSex() : "")
                        .setDateOfBirth(customers1.getDate_of_birth() != null ? customers1.getDate_of_birth() : "")
                        .setTitle(customers1.getTitle() != null ? customers1.getTitle() : "")
                        .setContactPhoneNumber(customers1.getContact_phone_number() != null ? customers1.getContact_phone_number() : "")
                        .setAlternatePhone(customers1.getAlternate_phone() != null ? customers1.getAlternate_phone() : "")
                        .setOfficePhoneNumber(customers1.getOffice_phone_number() != null ? customers1.getOffice_phone_number() : "")
                        .setEmailAddress(customers1.getEmail_address() != null ? customers1.getEmail_address() : "")
                        .setNin(customers1.getNin() != null ? customers1.getNin() : "")
                        .setIdType(customers1.getId_type() != null ? customers1.getId_type() : "")
                        .setDateOfExpiration(customers1.getDate_of_expiration() != null ? customers1.getDate_of_expiration() : "")
                        .setPlaceOfIssuance(customers1.getPlace_of_issuance() != null ? customers1.getPlace_of_issuance() : "")
                        .setIdNumber(customers1.getId_number() != null ? customers1.getId_number() : "")
                        .setCountryOfIssuance(customers1.getCountry_of_issuance() != null ? customers1.getCountry_of_issuance() : "")
                        .setDateOfIssuance(customers1.getDate_of_issuance() != null ? customers1.getDate_of_issuance() : "")
                        .setFathersName(customers1.getFathers_name() != null ? customers1.getFathers_name() : "")
                        .setMothersName(customers1.getMothers_name() != null ? customers1.getMothers_name() : "")
                        .setNationality(customers1.getNationality() != null ? customers1.getNationality() : "")
                        .setBusinessCategory(customers1.getBusiness_category() != null ? customers1.getBusiness_category() : "")
                        .setOwnershipStructure(customers1.getOwnership_structure() != null ? customers1.getOwnership_structure() : "")
                        .setProduct(customers1.getProduct() != null ? customers1.getProduct() : "")
                        .setBranchId(customers1.getBranch_id() != null ? customers1.getBranch_id() : "")
                        .setSignature(customers1.getSignature() != null ? customers1.getSignature() : "")
                        .setPhotoUpload(customers1.getPhoto_upload() != null ? customers1.getPhoto_upload() : "")
                        .setIntroducer(customers1.getIntroducer() != null ? customers1.getIntroducer() : "")
                        .setRsm(customers1.getRsm() != null ? customers1.getRsm() : "")
                        .setRestriction(customers1.getRestriction() != null ? customers1.getRestriction() : "")
                        .setPrincipalOfficerFirstName(customers1.getPrincipal_officer_first_name() != null ? customers1.getPrincipal_officer_first_name() : "")
                        .setPrincipalOfficerLastname(customers1.getPrincipal_officer_lastname() != null ? customers1.getPrincipal_officer_lastname() : "")
                        .setPrimaryCompanyAddress(customers1.getPrimary_company_address() != null ? customers1.getPrimary_company_address() : "")
                        .setPrimaryCompanyState(customers1.getPrimary_company_state() != null ? customers1.getPrimary_company_state() : "")
                        .setPrimaryCompanyCity(customers1.getPrimary_company_city() != null ? customers1.getPrimary_company_city() : "")
                        .setPrimaryCompanyCountry(customers1.getPrimary_company_country() != null ? customers1.getPrimary_company_country() : "")
                        .setFirstName(customers1.getFirst_name() != null ? customers1.getFirst_name() : "")
                        .setMiddleName(customers1.getMiddle_name() != null ? customers1.getMiddle_name() : "")
                        .setProductId(customers1.getProduct_id() != null ? customers1.getProduct_id() : "")
                        .setBlockView(customers1.getBlock_view() != null ? customers1.getBlock_view() : true)
                        .addAllDocuments(customers1.getDocuments() != null && !customers1.getDocuments().isEmpty() ? customers1.getDocuments().stream().map(createDocumentData -> {
                            Customer.CreateDocumentData.Builder createDocumentBuilder = Customer.CreateDocumentData.newBuilder();
                            return createDocumentBuilder
                                    .setDocumentName(createDocumentData.getDocument_name())
                                    .setDocumentUrl(createDocumentData.getDocument_url())
                                    .setExpirationDate(createDocumentData.getExpiration_date())
                                    .setDocumentNumber(createDocumentData.getDocument_number())
                                    .setCountryOfIssuance(createDocumentData.getCountry_of_issuance())
                                    .setDateOfIssuance(createDocumentData.getDate_of_issuance())
                                    .setPlaceOfIssuance(createDocumentData.getPlace_of_issuance())
                                    .build();
                        }
                        ).collect(Collectors.toList()) : new ArrayList<>())
                        .setNoOfSignatory(customers1.getNo_of_signatory() != null ? customers1.getNo_of_signatory() : "")
                        .setSmsNotification(customers1.getSms_notification() != null ? customers1.getSms_notification() : true)
                        .setEmailNotification(customers1.getEmail_notification() != null ? customers1.getEmail_notification() : true)
                        .addAllReferenceData(customers1.getReferenceData() != null && !customers1.getReferenceData().isEmpty() ? customers1.getReferenceData().stream().map(reference -> {
                            Customer.Reference.Builder referenceBuilder = Customer.Reference.newBuilder();
                            return referenceBuilder
                                    .setReferenceLastname(reference.getReference_lastname())
                                    .setReferenceFirstName(reference.getReference_first_name())
                                    .setReferenceMiddleName(reference.getReference_middle_name())
                                    .setBankName(reference.getBank_name())
                                    .setBankAddress(reference.getBank_address())
                                    .setAccountNumber(reference.getAccount_number())
                                    .setPhoneNumber(reference.getPhone_number())
                                    .setEmail(reference.getEmail())
                                    .setReferenceForm(reference.getReference_form())
                                    .setFatherName(reference.getFather_name())
                                    .setMotherName(reference.getMother_name())
                                    .setNationality(reference.getNationality())
                                    .setReferenceVerified(reference.getReference_verified())
                                    .build();
                        }
                        ).collect(Collectors.toList()) : new ArrayList<>())
                        .addAllSignatoriesData(customers1.getSignatoriesData() != null && !customers1.getSignatoriesData().isEmpty() ? customers1.getSignatoriesData().stream().map(signatories -> {
                            Customer.CreateSignatoryRequest.Builder signatoriesBuilder = Customer.CreateSignatoryRequest.newBuilder();
                            return signatoriesBuilder
                                    .setLastName(signatories.getLast_name())
                                    .setFirstName(signatories.getFirst_name())
                                    .setMiddleName(signatories.getMiddle_name())
                                    .setSex(signatories.getSex())
                                    .setDateOfBirth(signatories.getDate_of_birth())
                                    .setTitle(signatories.getTitle())
                                    .setContactPhoneNumber(signatories.getContact_phone_number())
                                    .setAlternatePhone(signatories.getAlternate_phone())
                                    .setEmailAddress(signatories.getEmail_address())
                                    .setBvn(signatories.getBvn())
                                    .setAddress(signatories.getAddress())
                                    .setSignature(signatories.getSignature())
                                    .setPassportPhotograph(signatories.getPassport_photograph())
                                    .setNin(signatories.getNin())
                                    .setCustomerId(signatories.getCustomer_id())
                                    .addAllDocumentsAndIdentity(
                                            customers1.getDocuments() != null && !customers1.getDocuments().isEmpty() ? customers1.getDocuments().stream().map(createDocumentData -> {
                                        Customer.CreateDocumentData.Builder createDocumentBuilder = Customer.CreateDocumentData.newBuilder();
                                        return createDocumentBuilder
                                                .setDocumentName(createDocumentData.getDocument_name())
                                                .setDocumentUrl(createDocumentData.getDocument_url())
                                                .setExpirationDate(createDocumentData.getExpiration_date())
                                                .setDocumentNumber(createDocumentData.getDocument_number())
                                                .setCountryOfIssuance(createDocumentData.getCountry_of_issuance())
                                                .setDateOfIssuance(createDocumentData.getDate_of_issuance())
                                                .setPlaceOfIssuance(createDocumentData.getPlace_of_issuance())
                                                .build();
                                    }
                                    ).collect(Collectors.toList()) : new ArrayList<>()
                                    )
                                    .setFatherName(signatories.getFather_name())
                                    .setMotherName(signatories.getMother_name())
                                    .setNationality(signatories.getNationality())
                                    .build();
                        }).collect(Collectors.toList()) : new ArrayList<>())
                        .setIsLinkedAccount(customers1.getIs_linked_account() != null ? customers1.getIs_linked_account() : false)
                        .setLinkedAccountNumber(customers1.getLinked_account_number() != null ? customers1.getLinked_account_number() : "")
                        .setCreationChannelCode(customers1.getCreation_channel_code() != null ? customers1.getCreation_channel_code() : "")
                        .setPrimaryCompanyLga(customers1.getPrimary_company_lga() != null ? customers1.getPrimary_company_lga() : "")
                        .setSectorCode(customers1.getSector_code() != null ? customers1.getSector_code() : "")
                        .setDrivingLicense(customers1.getDriving_license() != null ? customers1.getDriving_license() : "")
                        .build();
            }

            System.out.println("CorporateAcctbuilder = " + CorporateAcctbuilder);

            CustomerServiceGrpc.CustomerServiceBlockingStub stub = CustomerServiceGrpc.newBlockingStub(channel);
            Customer.CreateBulkCorpAccountRequest request = Customer.CreateBulkCorpAccountRequest.newBuilder().addCustomerData(
                    CorporateAcctbuilder
            ).build();

            response = stub.creatBulkCorporateAccount(request);
            channel.shutdownNow();
        } catch (StatusRuntimeException e) {
            Status status = e.getStatus();

            // Handle specific gRPC errors
            if (status.getCode() == Status.Code.UNAVAILABLE) {
                errorLoggingException.logError("CREATE_BULK_CORPORATE_CUSTOMER_UNAVAILABLE", String.valueOf(e.getCause()), e.getMessage());
                log.error("cba error res1: {}", status.getDescription());
                log.error("error from cba1 =: {}", e.getMessage());
            } else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                errorLoggingException.logError("CREATE_BULK_CORPORATE_CUSTOMER_DEADLINE_EXCEEDED", String.valueOf(e.getCause()), e.getMessage());
                log.error("cba error res2: {}", status.getDescription());
                log.error("error from cba2 =: {}", e.getMessage());
            } else {
                errorLoggingException.logError("CREATE_BULK_CORPORATE_CUSTOMER_ERROR", String.valueOf(e.getCause()), e.getMessage());
                log.error("cba error res3: {}", status.getDescription());
                log.error("error from cba3 =: {}", e.getMessage());
            }

            // Log error details
            //e.printStackTrace();
            log.error("createCustomersCBA: ", e);
        }
        return response;
    }
}
