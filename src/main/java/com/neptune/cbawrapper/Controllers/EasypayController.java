package com.neptune.cbawrapper.Controllers;

import com.neptune.cba.transaction.easy_pay.*;
import com.neptune.cba.transaction.easy_pay.EasyPayRequest;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.NameEnquiryResponseModel;
import com.neptune.cbawrapper.Repository.EasypayTransactionsRepository;
import com.neptune.cbawrapper.Repository.NameEnquiryResponseRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.CustomerService;
import com.neptune.cbawrapper.Services.Easypay;
import customers.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/easy_pay")
public class EasypayController {


    private final ErrorLoggingException errorLoggingException;

    @Autowired
    private EasypayTransactionsRepository easypayTransactionsRepository;

    private CustomerService customerService;

    private NameEnquiryResponseRepository nameEnquiryResponseRepository;

    @Autowired
    private Easypay easypay;

//    @PostMapping("/outward_transfer")
//    public ResponseEntity<ResponseSchema<?>> transferOutward(@Valid @RequestBody EasyPayTransferRequestPayload requestPayload){
//        remove originator data and add from our user details
//        EasypayTransactionsModel transactionsModel = new EasypayTransactionsModel();
//        transactionsModel.setBeneficiaryAccountName(requestPayload.getBeneficiaryAccountName());
//        transactionsModel.setBeneficiaryAccountNumber(requestPayload.getBeneficiaryAccountNumber());
//        transactionsModel.setBeneficiaryBankVerificationNumber(requestPayload.getBeneficiaryBankVerificationNumber());
//        transactionsModel.setBeneficiaryKYCLevel(requestPayload.getBeneficiaryKYCLevel());
//        transactionsModel.setOriginatorAccountName(requestPayload.getOriginatorAccountName());
//        transactionsModel.setDestinationInstitutionCode(requestPayload.getDestinationInstitutionCode());
//        transactionsModel.setOriginatorAccountNumber(requestPayload.getOriginatorAccountNumber());
//        transactionsModel.setOriginatorBankVerificationNumber(requestPayload.getOriginatorBankVerificationNumber());
//        transactionsModel.setOriginatorKYCLevel(requestPayload.getOriginatorKYCLevel());
//        transactionsModel.setNameEnquiryRef(requestPayload.getNameEnquiryRef());
//        transactionsModel.setOriginatorNarration(requestPayload.getOriginatorNarration());
//        transactionsModel.setPaymentReference(requestPayload.getPaymentReference());
//        transactionsModel.setTransactionLocation(requestPayload.getTransactionLocation());
//        transactionsModel.setCustomerAccountName(requestPayload.getCustomerAccountName());
//        transactionsModel.setCustomerAccountNumber(requestPayload.getCustomerAccountNumber());
//        transactionsModel.setAmount(requestPayload.getAmount());
//        easypayTransactionsRepository.save(transactionsModel);
//
//        EasyPayResponse response = easypay.transferOutward(requestPayload);
//
//        if(response == null){
//            System.out.println("Response from outward transfer returned null");
//            errorLoggingException.logError("EASY_PAY_RESPONSE_NULL", "Response from outward transfer returned null", "Response from outward transfer returned null");
//
//            EasypayResponseData easypayResponseData = new EasypayResponseData();
//            easypayResponseData.setCode("500");
//            easypayResponseData.setMessage("Response from outward transfer returned null");
//            ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "Response from outward transfer returned null", easypayResponseData, "", ZonedDateTime.now(), false);
//            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
//        }
//        transactionsModel.setMessage(response.getMessage());
//        transactionsModel.setCode(response.getCode());
//        easypayTransactionsRepository.save(transactionsModel);
//
//        System.out.println("response = " + response);
//
//        EasypayResponseData easypayResponseData = new EasypayResponseData();
//        easypayResponseData.setCode(response.getCode());
//        easypayResponseData.setMessage(response.getMessage());
//
//        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, response.getMessage(), easypayResponseData, "", ZonedDateTime.now(), false);
//        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
//    }

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
        String expiry = LocalDateTime.now().plusMinutes(30).toString();
        if(requestPayload.getDestinationInstitutionCode().equals("090329")){
//            save name enquiry data and use the result for /outward_transfer
            String session_Id = UUID.randomUUID().toString();
            String transaction_id = UUID.randomUUID().toString();;
            Customer.NameEnquiryRequest request = Customer.NameEnquiryRequest.newBuilder().setAccountNumber(requestPayload.getAccountNumber()).build();
            Customer.NameEnquiryResponse response = customerService.getCustomerData(request);
            NameEnquiryResponseModel enquiryResponseModel = new NameEnquiryResponseModel();
            enquiryResponseModel.setResponseCode(response.getResponseCode());
            enquiryResponseModel.setSessionID(session_Id);
            enquiryResponseModel.setTransactionId(transaction_id);
            enquiryResponseModel.setChannelCode(1);
            enquiryResponseModel.setDestinationInstitutionCode(requestPayload.getDestinationInstitutionCode());
            enquiryResponseModel.setAccountName(response.getAccountName());
            enquiryResponseModel.setAccountNumber(response.getAccountNumber());
            enquiryResponseModel.setBankVerificationNumber("response.getBankVerificationNumber()");
            enquiryResponseModel.setKycLevel(1);
            enquiryResponseModel.setExpiryTime(expiry);
            nameEnquiryResponseRepository.save(enquiryResponseModel);

            NameEnquiry data = new NameEnquiry();
            data.setExpiry_time(expiry);
            data.setUnique_id(session_Id);
            data.setAccountName(response.getAccountName());


            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", data, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }
        NameEnquiryResponse response = easypay.nameEnquiry(requestPayload);
//
//        remove channel_code, senderBankCode, platform from request body and add from env
        NameEnquiryResponseModel enquiryResponseModel = new NameEnquiryResponseModel();
        enquiryResponseModel.setResponseCode(response.getResponseCode());
        enquiryResponseModel.setSessionID(response.getSessionID());
        enquiryResponseModel.setTransactionId(response.getTransactionId());
        enquiryResponseModel.setChannelCode(response.getChannelCode());
        enquiryResponseModel.setDestinationInstitutionCode(response.getDestinationInstitutionCode());
        enquiryResponseModel.setAccountName(response.getAccountName());
        enquiryResponseModel.setAccountNumber(response.getAccountNumber());
        enquiryResponseModel.setBankVerificationNumber(response.getBankVerificationNumber());
        enquiryResponseModel.setKycLevel(response.getKycLevel());
        enquiryResponseModel.setExpiryTime(expiry);
        nameEnquiryResponseRepository.save(enquiryResponseModel);

        NameEnquiry data = new NameEnquiry();
        data.setExpiry_time(expiry);
        data.setUnique_id(response.getSessionID());
        data.setAccountName(response.getAccountName());

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
            easyPayRequestData.setBeneficiaryAccountName(easyPayRequest.getBeneficiaryAccountName());
            easyPayRequestData.setBeneficiaryAccountNumber(easyPayRequest.getBeneficiaryAccountNumber());
            easyPayRequestData.setBeneficiaryBankVerificationNumber(easyPayRequest.getBeneficiaryBankVerificationNumber());
            easyPayRequestData.setBeneficiaryKYCLevel(easyPayRequest.getBeneficiaryKYCLevel());
            easyPayRequestData.setOriginatorAccountName(easyPayRequest.getOriginatorAccountName());
            easyPayRequestData.setDestinationInstitutionCode(easyPayRequest.getDestinationInstitutionCode());
            easyPayRequestData.setOriginatorAccountNumber(easyPayRequest.getOriginatorAccountNumber());
            easyPayRequestData.setOriginatorBankVerificationNumber(easyPayRequest.getOriginatorBankVerificationNumber());
            easyPayRequestData.setOriginatorKYCLevel(easyPayRequest.getOriginatorKYCLevel());
            easyPayRequestData.setNameEnquiryRef(easyPayRequest.getNameEnquiryRef());
            easyPayRequestData.setOriginatorNarration(easyPayRequest.getOriginatorNarration());
            easyPayRequestData.setPaymentReference(easyPayRequest.getPaymentReference());
            easyPayRequestData.setTransactionLocation(easyPayRequest.getTransactionLocation());
            easyPayRequestData.setCustomerAccountName(easyPayRequest.getCustomerAccountName());
            easyPayRequestData.setCustomerAccountNumber(easyPayRequest.getCustomerAccountNumber());
            easyPayRequestData.setAmount(easyPayRequest.getAmount());
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
