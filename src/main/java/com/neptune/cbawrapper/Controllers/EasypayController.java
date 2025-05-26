package com.neptune.cbawrapper.Controllers;

import com.neptune.cba.transaction.easy_pay.*;
import com.neptune.cbawrapper.Models.EasypayTransactionsModel;
import com.neptune.cbawrapper.Repository.EasypayTransactionsRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.CustomerService;
import com.neptune.cbawrapper.Services.Easypay;
import customers.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/easy_pay")
public class EasypayController {

    @Autowired
    private EasypayTransactionsRepository easypayTransactionsRepository;

    private CustomerService customerService;

    @Autowired
    private Easypay easypay;

    @PostMapping("/outward_transfer")
    public ResponseEntity<ResponseSchema<?>> transferOutward(@RequestBody EasyPayTransferRequestPayload requestPayload){
//        remove originator data and add from our user details
        EasypayTransactionsModel transactionsModel = new EasypayTransactionsModel();
        transactionsModel.setRequestId(requestPayload.getRequestId());
        transactionsModel.setSourceInstitutionCode(requestPayload.getSourceInstitutionCode());
        transactionsModel.setBeneficiaryAccountName(requestPayload.getBeneficiaryAccountName());
        transactionsModel.setBeneficiaryAccountNumber(requestPayload.getBeneficiaryAccountNumber());
        transactionsModel.setBeneficiaryBankVerificationNumber(requestPayload.getBeneficiaryBankVerificationNumber());
        transactionsModel.setBeneficiaryKYCLevel(requestPayload.getBeneficiaryKYCLevel());
        transactionsModel.setOriginatorAccountName(requestPayload.getOriginatorAccountName());
        transactionsModel.setDestinationInstitutionCode(requestPayload.getDestinationInstitutionCode());
        transactionsModel.setOriginatorAccountNumber(requestPayload.getOriginatorAccountNumber());
        transactionsModel.setOriginatorBankVerificationNumber(requestPayload.getOriginatorBankVerificationNumber());
        transactionsModel.setOriginatorKYCLevel(requestPayload.getOriginatorKYCLevel());
        transactionsModel.setMandateReferenceNumber(requestPayload.getMandateReferenceNumber());
        transactionsModel.setNameEnquiryRef(requestPayload.getNameEnquiryRef());
        transactionsModel.setOriginatorNarration(requestPayload.getOriginatorNarration());
        transactionsModel.setPaymentReference(requestPayload.getPaymentReference());
        transactionsModel.setTransactionLocation(requestPayload.getTransactionLocation());
        transactionsModel.setBeneficiaryNarration(requestPayload.getBeneficiaryNarration());
        transactionsModel.setBillerId(requestPayload.getBillerId());
        transactionsModel.setCustomerAccountName(requestPayload.getCustomerAccountName());
        transactionsModel.setCustomerAccountNumber(requestPayload.getCustomerAccountNumber());
        transactionsModel.setAmount(requestPayload.getAmount());
        transactionsModel.setNipResponse(requestPayload.getNipResponse());
        transactionsModel.setStatus(requestPayload.getStatus());
        transactionsModel.setSessionId(requestPayload.getSessionId());
        transactionsModel.setTransactionId(requestPayload.getTransactionId());
        easypayTransactionsRepository.save(transactionsModel);

        EasyPayResponse response = easypay.transferOutward(requestPayload);
        transactionsModel.setMessage(response.getMessage());
        transactionsModel.setCode(response.getCode());
        easypayTransactionsRepository.save(transactionsModel);

        System.out.println("response = " + response);

        EasypayResponseData easypayResponseData = new EasypayResponseData();
        easypayResponseData.setCode(response.getCode());
        easypayResponseData.setMessage(response.getMessage());

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, response.getMessage(), easypayResponseData, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/get_institutions")
    public ResponseEntity<ResponseSchema<?>> getInstitutionsList(){
        Institutions response = easypay.getInstitutions();

        InstitutionsData institutionsData = new InstitutionsData();
        List<InstitutionData> institutionDataList = getInstitutionData(response);
        institutionsData.setInstitutions(institutionDataList);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", institutionsData, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    private static List<InstitutionData> getInstitutionData(Institutions response) {
        List<InstitutionData> institutionDataList = new ArrayList<>();
        for (int i = 0; i < response.getInstitutionsList().size(); i++) {
            InstitutionData institutionData = new InstitutionData();
            institutionData.setInstitutionCode(response.getInstitutions(i).getInstitutionCode());
            institutionData.setCategory(response.getInstitutions(i).getCategory());
            institutionData.setInstitutionName(response.getInstitutions(i).getInstitutionName());
            institutionDataList.add(institutionData);
        }
        return institutionDataList;
    }

    @GetMapping("/name_enquiry")
    public ResponseEntity<ResponseSchema<?>> nameEnquiry(@RequestBody NameEnquiryRequestPayload requestPayload){
        if(requestPayload.getDestinationInstitutionCode().equals("inter")){
            Customer.NameEnquiryRequest request = Customer.NameEnquiryRequest.newBuilder().setAccountNumber(requestPayload.getAccountNumber()).build();
            Customer.NameEnquiryResponse response = customerService.getCustomerData(request);
            NameEnquiryResponseData data = new NameEnquiryResponseData();
            data.setResponseCode(response.getResponseCode());
            data.setSessionID("response.getSessionID()");
            data.setTransactionId("response.getTransactionId()");
            data.setChannelCode(1);
            data.setDestinationInstitutionCode(requestPayload.getDestinationInstitutionCode());
            data.setAccountName(response.getAccountName());
            data.setAccountNumber(response.getAccountNumber());
            data.setBankVerificationNumber("response.getBankVerificationNumber()");
            data.setKycLevel(1);

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", data, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }
        NameEnquiryResponse response = easypay.nameEnquiry(requestPayload);
//
//        remove channel_code, senderBankCode, platform from request body and add from env
        NameEnquiryResponseData data = new NameEnquiryResponseData();
        data.setResponseCode(response.getResponseCode());
        data.setSessionID(response.getSessionID());
        data.setTransactionId(response.getTransactionId());
        data.setChannelCode(response.getChannelCode());
        data.setDestinationInstitutionCode(response.getDestinationInstitutionCode());
        data.setAccountName(response.getAccountName());
        data.setAccountNumber(response.getAccountNumber());
        data.setBankVerificationNumber(response.getBankVerificationNumber());
        data.setKycLevel(response.getKycLevel());

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", data, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/transaction_history")
    public ResponseEntity<ResponseSchema<?>> getEasyPayHistory(@RequestBody EasyPayHistoryRequest request){
        EasyPayListResponse response = easypay.getEasyPayHistory(request);

        System.out.println("response = " + response);

        EasyPayListResponseData easyPayListResponseData = new EasyPayListResponseData();

        List<EasyPayRequestData> requestDataList = new ArrayList<>();
        for (int i = 0; i < response.getEasypaysList().size(); i++) {
            EasyPayRequest easyPayRequest = response.getEasypays(i);
            EasyPayRequestData easyPayRequestData = new EasyPayRequestData();
            easyPayRequestData.setSourceInstitutionCode(easyPayRequest.getSourceInstitutionCode());
            easyPayRequestData.setBeneficiaryAccountName(easyPayRequest.getBeneficiaryAccountName());
            easyPayRequestData.setBeneficiaryAccountNumber(easyPayRequest.getBeneficiaryAccountNumber());
            easyPayRequestData.setBeneficiaryBankVerificationNumber(easyPayRequest.getBeneficiaryBankVerificationNumber());
            easyPayRequestData.setBeneficiaryKYCLevel(easyPayRequest.getBeneficiaryKYCLevel());
            easyPayRequestData.setOriginatorAccountName(easyPayRequest.getOriginatorAccountName());
            easyPayRequestData.setDestinationInstitutionCode(easyPayRequest.getDestinationInstitutionCode());
            easyPayRequestData.setOriginatorAccountNumber(easyPayRequest.getOriginatorAccountNumber());
            easyPayRequestData.setOriginatorBankVerificationNumber(easyPayRequest.getOriginatorBankVerificationNumber());
            easyPayRequestData.setOriginatorKYCLevel(easyPayRequest.getOriginatorKYCLevel());
            easyPayRequestData.setMandateReferenceNumber(easyPayRequest.getMandateReferenceNumber());
            easyPayRequestData.setNameEnquiryRef(easyPayRequest.getNameEnquiryRef());
            easyPayRequestData.setOriginatorNarration(easyPayRequest.getOriginatorNarration());
            easyPayRequestData.setPaymentReference(easyPayRequest.getPaymentReference());
            easyPayRequestData.setTransactionLocation(easyPayRequest.getTransactionLocation());
            easyPayRequestData.setBeneficiaryNarration(easyPayRequest.getBeneficiaryNarration());
            easyPayRequestData.setBillerId(easyPayRequest.getBillerId());
            easyPayRequestData.setCustomerAccountName(easyPayRequest.getCustomerAccountName());
            easyPayRequestData.setCustomerAccountNumber(easyPayRequest.getCustomerAccountNumber());
            easyPayRequestData.setAmount(easyPayRequest.getAmount());
            easyPayRequestData.setId(easyPayRequest.getId());
            easyPayRequestData.setNipResponse(easyPayRequest.getNipResponse());
            easyPayRequestData.setStatus(easyPayRequest.getStatus());
            easyPayRequestData.setSessionId(easyPayRequest.getSessionId());
            easyPayRequestData.setTransactionId(easyPayRequest.getTransactionId());
            requestDataList.add(easyPayRequestData);
        }
        easyPayListResponseData.setEasyPayRequestData(requestDataList);
        easyPayListResponseData.setTotalItems(response.getTotalItems());
        easyPayListResponseData.setCurrentPages(response.getCurrentPages());

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", easyPayListResponseData, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/reverse_transaction")
    public ResponseEntity<ResponseSchema<?>> reverseTransaction(@RequestParam String ref){
        ReverseResponse response = easypay.reverseTransaction(ref);

        System.out.println("response = " + response);

        if(response == null){
            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }
        ReverseResponseData reverseResponseData = new ReverseResponseData();
        reverseResponseData.setResponse(response.getResponse());
        reverseResponseData.setCode(response.getCode());

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", reverseResponseData, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/get_transaction-status")
    public ResponseEntity<ResponseSchema<?>> getTransactionStatus(@RequestParam String ref){
        EasyPayStatusResponse response = easypay.getEasyPayStatus(ref);

        ReverseResponseData reverseResponseData = new ReverseResponseData();
        reverseResponseData.setResponse(response.getResponse());
        reverseResponseData.setCode(response.getCode());

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", reverseResponseData, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

}
