package com.neptune.cbawrapper.Controllers;

import com.neptune.cba.transaction.easy_pay.*;
import com.neptune.cbawrapper.Models.EasypayTransactionsModel;
import com.neptune.cbawrapper.Repository.EasypayTransactionsRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.EasyPayHistoryRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.EasyPayTransferRequestPayload;
import com.neptune.cbawrapper.RequestRessponseSchema.NameEnquiryRequestPayload;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import com.neptune.cbawrapper.Services.Easypay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/v1/easy_pay")
public class EasypayController {

    @Autowired
    private EasypayTransactionsRepository easypayTransactionsRepository;

    @Autowired
    private Easypay easypay;

    @PostMapping("/outward_transfer")
    public ResponseEntity<ResponseSchema<?>> transferOutward(@RequestBody EasyPayTransferRequestPayload requestPayload){
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

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, response.getMessage(), response, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/get_institutions")
    public ResponseEntity<ResponseSchema<?>> getInstitutionsList(){
        Institutions response = easypay.getInstitutions();

        System.out.println("response = " + response);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", response, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/name_enquiry")
    public ResponseEntity<ResponseSchema<?>> nameEnquiry(@RequestBody NameEnquiryRequestPayload requestPayload){
        NameEnquiryResponse response = easypay.nameEnquiry(requestPayload);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", response, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/transaction_history")
    public ResponseEntity<ResponseSchema<?>> getEasyPayHistory(@RequestBody EasyPayHistoryRequest request){
        EasyPayListResponse response = easypay.getEasyPayHistory(request);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", response, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/reverse_transaction")
    public ResponseEntity<ResponseSchema<?>> reverseTransaction(@RequestParam String ref){
        ReverseResponse response = easypay.reverseTransaction(ref);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", response, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @GetMapping("/get_transaction-status")
    public ResponseEntity<ResponseSchema<?>> getTransactionStatus(@RequestParam String ref){
        EasyPayStatusResponse response = easypay.getEasyPayStatus(ref);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", response, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

}
