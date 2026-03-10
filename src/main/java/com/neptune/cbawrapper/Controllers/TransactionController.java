package com.neptune.cbawrapper.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neptune.cba.transaction.balance.BalanceResponse;
import com.neptune.cba.transaction.bills.BillType;
import com.neptune.cba.transaction.bills.BillsTsqResponse;
import com.neptune.cba.transaction.bills.MakePaymentRequest;
import com.neptune.cba.transaction.bills.MakePaymentResponse;
import com.neptune.cba.transaction.easy_pay.EasyPayResponse;
import com.neptune.cba.transaction.history.HistoryResponse;
import com.neptune.cba.transaction.history.TransactionCategory;
import com.neptune.cba.transaction.history.TransactionStatusResponse;
import com.neptune.cba.transaction.intra_transfer.IntraTransferResponse;
import com.neptune.cbawrapper.BuilderPattern.HistoryBuilder;
import com.neptune.cbawrapper.BuilderPattern.TransactionHistoryBuilder;
import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.*;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.MakePayment;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.MakePaymentApiResponse;
import com.neptune.cbawrapper.Services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import printable.PrintableOuterClass;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

@RestController
@RequestMapping("/api/v1/pos")
@RequiredArgsConstructor
public class TransactionController {

    @Autowired
    private BillsPayment billsPayment;

    private final ObjectMapper objectMapper;

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionsRepository transactionsRepository;
    private final TransactionCoreController transactionCoreController;
    private final VirtualAccountRepository virtualAccountRepository;
    private final CbaTransactionRequestsRepository cbaTransactionRequests;
    private final ErrorLoggingException errorLoggingException;
    private final PushyAPI pushyAPI;
    private final HistoryService historyService;
    private final PlatformChargeRepository platformChargeRepository;
    private final DebitCreditService debitCreditService;
    private final PosTransactionRepository posTransactionRepository;
    private final Helpers helpers;
    private final BillsPaymentDataRepository billsPaymentDataRepository;
    private final BusinessPlatformChargesRepository businessPlatformChargesRepository;
    private final NameEnquiryResponseRepository nameEnquiryResponseRepository;
    private final EasypayTransactionsRepository easypayTransactionsRepository;
    private final EchannelServices echannelServices;
    private final Notifications notifications;
    private final BillsService billsService;
    private final Printable printable;
    private final TransactionService transactionService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    private Easypay easypay;

    //todo: transactions notifications from CBA
    @CrossOrigin(origins = "*")
    @PutMapping("/update-terminal-fcm-token")
    public ResponseEntity<ResponseSchema<?>> updateTerminalFcmToken(@RequestBody FcmRequest request) {
        try {
            Optional<VirtualAccountModel> getVirtualAccount = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

            if (getVirtualAccount.isPresent()) {
                VirtualAccountModel virtualAccountModel = getVirtualAccount.get();
                virtualAccountModel.setFcmToken(request.getFcmToken());
                virtualAccountRepository.save(virtualAccountModel);
                ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "fcm token added successfully", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.OK);
            }
            errorLoggingException.logError("UPDATE_TERMINAL_FCM_TOKEN", "terminal with id not found", "terminal with id not found");
            ResponseSchema<?> responseSchema = new ResponseSchema<>(409, "terminal with id not found", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
        } catch (Exception e) {
            errorLoggingException.logError("UPDATE_TERMINAL_FCM_TOKEN", String.valueOf(e.getCause()), e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //TODO: CBA transaction notification webhook
    @CrossOrigin(origins = "*")
    @PostMapping("/pos-credit-webhook")
    public ResponseEntity<ResponseSchema<?>> getCreditUpdate(@RequestBody WebHookRequest webHookRequest) {
        try {
            System.out.println("webHookRequest = " + webHookRequest.toString());
            Optional<Transactions> checkIfTransactionWithRefExists = transactionsRepository.checkIfTransactionWithRefExists(webHookRequest.getTransactionreference());

            Transactions transactions;
            if (checkIfTransactionWithRefExists.isEmpty()) {
                transactions = new Transactions();
                transactions.setAccountnumber(webHookRequest.getAccountnumber());
                transactions.setIsccode(webHookRequest.getIsccode());
                transactions.setAccountstatus(webHookRequest.getAccountstatus());
                transactions.setAcctname(webHookRequest.getAcctname());
                transactions.setDrcr(webHookRequest.getDrcr());
                transactions.setAcctype(webHookRequest.getAcctype());
                transactions.setAmount(webHookRequest.getAmount());
                transactions.setTransactionreference(webHookRequest.getTransactionreference());
                transactions.setNarration(webHookRequest.getNarration());
                transactions.setChannel(webHookRequest.getChannel());
                transactions.setEid(webHookRequest.getEid());
                transactions.setEvent(webHookRequest.getEvent());
            } else {
                transactions = checkIfTransactionWithRefExists.get();
                transactions.setAmount(webHookRequest.getAmount());
                transactions.setEvent(webHookRequest.getEvent());
            }
            transactionsRepository.save(transactions);
            String event;
            int status_code;

            if (webHookRequest.getEvent().equalsIgnoreCase("transaction.init")) {
                event = "Transaction initialized";
                status_code = 201;
            } else if ((webHookRequest.getEvent().equalsIgnoreCase("transaction.successful"))) {
                event = "Transaction successful";
                status_code = 200;
            } else if (webHookRequest.getEvent().equalsIgnoreCase("transaction.failed")) {
                event = "Transaction failed";
                status_code = 500;
            } else {
                event = "Unknown event occured";
                status_code = 500;
            }

            Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByAccount(webHookRequest.getAccountnumber());
            if (virtualAccountModel.isPresent()) {
//                SendNotifications notifications1 = new SendNotifications();
//                notifications1.setMessage("Transaction received");
//                notifications1.setTitle("Transactions Notifications");
//                notifications1.setReceiverFcmToken(virtualAccountModel.get().getFcmToken());
//                notifications.sendNotification(notifications1);
                Map<String, Object> notification = new HashMap<>();

                notification.put("badge", 1);
                notification.put("sound", "ping.aiff");
                notification.put("title", "Test Notification");
                notification.put("body", "Hello World \u270c");

                String[] to = new String[]{virtualAccountModel.get().getFcmToken()};
                // Set payload (any object, it will be serialized to JSON)
                Map<String, String> payload = new HashMap<>();
                PushyPushRequest request = new PushyPushRequest(to, payload, notification);
                // Add "message" parameter to payload
                payload.put("message", webHookRequest.toString());
                pushyAPI.sendPush(request);


                ResponseSchema<?> responseSchema = new ResponseSchema<>(status_code, event, null, "", ZonedDateTime.now(), false);
                if (status_code == 200) {
                    return new ResponseEntity<>(responseSchema, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "Account number not found", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            errorLoggingException.logError("UPDATE_TERMINAL_FCM_TOKEN", String.valueOf(e.getCause()), e.getMessage());
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from debit credit1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/transaction")
//    public ResponseEntity<ResponseSchema<?>> creditDebitAcct(@RequestHeader("auth_token") String authToken, @Valid @RequestBody String data) {
//        System.out.println("data = " + data);
//        System.out.println("authToken " + authToken);
//        ResponseSchema responseData = new ResponseSchema<>();
//        ObjectMapper mapper = new ObjectMapper();
////        try {
//            boolean checkIfTokenIsValid = helpers.isAuthTokenValid(authToken, data);
//
//        CorepayPosTransactionRequest request = null;
//        try {
//            request = mapper.readValue(data, CorepayPosTransactionRequest.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("request = " + request);
//            request.setDateFormat("dd MMMM yyyy");
//            request.setStatus("pending");
////            request.setNarration("credit user");
//            request.setLocale("en");
//
//
//            System.out.println("got here 112233");
//        CorepayPosTransactionRequest decryptedData = helpers.decryptObject("RwhmDwxsYVAQ4EhbBP7D+AF5xB39+j65KdEL6kTLhxsujaz7n82YxkXW7JBJml0iWJ7DCugHF5jtUu5IBol7zZFaGPWNyDx96EpKCwTPVbmbnCUjA9IyrMH0Aw+EnNmkdyhHgPGhIOdV8/xZplJpoc0AZrJLcHWKmn/dzHfTGaOsLvBRPciEllbM8rcWsbcaX7f0aYqR6quZnpW2nmcsz9b7U+xMxdsIHtZcbvLu3lXPCQGG1NZzXAIpXYvTKsUuAY+X4Mr4Hn5KMSAialC2D25uw2l91/lXNbsgdVbxhjJBSc5K5uVSPV1A0DHbrnuXHbh3D+JGI1TJ0zUe5yIz8bJLKzYVEcO5rmByeSn9GzBI+jbli6qFyPHNzWYUhWoZApkIDwhOgNIzr9vvnwbko5VSM16EADfun0YqXjYNhes80rDYxRZxnkxiXyTTVzDRHbh3D+JGI1TJ0zUe5yIz8brro83vwhK2o96PSxVWn0GScjZTt62rzwm9IPXhGz6qodqzuTmZWa6u+TOAzvAjj7ahbAiABp6gGkl8Z3qANbwWtOvAdD9k6phdkqyJznCYpxA6/Z7aOC9kHyAvnQJgMgxwrUGMWBKxKvc2c9ysr6IPyVxO5xxCS14Vba4+bqNJA8x09pa6xdAyjuQdTcc3oefveXWsBLh0C0QJt9InKPiTiJU/HZbhehzZT608uZOUq/9QEDL5pPz39qGKgdu/lzKNgs0XG8/c1ASEv2SvL954eDSlrIqvXOlHqNIO7tqsLRNSYqYgWAV5Dvylm1zhPuJQrtt/KY6Jh3sneuosKuRx3PxnXC2zzdiWZSjJ+a/e4TxVOu9GBulMvR7MM6uQbA==", CorepayPosTransactionRequest.class);
//
//        System.out.println("decryptedData = " + decryptedData);
//
////        if (!checkIfTokenIsValid) {
////            responseData.setData(null);
////            responseData.setMessage("Invalid auth token");
//////            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
////            responseData.setTimeStamp(ZonedDateTime.now());
////            responseData.setEnc(false);
////            responseData.setStatus(401);
////            return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
////        }
//
//            Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());
//
//            if (virtualAccountModel.isEmpty()) {
//                errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "account with Terminal id not found", "account with Terminal id not found");
//                responseData.setMessage("account with Terminal id not found");
//                responseData.setStatus(404);
//                responseData.setTimeStamp(ZonedDateTime.now());
//                responseData.setData(null);
//                return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
//            }
//
//            BalanceResponse balance = debitCreditService.getBalance(virtualAccountModel.get().getVirtual_account_number(), virtualAccountModel.get().getParent_id());
//
////            String hashedPassword = passwordEncoder.encode(request.getPin());
//
////            System.out.println("hashedPassword = " +hashedPassword);
////            System.out.println("virtualAccountModel.get().getPin() = " + virtualAccountModel.get().getPin());
//
//            if(request.isBillsPayment() || request.isTransfer()) {
//                boolean isAuthenticated = passwordEncoder.matches(request.getPin(), virtualAccountModel.get().getPin());
//
//                if (!isAuthenticated) {
//                    responseData.setMessage("Unauthorized");
//                    responseData.setStatus(401);
//                    responseData.setTimeStamp(ZonedDateTime.now());
//                    responseData.setData(null);
//                    return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
//                }
//            }
////            System.out.println("kellyabel");
//
////            System.out.println("platformName = " + request.getTransactionPlatform());
////            System.out.println("platformId = " + request.getPaymentTypeId());
//
//            Optional<PlatformCharges> platformCharges = platformChargeRepository.getChargeByName(request.getTransactionPlatform());
//
//            if(platformCharges.isEmpty()){
//                errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "transactionPlatform not found", "transactionPlatform not found");
//                responseData.setMessage("transactionPlatform not found");
//                responseData.setStatus(404);
//                responseData.setTimeStamp(ZonedDateTime.now());
//                responseData.setData(null);
//                return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
//            }
//
//            TransactionRequestSchema transactionRequestSchema = new TransactionRequestSchema();
//            transactionRequestSchema.setPan(request.getPan());
//            transactionRequestSchema.setResponseCode(request.getResponseCode());
//            transactionRequestSchema.setPtad(request.getPtad());
//            transactionRequestSchema.setReference(request.getReference());
//            transactionRequestSchema.setTransactionReference(request.getTransactionReference());
//            transactionRequestSchema.setAmount(request.getAmount());
//            transactionRequestSchema.setTransactionDate(request.getTransactionDate());
//            transactionRequestSchema.setTransactionType(request.getTransactionType());
//            transactionRequestSchema.setDateFormat("dd MMMM yyyy");
//            transactionRequestSchema.setStatus("pending");
//            transactionRequestSchema.setNarration("credit user");
//            transactionRequestSchema.setTerminalId(request.getTerminalId());
////            transactionRequestSchema.setTransactionPlatformId(platformCharges.get().getId());
//            transactionRequestSchema.setPaymentTypeId(request.getPaymentTypeId());
//            transactionRequestSchema.setMerchantId(request.getMerchantId());
//            transactionRequestSchema.setLocale("en");
//            transactionRequestSchema.setSerialNo(request.getSerialNo());
//            transactionRequestSchema.setStan(request.getStan());
//            transactionRequestSchema.setMerchantName(request.getMerchantName());
//            transactionRequestSchema.setReversal(request.getReversal());
//            transactionRequestSchema.setMerchantCode(request.getMerchantCode());
//            transactionRequestSchema.setAuthCode(request.getAuthCode());
//            transactionRequestSchema.setRetrievalReferencenumber(request.getRetrievalReferenceNumber());
//            transactionRequestSchema.setProcessingFee(request.getProcessingFee());
//            transactionRequestSchema.setTransactionFee(request.getTransactionFee());
//            transactionRequestSchema.setCardExpiry(request.getCardExpiry());
//            transactionRequestSchema.setCardScheme(request.getCardScheme());
//            transactionRequestSchema.setCreated_at(ZonedDateTime.now().toString());
//            transactionRequestSchema.setUpdated_at(ZonedDateTime.now().toString());
//            posTransactionRepository.save(transactionRequestSchema);
//
//            if(request.isBillsPayment()){
//                try {
//                    double amount = Double.parseDouble(request.getMakePayment().getAmount())/100;
//                    if(balance.getEffectiveBalance() - amount < 0){
//                        ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, "Insufficient balance", null, "", ZonedDateTime.now(), true);
//                        return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//                    }
//                    double charge = 100;
//                    BillType billType = BillType.BILLS;
//                    if(request.getMakePayment().getBillType().equals("AIRTIME_DATA")) {
//                        String number = helpers.normalizePhoneNumber(request.getMakePayment().getCustomerId());
//                        request.getMakePayment().setCustomerId(number);
//                        charge = 0;
//                        billType = BillType.AIRTIME_DATA;
//                    }
//                    request.getMakePayment().setRequestReference("2103" + (System.currentTimeMillis() / 100));
//                    request.getMakePayment().setAmount(String.valueOf(amount));
//                    System.out.println("request = " + request.getMakePayment());
//
//                    MakePaymentApiResponse validateCustomer = billsService.makePayment(request.getMakePayment(), charge, billType);
//                    System.out.println("validateCustomer = " + validateCustomer);
//
//                    BillsPaymentData billsPaymentData = new BillsPaymentData();
//                    billsPaymentData.setPaymentCode(request.getMakePayment().getPaymentCode());
//                    billsPaymentData.setCustomerId(request.getMakePayment().getCustomerId());
//                    billsPaymentData.setEmail(request.getMakePayment().getEmail());
//                    billsPaymentData.setMobile(request.getMakePayment().getMobile());
//                    billsPaymentData.setAmount(request.getMakePayment().getAmount());
//                    billsPaymentData.setCustomerAccountNumber(request.getMakePayment().getCustomerAccountNumber());
//                    billsPaymentData.setBillType(request.getMakePayment().getBillType());
//                    billsPaymentData.setResponse(validateCustomer);
//                    billsPaymentData.setRequestReference(request.getMakePayment().getRequestReference());
//                    billsPaymentData.setBillsAdditionalData(validateCustomer.getBillsAdditionalData());
//
//                    billsPaymentDataRepository.save(billsPaymentData);
//
//                    ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "successful", validateCustomer, "", ZonedDateTime.now(), true);
//                    return new ResponseEntity<>(responseSchema, HttpStatus.OK);
//                } catch (Exception e) {
////                    throw new RuntimeException(e);
//                    ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), e, "", ZonedDateTime.now(), true);
//                    return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//                }
//            } else if (request.isTransfer()) {
//                try {
//                    double amount = request.getAmount() + 20;
//
//                    if(balance.getEffectiveBalance() - amount < 0){
//                        ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, "Insufficient balance", null, "", ZonedDateTime.now(), true);
//                        return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//                    }
////                    String session_Id = "2103" + (System.currentTimeMillis() / 100);
//                    Optional<NameEnquiryResponseModel> enquiryResponseModel = nameEnquiryResponseRepository.getNameEnquiryById(request.getNameEnquirySessionID());
//
//                    if(enquiryResponseModel.isEmpty()){
//                        return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
//                    }
//
//                    if (enquiryResponseModel.get().getDestinationInstitutionCode().equalsIgnoreCase("090329")){
//                        System.out.println("ggggggg");
//                        //TODO: Treat as neptune transfer
//                        IntraTransfer intraTransfer = IntraTransfer.builder()
//                                .customerId(virtualAccountModel.get().getParent_id())
//                                .mobilekey("")
//                                .fromaccount(virtualAccountModel.get().getVirtual_account_number())
//                                .fromacctname(virtualAccountModel.get().getAccount_name())
//                                .fromaccountstatus("active")
//                                .fromaccountemail(virtualAccountModel.get().getEmail())
//                                .fromacctype("")
//                                .toaccount(enquiryResponseModel.get().getAccountNumber())
//                                .toacctname(enquiryResponseModel.get().getAccountName())
//                                .toacctype("savings")
//                                .amount(request.getAmount())
//                                .tokenType("")
//                                .transactionreference("intra_"+request.getNameEnquirySessionID())
//                                .narration(request.getNarration())
//                                .build();
//                        System.out.println("intraTransfer = " + intraTransfer);
//                        IntraTransferResponseData response = transactionService.intraTransfer(intraTransfer);
//
//                        System.out.println("response 22 = " + response);
//                        if(response.getResponsecode().equals("401")){
//                            ResponseSchema<?> responseSchema = new ResponseSchema<>(401, response.getResponsemessage(), "", "", ZonedDateTime.now(), false);
//                            return new ResponseEntity<>(responseSchema, HttpStatus.UNAUTHORIZED);
//                        }
//                        responseData.setMessage(response.getResponsemessage());
//                        responseData.setStatus(Integer.parseInt(response.getResponsecode()));
//                        responseData.setTimeStamp(ZonedDateTime.now());
//                        responseData.setData(response);
//                        return new ResponseEntity<>(responseData, HttpStatus.OK);
//                    } // after pos is activated -> send mail to set pin -> call the backend to save the pin
//
//                    EasypayTransactionsModel transactionsModel = new EasypayTransactionsModel();
//                    transactionsModel.setPaymentReference("inter_"+request.getNameEnquirySessionID());
//                    transactionsModel.setBeneficiaryAccountName(enquiryResponseModel.get().getAccountName());
//                    transactionsModel.setBeneficiaryAccountNumber(enquiryResponseModel.get().getAccountNumber());
//                    transactionsModel.setBeneficiaryBankVerificationNumber(enquiryResponseModel.get().getBankVerificationNumber());
//                    transactionsModel.setBeneficiaryKYCLevel(String.valueOf(enquiryResponseModel.get().getKycLevel()));
//                    transactionsModel.setOriginatorAccountName(virtualAccountModel.get().getAccount_name());
//                    transactionsModel.setDestinationInstitutionCode(enquiryResponseModel.get().getDestinationInstitutionCode());
//                    transactionsModel.setOriginatorAccountNumber(virtualAccountModel.get().getVirtual_account_number());
//                    transactionsModel.setOriginatorBankVerificationNumber(virtualAccountModel.get().getBvn());
//                    transactionsModel.setOriginatorKYCLevel(1);
//                    transactionsModel.setNameEnquiryRef(enquiryResponseModel.get().getRef());
//                    transactionsModel.setOriginatorNarration(request.getNarration());
//                    transactionsModel.setTransactionLocation(request.getTransactionLocation());
//                    transactionsModel.setCustomerAccountName(virtualAccountModel.get().getAccount_name());
//                    transactionsModel.setCustomerAccountNumber(virtualAccountModel.get().getVirtual_account_number());
//                    transactionsModel.setAmount(request.getAmount());
//                    transactionsModel.setCharge(20);
//                    easypayTransactionsRepository.save(transactionsModel);
//
//                    EasyPayResponse response = easypay.transferOutward(transactionsModel);
//
//                    System.out.println("response = " + response);
//                    if(response == null){
//                        errorLoggingException.logError("EASY_PAY_RESPONSE_NULL", "Response from outward transfer returned null", "Response from outward transfer returned null");
//
//                        EasypayResponseData easypayResponseData = new EasypayResponseData();
//                        easypayResponseData.setCode("500");
//                        easypayResponseData.setMessage("insufficient funds");
//                        ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "insufficient funds", easypayResponseData, "", ZonedDateTime.now(), false);
//                        return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//                    }
//                    System.out.println("response 112 = " + response.getCode());
//
//                    transactionsModel.setMessage(response.getMessage());
//                    transactionsModel.setCode(response.getCode());
//                    easypayTransactionsRepository.save(transactionsModel);
//
//                    System.out.println("response = " + response);
//
//                    EasypayResponseData easypayResponseData = new EasypayResponseData();
//                    easypayResponseData.setCode(response.getCode());
//                    easypayResponseData.setMessage(response.getMessage());
//
//                    ResponseSchema<?> responseSchema = new ResponseSchema<>(200, response.getMessage(), easypayResponseData, "", ZonedDateTime.now(), false);
//                    return new ResponseEntity<>(responseSchema, HttpStatus.OK);
//                } catch (Exception e) {
//                    ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), e, "", ZonedDateTime.now(), false);
//                    return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//                }
//            } else {
//                UpdateTransactionResponseSchema responseSchema = helpers.registerTransactionToTMS(request, platformCharges);//.createTransaction(transactionDetails);
//                System.out.println("responseSchema = " + responseSchema);
//
//                if (responseSchema.getResourceId() != null && request.getResponseCode().equals("00")) {
//                    System.out.println("================================ " + virtualAccountModel.get().getVirtual_account_number());
//
////                    Optional<BusinessPlatformCharges> businessPlatformCharges = businessPlatformChargesRepository.getChargeByAcct(virtualAccountModel.get().getParent_account());
////
////                    if (businessPlatformCharges == null || businessPlatformCharges.isEmpty()) {
////                        errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "business platform charge not found", "business Platform not found");
////                        responseData.setMessage("business platform charge not found");
////                        responseData.setStatus(404);
////                        responseData.setTimeStamp(ZonedDateTime.now());
////                        responseData.setData(null);
////                        return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
////                    }
//
//                    TransactionDrCr transactionDrCr = new TransactionDrCr();
//                    transactionDrCr.setAccountnumber(virtualAccountModel.get().getVirtual_account_number());
//                    transactionDrCr.setIsccode("2");
//                    transactionDrCr.setAccountstatus("active");
//                    transactionDrCr.setUpdatedToCba(false);
//                    transactionDrCr.setTerminalId(request.getTerminalId());
//                    transactionDrCr.setAcctname(virtualAccountModel.get().getAccount_name());
//                    transactionDrCr.setDrcr("cr");
//                    transactionDrCr.setTransaction_business_platform_id("");
//                    transactionDrCr.setAcctype("savings");
//                    transactionDrCr.setAmount(transactionRequestSchema.getAmount());
//                    transactionDrCr.setTransactionreference(helpers.generateTransactId(request.getTerminalId(), transactionRequestSchema.getTransactionReference()));
//                    transactionDrCr.setNarration(transactionRequestSchema.getNarration());
//                    transactionDrCr.setPosRef(transactionRequestSchema.getTransactionReference());
//                    transactionDrCr.setChannel("1");
//                    transactionDrCr.setResponseCode(request.getResponseCode());
//                    transactionDrCr.setEid("");
//                    transactionDrCr.setType("transaction");
//                    transactionDrCr.setParent_id("");
//                    transactionDrCr.setCbaMessage("");
//                    transactionDrCr.setResourceId(responseSchema.getResourceId());
//                    transactionDrCr.setTransaction_platform_id(request.getTransactionPlatform());
//                    transactionDrCr.setCardScheme(request.getCardScheme());
//                    transactionDrCr.setCreated_at(LocalDateTime.now().toString());
//                    transactionDrCr.setUpdated_at(LocalDateTime.now().toString());
//                    cbaTransactionRequests.save(transactionDrCr);
//
//                    responseData.setMessage("success");
//                    responseData.setStatus(200);
//                    responseData.setTimeStamp(ZonedDateTime.now());
//                    responseData.setData(transactionDrCr);
//                    return new ResponseEntity<>(responseData, HttpStatus.OK);
//                }
//            }
//

    /// /        } catch (Exception e) {
    /// /            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
    /// /            log.error("error from debit credit1 =: {}", e.getMessage());
    /// /            responseData.setMessage(e.getMessage());
    /// /            responseData.setStatus(500);
    /// /            responseData.setTimeStamp(ZonedDateTime.now());
    /// /            responseData.setData(null);
    /// /            return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    /// /        }
    /// /        return responseData;
//        return new ResponseEntity<>(responseData, HttpStatus.OK);
//    }
//    @PostMapping("/transactions")
//    public DeferredResult<ResponseEntity<ResponseSchema<?>>> creditDebitAcctsss(@RequestHeader("auth_token") String authToken, @Valid @RequestBody String data) {
//        System.out.println("data = " + data);
//        System.out.println("authToken " + authToken);
//        ResponseSchema responseData = new ResponseSchema<>();
//        ObjectMapper mapper = new ObjectMapper();
////        try {
//        boolean checkIfTokenIsValid = helpers.isAuthTokenValid(authToken, data);
//
//        CorepayPosTransactionRequest request = null;
//        try {
//            request = mapper.readValue(data, CorepayPosTransactionRequest.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("request = " + request);
//        request.setDateFormat("dd MMMM yyyy");
//        request.setStatus("pending");
////            request.setNarration("credit user");
//        request.setLocale("en");
//
//
//        System.out.println("got here 112233");
//        CorepayPosTransactionRequest decryptedData = helpers.decryptObject("RwhmDwxsYVAQ4EhbBP7D+AF5xB39+j65KdEL6kTLhxsujaz7n82YxkXW7JBJml0iWJ7DCugHF5jtUu5IBol7zZFaGPWNyDx96EpKCwTPVbmbnCUjA9IyrMH0Aw+EnNmkdyhHgPGhIOdV8/xZplJpoc0AZrJLcHWKmn/dzHfTGaOsLvBRPciEllbM8rcWsbcaX7f0aYqR6quZnpW2nmcsz9b7U+xMxdsIHtZcbvLu3lXPCQGG1NZzXAIpXYvTKsUuAY+X4Mr4Hn5KMSAialC2D25uw2l91/lXNbsgdVbxhjJBSc5K5uVSPV1A0DHbrnuXHbh3D+JGI1TJ0zUe5yIz8bJLKzYVEcO5rmByeSn9GzBI+jbli6qFyPHNzWYUhWoZApkIDwhOgNIzr9vvnwbko5VSM16EADfun0YqXjYNhes80rDYxRZxnkxiXyTTVzDRHbh3D+JGI1TJ0zUe5yIz8brro83vwhK2o96PSxVWn0GScjZTt62rzwm9IPXhGz6qodqzuTmZWa6u+TOAzvAjj7ahbAiABp6gGkl8Z3qANbwWtOvAdD9k6phdkqyJznCYpxA6/Z7aOC9kHyAvnQJgMgxwrUGMWBKxKvc2c9ysr6IPyVxO5xxCS14Vba4+bqNJA8x09pa6xdAyjuQdTcc3oefveXWsBLh0C0QJt9InKPiTiJU/HZbhehzZT608uZOUq/9QEDL5pPz39qGKgdu/lzKNgs0XG8/c1ASEv2SvL954eDSlrIqvXOlHqNIO7tqsLRNSYqYgWAV5Dvylm1zhPuJQrtt/KY6Jh3sneuosKuRx3PxnXC2zzdiWZSjJ+a/e4TxVOu9GBulMvR7MM6uQbA==", CorepayPosTransactionRequest.class);
//
//        System.out.println("decryptedData = " + decryptedData);
//
////        if (!checkIfTokenIsValid) {
////            responseData.setData(null);
////            responseData.setMessage("Invalid auth token");
//////            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
////            responseData.setTimeStamp(ZonedDateTime.now());
////            responseData.setEnc(false);
////            responseData.setStatus(401);
////            return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
////        }
//
//        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());
//
//        if (virtualAccountModel.isEmpty()) {
//            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "account with Terminal id not found", "account with Terminal id not found");
//            responseData.setMessage("account with Terminal id not found");
//            responseData.setStatus(404);
//            responseData.setTimeStamp(ZonedDateTime.now());
//            responseData.setData(null);
//            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
//        }
//
//        BalanceResponse balance = debitCreditService.getBalance(virtualAccountModel.get().getVirtual_account_number(), virtualAccountModel.get().getParent_id());
//
////            String hashedPassword = passwordEncoder.encode(request.getPin());
//
////            System.out.println("hashedPassword = " +hashedPassword);
////            System.out.println("virtualAccountModel.get().getPin() = " + virtualAccountModel.get().getPin());
//
//        if (request.isBillsPayment() || request.isTransfer()) {
//            boolean isAuthenticated = passwordEncoder.matches(request.getPin(), virtualAccountModel.get().getPin());
//
//            if (!isAuthenticated) {
//                responseData.setMessage("Unauthorized");
//                responseData.setStatus(401);
//                responseData.setTimeStamp(ZonedDateTime.now());
//                responseData.setData(null);
//                return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
//            }
//        }
////            System.out.println("kellyabel");
//
////            System.out.println("platformName = " + request.getTransactionPlatform());
////            System.out.println("platformId = " + request.getPaymentTypeId());
//
//        Optional<PlatformCharges> platformCharges = platformChargeRepository.getChargeByName(request.getTransactionPlatform());
//
//        if (platformCharges.isEmpty()) {
//            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "transactionPlatform not found", "transactionPlatform not found");
//            responseData.setMessage("transactionPlatform not found");
//            responseData.setStatus(404);
//            responseData.setTimeStamp(ZonedDateTime.now());
//            responseData.setData(null);
//            return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
//        }
//
//        TransactionRequestSchema transactionRequestSchema = new TransactionRequestSchema();
//        transactionRequestSchema.setPan(request.getPan());
//        transactionRequestSchema.setResponseCode(request.getResponseCode());
//        transactionRequestSchema.setPtad(request.getPtad());
//        transactionRequestSchema.setReference(request.getReference());
//        transactionRequestSchema.setTransactionReference(request.getTransactionReference());
//        transactionRequestSchema.setAmount(request.getAmount());
//        transactionRequestSchema.setTransactionDate(request.getTransactionDate());
//        transactionRequestSchema.setTransactionType(request.getTransactionType());
//        transactionRequestSchema.setDateFormat("dd MMMM yyyy");
//        transactionRequestSchema.setStatus("pending");
//        transactionRequestSchema.setNarration("credit user");
//        transactionRequestSchema.setTerminalId(request.getTerminalId());
////            transactionRequestSchema.setTransactionPlatformId(platformCharges.get().getId());
//        transactionRequestSchema.setPaymentTypeId(request.getPaymentTypeId());
//        transactionRequestSchema.setMerchantId(request.getMerchantId());
//        transactionRequestSchema.setLocale("en");
//        transactionRequestSchema.setSerialNo(request.getSerialNo());
//        transactionRequestSchema.setStan(request.getStan());
//        transactionRequestSchema.setMerchantName(request.getMerchantName());
//        transactionRequestSchema.setReversal(request.getReversal());
//        transactionRequestSchema.setMerchantCode(request.getMerchantCode());
//        transactionRequestSchema.setAuthCode(request.getAuthCode());
//        transactionRequestSchema.setRetrievalReferencenumber(request.getRetrievalReferenceNumber());
//        transactionRequestSchema.setProcessingFee(request.getProcessingFee());
//        transactionRequestSchema.setTransactionFee(request.getTransactionFee());
//        transactionRequestSchema.setCardExpiry(request.getCardExpiry());
//        transactionRequestSchema.setCardScheme(request.getCardScheme());
//        transactionRequestSchema.setCreated_at(ZonedDateTime.now().toString());
//        transactionRequestSchema.setUpdated_at(ZonedDateTime.now().toString());
//        posTransactionRepository.save(transactionRequestSchema);
//
//        if (request.isBillsPayment()) {
//            // DeferredResult holds the HTTP connection open with a 90s timeout
//            DeferredResult<ResponseEntity<ResponseSchema<?>>> deferredResult =
//                    new DeferredResult<>(90_000L, () -> {
//                        ResponseSchema<?> timeoutResponse = new ResponseSchema<>(
//                                504, "Payment query timed out", null, "", ZonedDateTime.now(), true
//                        );
//                        return new ResponseEntity<>(timeoutResponse, HttpStatus.GATEWAY_TIMEOUT);
//                    });
//
//            try {
//                double amount = Double.parseDouble(request.getMakePayment().getAmount()) / 100;
//                if (balance.getEffectiveBalance() - amount < 0) {
//                    ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "Insufficient balance", null, "", ZonedDateTime.now(), true);
//                    deferredResult.setResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
//                    return deferredResult;
//                }
//
//                double charge = 100;
//                BillType billType = BillType.BILLS;
//                if (request.getMakePayment().getBillType().equals("AIRTIME_DATA")) {
//                    String number = helpers.normalizePhoneNumber(request.getMakePayment().getCustomerId());
//                    request.getMakePayment().setCustomerId(number);
//                    charge = 0;
//                    billType = BillType.AIRTIME_DATA;
//                }
//
//                request.getMakePayment().setRequestReference("2103" + (System.currentTimeMillis() / 100));
//                request.getMakePayment().setAmount(String.valueOf(amount));
//
//                // Persist initial record
//                BillsPaymentData billsPaymentData = new BillsPaymentData();
//                billsPaymentData.setPaymentCode(request.getMakePayment().getPaymentCode());
//                billsPaymentData.setCustomerId(request.getMakePayment().getCustomerId());
//                billsPaymentData.setEmail(request.getMakePayment().getEmail());
//                billsPaymentData.setMobile(request.getMakePayment().getMobile());
//                billsPaymentData.setAmount(request.getMakePayment().getAmount());
//                billsPaymentData.setCustomerAccountNumber(request.getMakePayment().getCustomerAccountNumber());
//                billsPaymentData.setBillType(request.getMakePayment().getBillType());
//                billsPaymentData.setRequestReference(request.getMakePayment().getRequestReference());
//                billsPaymentDataRepository.save(billsPaymentData);
//
//                // Hand off to async service — request thread is immediately freed
//                processPaymentAndQuery(
//                        request.getMakePayment(), billsPaymentData, charge, billType, deferredResult
//                );
//
//            } catch (Exception e) {
//                ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), null, "", ZonedDateTime.now(), true);
//                deferredResult.setResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
//            }
//
//            return deferredResult; // returns immediately, HTTP connection stays open
//        } else if (request.isTransfer()) {
//            try {
//                double amount = request.getAmount() + 20;
//
//                if (balance.getEffectiveBalance() - amount < 0) {
//                    ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "Insufficient balance", null, "", ZonedDateTime.now(), true);
//                    return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//                }
////                    String session_Id = "2103" + (System.currentTimeMillis() / 100);
//                Optional<NameEnquiryResponseModel> enquiryResponseModel = nameEnquiryResponseRepository.getNameEnquiryById(request.getNameEnquirySessionID());
//
//                if (enquiryResponseModel.isEmpty()) {
//                    return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
//                }
//
//                if (enquiryResponseModel.get().getDestinationInstitutionCode().equalsIgnoreCase("090329")) {
//                    System.out.println("ggggggg");
//                    //TODO: Treat as neptune transfer
//                    IntraTransfer intraTransfer = IntraTransfer.builder()
//                            .customerId(virtualAccountModel.get().getParent_id())
//                            .mobilekey("")
//                            .fromaccount(virtualAccountModel.get().getVirtual_account_number())
//                            .fromacctname(virtualAccountModel.get().getAccount_name())
//                            .fromaccountstatus("active")
//                            .fromaccountemail(virtualAccountModel.get().getEmail())
//                            .fromacctype("")
//                            .toaccount(enquiryResponseModel.get().getAccountNumber())
//                            .toacctname(enquiryResponseModel.get().getAccountName())
//                            .toacctype("savings")
//                            .amount(request.getAmount())
//                            .tokenType("")
//                            .transactionreference("intra_" + request.getNameEnquirySessionID())
//                            .narration(request.getNarration())
//                            .build();
//                    System.out.println("intraTransfer = " + intraTransfer);
//                    IntraTransferResponseData response = transactionService.intraTransfer(intraTransfer);
//
//                    System.out.println("response 22 = " + response);
//                    if (response.getResponsecode().equals("401")) {
//                        ResponseSchema<?> responseSchema = new ResponseSchema<>(401, response.getResponsemessage(), "", "", ZonedDateTime.now(), false);
//                        return new ResponseEntity<>(responseSchema, HttpStatus.UNAUTHORIZED);
//                    }
//                    responseData.setMessage(response.getResponsemessage());
//                    responseData.setStatus(Integer.parseInt(response.getResponsecode()));
//                    responseData.setTimeStamp(ZonedDateTime.now());
//                    responseData.setData(response);
//                    return new ResponseEntity<>(responseData, HttpStatus.OK);
//                } // after pos is activated -> send mail to set pin -> call the backend to save the pin
//
//                EasypayTransactionsModel transactionsModel = new EasypayTransactionsModel();
//                transactionsModel.setPaymentReference("inter_" + request.getNameEnquirySessionID());
//                transactionsModel.setBeneficiaryAccountName(enquiryResponseModel.get().getAccountName());
//                transactionsModel.setBeneficiaryAccountNumber(enquiryResponseModel.get().getAccountNumber());
//                transactionsModel.setBeneficiaryBankVerificationNumber(enquiryResponseModel.get().getBankVerificationNumber());
//                transactionsModel.setBeneficiaryKYCLevel(String.valueOf(enquiryResponseModel.get().getKycLevel()));
//                transactionsModel.setOriginatorAccountName(virtualAccountModel.get().getAccount_name());
//                transactionsModel.setDestinationInstitutionCode(enquiryResponseModel.get().getDestinationInstitutionCode());
//                transactionsModel.setOriginatorAccountNumber(virtualAccountModel.get().getVirtual_account_number());
//                transactionsModel.setOriginatorBankVerificationNumber(virtualAccountModel.get().getBvn());
//                transactionsModel.setOriginatorKYCLevel(1);
//                transactionsModel.setNameEnquiryRef(enquiryResponseModel.get().getRef());
//                transactionsModel.setOriginatorNarration(request.getNarration());
//                transactionsModel.setTransactionLocation(request.getTransactionLocation());
//                transactionsModel.setCustomerAccountName(virtualAccountModel.get().getAccount_name());
//                transactionsModel.setCustomerAccountNumber(virtualAccountModel.get().getVirtual_account_number());
//                transactionsModel.setAmount(request.getAmount());
//                transactionsModel.setCharge(20);
//                easypayTransactionsRepository.save(transactionsModel);
//
//                EasyPayResponse response = easypay.transferOutward(transactionsModel);
//
//                System.out.println("response = " + response);
//                if (response == null) {
//                    errorLoggingException.logError("EASY_PAY_RESPONSE_NULL", "Response from outward transfer returned null", "Response from outward transfer returned null");
//
//                    EasypayResponseData easypayResponseData = new EasypayResponseData();
//                    easypayResponseData.setCode("500");
//                    easypayResponseData.setMessage("insufficient funds");
//                    ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "insufficient funds", easypayResponseData, "", ZonedDateTime.now(), false);
//                    return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//                }
//                System.out.println("response 112 = " + response.getCode());
//
//                transactionsModel.setMessage(response.getMessage());
//                transactionsModel.setCode(response.getCode());
//                easypayTransactionsRepository.save(transactionsModel);
//
//                System.out.println("response = " + response);
//
//                EasypayResponseData easypayResponseData = new EasypayResponseData();
//                easypayResponseData.setCode(response.getCode());
//                easypayResponseData.setMessage(response.getMessage());
//
//                ResponseSchema<?> responseSchema = new ResponseSchema<>(200, response.getMessage(), easypayResponseData, "", ZonedDateTime.now(), false);
//                return new ResponseEntity<>(responseSchema, HttpStatus.OK);
//            } catch (Exception e) {
//                ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), e, "", ZonedDateTime.now(), false);
//                return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            UpdateTransactionResponseSchema responseSchema = helpers.registerTransactionToTMS(request, platformCharges);//.createTransaction(transactionDetails);
//            System.out.println("responseSchema = " + responseSchema);
//
//            if (responseSchema.getResourceId() != null && request.getResponseCode().equals("00")) {
//                System.out.println("================================ " + virtualAccountModel.get().getVirtual_account_number());
//
////                    Optional<BusinessPlatformCharges> businessPlatformCharges = businessPlatformChargesRepository.getChargeByAcct(virtualAccountModel.get().getParent_account());
////
////                    if (businessPlatformCharges == null || businessPlatformCharges.isEmpty()) {
////                        errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "business platform charge not found", "business Platform not found");
////                        responseData.setMessage("business platform charge not found");
////                        responseData.setStatus(404);
////                        responseData.setTimeStamp(ZonedDateTime.now());
////                        responseData.setData(null);
////                        return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
////                    }
//
//                TransactionDrCr transactionDrCr = new TransactionDrCr();
//                transactionDrCr.setAccountnumber(virtualAccountModel.get().getVirtual_account_number());
//                transactionDrCr.setIsccode("2");
//                transactionDrCr.setAccountstatus("active");
//                transactionDrCr.setUpdatedToCba(false);
//                transactionDrCr.setTerminalId(request.getTerminalId());
//                transactionDrCr.setAcctname(virtualAccountModel.get().getAccount_name());
//                transactionDrCr.setDrcr("cr");
//                transactionDrCr.setTransaction_business_platform_id("");
//                transactionDrCr.setAcctype("savings");
//                transactionDrCr.setAmount(transactionRequestSchema.getAmount());
//                transactionDrCr.setTransactionreference(helpers.generateTransactId(request.getTerminalId(), transactionRequestSchema.getTransactionReference()));
//                transactionDrCr.setNarration(transactionRequestSchema.getNarration());
//                transactionDrCr.setPosRef(transactionRequestSchema.getTransactionReference());
//                transactionDrCr.setChannel("1");
//                transactionDrCr.setResponseCode(request.getResponseCode());
//                transactionDrCr.setEid("");
//                transactionDrCr.setType("transaction");
//                transactionDrCr.setParent_id("");
//                transactionDrCr.setCbaMessage("");
//                transactionDrCr.setResourceId(responseSchema.getResourceId());
//                transactionDrCr.setTransaction_platform_id(request.getTransactionPlatform());
//                transactionDrCr.setCardScheme(request.getCardScheme());
//                transactionDrCr.setCreated_at(LocalDateTime.now().toString());
//                transactionDrCr.setUpdated_at(LocalDateTime.now().toString());
//                cbaTransactionRequests.save(transactionDrCr);
//
//                responseData.setMessage("success");
//                responseData.setStatus(200);
//                responseData.setTimeStamp(ZonedDateTime.now());
//                responseData.setData(transactionDrCr);
//                return new ResponseEntity<>(responseData, HttpStatus.OK);
//            }
//        }
//
////        } catch (Exception e) {
////            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
////            log.error("error from debit credit1 =: {}", e.getMessage());
////            responseData.setMessage(e.getMessage());
////            responseData.setStatus(500);
////            responseData.setTimeStamp(ZonedDateTime.now());
////            responseData.setData(null);
////            return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////        return responseData;
//        return new ResponseEntity<>(responseData, HttpStatus.OK);
//    }

    @PostMapping("/transaction")
    public DeferredResult<ResponseEntity<ResponseSchema<?>>> creditDebitAcct(@RequestHeader("auth_token") String authToken, @Valid @RequestBody String data) {
        System.out.println("data = " + data);
        System.out.println("authToken " + authToken);
        ResponseSchema responseData = new ResponseSchema<>();
        ObjectMapper mapper = new ObjectMapper();

        boolean checkIfTokenIsValid = helpers.isAuthTokenValid(authToken, data);
        CorepayPosTransactionRequest request = null;
        try {
            request = mapper.readValue(data, CorepayPosTransactionRequest.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("request = " + request);
        request.setDateFormat("dd MMMM yyyy");
        request.setStatus("pending");
        request.setLocale("en");
        System.out.println("got here 112233");

        CorepayPosTransactionRequest decryptedData = helpers.decryptObject("RwhmDwxsYVAQ4EhbBP7D+AF5xB39+j65KdEL6kTLhxsujaz7n82YxkXW7JBJml0iWJ7DCugHF5jtUu5IBol7zZFaGPWNyDx96EpKCwTPVbmbnCUjA9IyrMH0Aw+EnNmkdyhHgPGhIOdV8/xZplJpoc0AZrJLcHWKmn/dzHfTGaOsLvBRPciEllbM8rcWsbcaX7f0aYqR6quZnpW2nmcsz9b7U+xMxdsIHtZcbvLu3lXPCQGG1NZzXAIpXYvTKsUuAY+X4Mr4Hn5KMSAialC2D25uw2l91/lXNbsgdVbxhjJBSc5K5uVSPV1A0DHbrnuXHbh3D+JGI1TJ0zUe5yIz8bJLKzYVEcO5rmByeSn9GzBI+jbli6qFyPHNzWYUhWoZApkIDwhOgNIzr9vvnwbko5VSM16EADfun0YqXjYNhes80rDYxRZxnkxiXyTTVzDRHbh3D+JGI1TJ0zUe5yIz8brro83vwhK2o96PSxVWn0GScjZTt62rzwm9IPXhGz6qodqzuTmZWa6u+TOAzvAjj7ahbAiABp6gGkl8Z3qANbwWtOvAdD9k6phdkqyJznCYpxA6/Z7aOC9kHyAvnQJgMgxwrUGMWBKxKvc2c9ysr6IPyVxO5xxCS14Vba4+bqNJA8x09pa6xdAyjuQdTcc3oefveXWsBLh0C0QJt9InKPiTiJU/HZbhehzZT608uZOUq/9QEDL5pPz39qGKgdu/lzKNgs0XG8/c1ASEv2SvL954eDSlrIqvXOlHqNIO7tqsLRNSYqYgWAV5Dvylm1zhPuJQrtt/KY6Jh3sneuosKuRx3PxnXC2zzdiWZSjJ+a/e4TxVOu9GBulMvR7MM6uQbA==", CorepayPosTransactionRequest.class);
        System.out.println("decryptedData = " + decryptedData);

        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());
        if (virtualAccountModel.isEmpty()) {
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "account with Terminal id not found", "account with Terminal id not found");
            responseData.setMessage("account with Terminal id not found");
            responseData.setStatus(404);
            responseData.setTimeStamp(ZonedDateTime.now());
            responseData.setData(null);
            return immediateResult(new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND));
        }

        BalanceResponse balance = debitCreditService.getBalance(virtualAccountModel.get().getVirtual_account_number(), virtualAccountModel.get().getParent_id());

        if (request.isBillsPayment() || request.isTransfer()) {
            boolean isAuthenticated = passwordEncoder.matches(request.getPin(), virtualAccountModel.get().getPin());
            if (!isAuthenticated) {
                responseData.setMessage("Unauthorized");
                responseData.setStatus(401);
                responseData.setTimeStamp(ZonedDateTime.now());
                responseData.setData(null);
                return immediateResult(new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED));
            }
        }

        Optional<PlatformCharges> platformCharges = platformChargeRepository.getChargeByName(request.getTransactionPlatform());
        if (platformCharges.isEmpty()) {
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "transactionPlatform not found", "transactionPlatform not found");
            responseData.setMessage("transactionPlatform not found");
            responseData.setStatus(404);
            responseData.setTimeStamp(ZonedDateTime.now());
            responseData.setData(null);
            return immediateResult(new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND));
        }

        TransactionRequestSchema transactionRequestSchema = new TransactionRequestSchema();
        transactionRequestSchema.setPan(request.getPan());
        transactionRequestSchema.setResponseCode(request.getResponseCode());
        transactionRequestSchema.setPtad(request.getPtad());
        transactionRequestSchema.setReference(request.getReference());
        transactionRequestSchema.setTransactionReference(request.getTransactionReference());
        transactionRequestSchema.setAmount(request.getAmount());
        transactionRequestSchema.setTransactionDate(request.getTransactionDate());
        transactionRequestSchema.setTransactionType(request.getTransactionType());
        transactionRequestSchema.setDateFormat("dd MMMM yyyy");
        transactionRequestSchema.setStatus("pending");
        transactionRequestSchema.setNarration("credit user");
        transactionRequestSchema.setTerminalId(request.getTerminalId());
        transactionRequestSchema.setPaymentTypeId(request.getPaymentTypeId());
        transactionRequestSchema.setMerchantId(request.getMerchantId());
        transactionRequestSchema.setLocale("en");
        transactionRequestSchema.setSerialNo(request.getSerialNo());
        transactionRequestSchema.setStan(request.getStan());
        transactionRequestSchema.setMerchantName(request.getMerchantName());
        transactionRequestSchema.setReversal(request.getReversal());
        transactionRequestSchema.setMerchantCode(request.getMerchantCode());
        transactionRequestSchema.setAuthCode(request.getAuthCode());
        transactionRequestSchema.setRetrievalReferencenumber(request.getRetrievalReferenceNumber());
        transactionRequestSchema.setProcessingFee(request.getProcessingFee());
        transactionRequestSchema.setTransactionFee(request.getTransactionFee());
        transactionRequestSchema.setCardExpiry(request.getCardExpiry());
        transactionRequestSchema.setCardScheme(request.getCardScheme());
        transactionRequestSchema.setCreated_at(ZonedDateTime.now().toString());
        transactionRequestSchema.setUpdated_at(ZonedDateTime.now().toString());
        posTransactionRepository.save(transactionRequestSchema);

        if (request.isBillsPayment()) {
            System.out.println("started here in " + time());
            DeferredResult<ResponseEntity<ResponseSchema<?>>> deferredResult =
                    new DeferredResult<>(60_000L, () -> {
                        ResponseSchema<?> timeoutResponse = new ResponseSchema<>(
                                504, "Payment query timed out", null, "", ZonedDateTime.now(), true
                        );
                        return new ResponseEntity<>(timeoutResponse, HttpStatus.GATEWAY_TIMEOUT);
                    });
            try {
                double amount = Double.parseDouble(request.getMakePayment().getAmount());
                if (balance.getEffectiveBalance() - amount < 0) {
                    ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "Insufficient balance", null, "", ZonedDateTime.now(), true);
                    deferredResult.setResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
                    return deferredResult;
                }
                double charge = 100;
                BillType billType = BillType.BILLS;
                if (request.getMakePayment().getBillType().equals("AIRTIME_DATA")) {
                    String number = helpers.normalizePhoneNumber(request.getMakePayment().getCustomerId());
                    request.getMakePayment().setCustomerId(number);
                    charge = 0;
                    billType = BillType.AIRTIME_DATA;
                }
                request.getMakePayment().setRequestReference("2103" + (System.currentTimeMillis() / 100));
                request.getMakePayment().setAmount(String.valueOf(amount));
                System.out.println("request = " + request.getMakePayment());

                BillsPaymentData billsPaymentData = new BillsPaymentData();
                billsPaymentData.setPaymentCode(request.getMakePayment().getPaymentCode());
                billsPaymentData.setCustomerId(request.getMakePayment().getCustomerId());
                billsPaymentData.setEmail(request.getMakePayment().getEmail());
                billsPaymentData.setMobile(request.getMakePayment().getMobile());
                billsPaymentData.setAmount(request.getMakePayment().getAmount());
                billsPaymentData.setCustomerAccountNumber(request.getMakePayment().getCustomerAccountNumber());
                billsPaymentData.setBillType(request.getMakePayment().getBillType());
                billsPaymentData.setRequestReference(request.getMakePayment().getRequestReference());
                billsPaymentDataRepository.save(billsPaymentData);


                System.out.println("got here in " + time());
                // Step 1: Call makePayment
                MakePaymentApiResponse makePaymentResponse =
                        billsService.makePayment(request.getMakePayment(), charge, billType);
                log.info("makePayment completed for reference: {}", request.getMakePayment().getRequestReference());

                System.out.println("makePaymentResponse = " + makePaymentResponse);
                processPaymentAndQuery(
                        makePaymentResponse, billsPaymentData, request.getMakePayment().getRequestReference(), billType, deferredResult
                );
            } catch (Exception e) {
                ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), null, "", ZonedDateTime.now(), true);
                deferredResult.setResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
            }
            return deferredResult;

        } else if (request.isTransfer()) {
            try {
                double amount = request.getAmount() + 20;
                if (balance.getEffectiveBalance() - amount < 0) {
                    ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "Insufficient balance", null, "", ZonedDateTime.now(), true);
                    return immediateResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
                }
                Optional<NameEnquiryResponseModel> enquiryResponseModel = nameEnquiryResponseRepository.getNameEnquiryById(request.getNameEnquirySessionID());
                if (enquiryResponseModel.isEmpty()) {
                    return immediateResult(new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND));
                }
                if (enquiryResponseModel.get().getDestinationInstitutionCode().equalsIgnoreCase("090329")) {
                    System.out.println("ggggggg");
                    IntraTransfer intraTransfer = IntraTransfer.builder()
                            .customerId(virtualAccountModel.get().getParent_id())
                            .mobilekey("")
                            .fromaccount(virtualAccountModel.get().getVirtual_account_number())
                            .fromacctname(virtualAccountModel.get().getAccount_name())
                            .fromaccountstatus("active")
                            .fromaccountemail(virtualAccountModel.get().getEmail())
                            .fromacctype("")
                            .toaccount(enquiryResponseModel.get().getAccountNumber())
                            .toacctname(enquiryResponseModel.get().getAccountName())
                            .toacctype("savings")
                            .amount(request.getAmount())
                            .tokenType("")
                            .transactionreference("intra_" + request.getNameEnquirySessionID())
                            .narration(request.getNarration())
                            .build();
                    System.out.println("intraTransfer = " + intraTransfer);
                    IntraTransferResponseData response = transactionService.intraTransfer(intraTransfer);
                    System.out.println("response 22 = " + response);
                    if (response.getResponsecode().equals("401")) {
                        ResponseSchema<?> responseSchema = new ResponseSchema<>(401, response.getResponsemessage(), "", "", ZonedDateTime.now(), false);
                        return immediateResult(new ResponseEntity<>(responseSchema, HttpStatus.UNAUTHORIZED));
                    }
                    responseData.setMessage(response.getResponsemessage());
                    responseData.setStatus(Integer.parseInt(response.getResponsecode()));
                    responseData.setTimeStamp(ZonedDateTime.now());
                    responseData.setData(response);
                    return immediateResult(new ResponseEntity<>(responseData, HttpStatus.OK));
                }
                EasypayTransactionsModel transactionsModel = new EasypayTransactionsModel();
                transactionsModel.setPaymentReference("inter_" + request.getNameEnquirySessionID());
                transactionsModel.setBeneficiaryAccountName(enquiryResponseModel.get().getAccountName());
                transactionsModel.setBeneficiaryAccountNumber(enquiryResponseModel.get().getAccountNumber());
                transactionsModel.setBeneficiaryBankVerificationNumber(enquiryResponseModel.get().getBankVerificationNumber());
                transactionsModel.setBeneficiaryKYCLevel(String.valueOf(enquiryResponseModel.get().getKycLevel()));
                transactionsModel.setOriginatorAccountName(virtualAccountModel.get().getAccount_name());
                transactionsModel.setDestinationInstitutionCode(enquiryResponseModel.get().getDestinationInstitutionCode());
                transactionsModel.setOriginatorAccountNumber(virtualAccountModel.get().getVirtual_account_number());
                transactionsModel.setOriginatorBankVerificationNumber(virtualAccountModel.get().getBvn());
                transactionsModel.setOriginatorKYCLevel(1);
                transactionsModel.setNameEnquiryRef(enquiryResponseModel.get().getRef());
                transactionsModel.setOriginatorNarration(request.getNarration());
                transactionsModel.setTransactionLocation(request.getTransactionLocation());
                transactionsModel.setCustomerAccountName(virtualAccountModel.get().getAccount_name());
                transactionsModel.setCustomerAccountNumber(virtualAccountModel.get().getVirtual_account_number());
                transactionsModel.setAmount(request.getAmount());
                transactionsModel.setCharge(20);
                easypayTransactionsRepository.save(transactionsModel);
                EasyPayResponse response = easypay.transferOutward(transactionsModel);
                System.out.println("response = " + response);
                if (response == null) {
                    errorLoggingException.logError("EASY_PAY_RESPONSE_NULL", "Response from outward transfer returned null", "Response from outward transfer returned null");
                    EasypayResponseData easypayResponseData = new EasypayResponseData();
                    easypayResponseData.setCode("500");
                    easypayResponseData.setMessage("insufficient funds");
                    ResponseSchema<?> responseSchema = new ResponseSchema<>(500, "insufficient funds", easypayResponseData, "", ZonedDateTime.now(), false);
                    return immediateResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
                }
                System.out.println("response 112 = " + response.getCode());
                transactionsModel.setMessage(response.getMessage());
                transactionsModel.setCode(response.getCode());
                easypayTransactionsRepository.save(transactionsModel);
                System.out.println("response = " + response);
                EasypayResponseData easypayResponseData = new EasypayResponseData();
                easypayResponseData.setCode(response.getCode());
                easypayResponseData.setMessage(response.getMessage());
                ResponseSchema<?> responseSchema = new ResponseSchema<>(200, response.getMessage(), easypayResponseData, "", ZonedDateTime.now(), false);
                return immediateResult(new ResponseEntity<>(responseSchema, HttpStatus.OK));

            } catch (Exception e) {
                ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), e, "", ZonedDateTime.now(), false);
                return immediateResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
            }

        } else {
            UpdateTransactionResponseSchema responseSchema = helpers.registerTransactionToTMS(request, platformCharges);
            System.out.println("responseSchema = " + responseSchema);
            if (responseSchema.getResourceId() != null && request.getResponseCode().equals("00")) {
                System.out.println("================================ " + virtualAccountModel.get().getVirtual_account_number());
                TransactionDrCr transactionDrCr = new TransactionDrCr();
                transactionDrCr.setAccountnumber(virtualAccountModel.get().getVirtual_account_number());
                transactionDrCr.setIsccode("2");
                transactionDrCr.setAccountstatus("active");
                transactionDrCr.setUpdatedToCba(false);
                transactionDrCr.setTerminalId(request.getTerminalId());
                transactionDrCr.setAcctname(virtualAccountModel.get().getAccount_name());
                transactionDrCr.setDrcr("cr");
                transactionDrCr.setTransaction_business_platform_id("");
                transactionDrCr.setAcctype("savings");
                transactionDrCr.setAmount(transactionRequestSchema.getAmount());
                transactionDrCr.setTransactionreference(helpers.generateTransactId(request.getTerminalId(), transactionRequestSchema.getTransactionReference()));
                transactionDrCr.setNarration(transactionRequestSchema.getNarration());
                transactionDrCr.setPosRef(transactionRequestSchema.getTransactionReference());
                transactionDrCr.setChannel("1");
                transactionDrCr.setResponseCode(request.getResponseCode());
                transactionDrCr.setEid("");
                transactionDrCr.setType("transaction");
                transactionDrCr.setParent_id("");
                transactionDrCr.setCbaMessage("");
                transactionDrCr.setResourceId(responseSchema.getResourceId());
                transactionDrCr.setTransaction_platform_id(request.getTransactionPlatform());
                transactionDrCr.setCardScheme(request.getCardScheme());
                transactionDrCr.setCreated_at(LocalDateTime.now().toString());
                transactionDrCr.setUpdated_at(LocalDateTime.now().toString());
                cbaTransactionRequests.save(transactionDrCr);
                responseData.setMessage("success");
                responseData.setStatus(200);
                responseData.setTimeStamp(ZonedDateTime.now());
                responseData.setData(transactionDrCr);
                return immediateResult(new ResponseEntity<>(responseData, HttpStatus.OK));
            }
        }

        return immediateResult(new ResponseEntity<>(responseData, HttpStatus.OK));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-balance")
    public ResponseEntity<ResponseSchema<?>> getBalance(@RequestParam String accountNum, @RequestParam String type) {
        try {
            Optional<VirtualAccountModel> virtualAccountModel;
            if (type.equalsIgnoreCase("virtual_account")) {
                virtualAccountModel = virtualAccountRepository.getCustomersWithAccountId(accountNum);
            } else if (type.equalsIgnoreCase("business_account")) {
                virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByBusinessAccount(accountNum);
            } else {
                virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByParentAccount(accountNum);
            }

            if (virtualAccountModel.isEmpty()) {
                ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "account not found", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
            }

            BalanceResponse response = debitCreditService.getBalance(accountNum, virtualAccountModel.get().getParent_id());

            System.out.println("response = " + response);
            com.neptune.cbawrapper.RequestRessponseSchema.BalanceResponse balanceResponse = new com.neptune.cbawrapper.RequestRessponseSchema.BalanceResponse();

            if (response != null) {
                balanceResponse.setEffective_balance(response.getEffectiveBalance());
                balanceResponse.setLedger_balance(response.getLedgerBalance());
                balanceResponse.setLast_credit_amount(response.getLastCreditAmount());
                balanceResponse.setLast_debit_amount(response.getLastDebitAmount());
                balanceResponse.setLast_debit_date(response.getLastDebitDate());
                balanceResponse.setLast_credit_date(response.getLastCreditDate());
                balanceResponse.setHold_bal(response.getHoldBal());
                balanceResponse.setAccured_interest(response.getAccuredInterest());
                balanceResponse.setLedger_balance(response.getLedgerBalance());
                balanceResponse.setAccured_interest_overdrawn(response.getAccuredInterestOverdrawn());
                balanceResponse.setLate_fess(response.getLateFess());
                balanceResponse.setAccount_number(response.getAccountNumber());
            }

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "balance request successful", balanceResponse, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        } catch (Exception e) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @Validated
    @GetMapping("/get-transaction-history")
    public ResponseEntity<ResponseSchema<?>> getTransactionHistory(@RequestParam String accountNum, @RequestParam String narration, @RequestParam String start_date, @RequestParam String end_date, @RequestParam int page, @RequestParam int size) {
        HistoryResponse response = historyService.getAcctHistory(accountNum, start_date, narration, end_date, page, size);

        System.out.println("response = " + response);

        if (response == null) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "No transaction found for account number", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        HistoryBuilder historyBuilder = new HistoryBuilder();
        TransactionHistoryBuilder builder = new TransactionHistoryBuilder();
        List<TransactionHistory> transactionHistoryList = new ArrayList<>();
        for (int i = 0; i < response.getHistoryList().size(); i++) {
            builder
                    .setValuedate(response.getHistory(i).getValuedate())
                    .setTrandate(response.getHistory(i).getTrandate())
                    .setTranamount(response.getHistory(i).getTranamount())
                    .setRn(response.getHistory(i).getRn())
                    .setRefno(response.getHistory(i).getRefno())
                    .setNarration(response.getHistory(i).getNarration())
                    .setIdno(response.getHistory(i).getIdno())
                    .setBkbalance(response.getHistory(i).getBkbalance())
                    .setBankname(response.getHistory(i).getBankname())
                    .setAccountnumber(response.getHistory(i).getAccountnumber())
                    .setStatus(response.getHistory(i).getStatus())
                    .setTransactionType(response.getHistory(i).getTransactionType())
                    .setSession_id(response.getHistory(i).getSessionId());
            transactionHistoryList.add(builder.build());
        }
        historyBuilder
                .setTotalPages(response.getTotalPages())
                .setTotalItems(response.getTotalItems())
                .setCurrentPages(response.getCurrentPages())
                .setHistory(transactionHistoryList);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "balance request successful", historyBuilder.build(), "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @Validated
    @PostMapping("/generate-statement")
    public ResponseEntity<ResponseSchema<?>> generateStatement(@Valid @RequestBody GenerateStatementRequest request) {
        Optional<VirtualAccountModel> accountModel = virtualAccountRepository.getVirtualAccountModelByAccount(request.getAcctNo());
        if (accountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "Account not found", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }
        Optional<CustomersModel> customersModel = helpers.getCustomerBySavingsId(accountModel.get().getBusinessSavingsId());

        if (customersModel.isEmpty()) {
            return null;
        }

        PrintableOuterClass.StatementOfAccountResponse res = printable.generateState(request, accountModel.get().getEmail(), accountModel.get().getAccount_name());

        System.out.println("res = " + res);

        if (res != null) {
            SendNotifications notifications1 = SendNotifications.builder()
                    .title("Statement Of Account")
                    .file(res.getPdf())
                    .receiver_email(accountModel.get().getEmail())
                    .sendmail(true)
                    .attachment(true)
                    .build();
            notification_service.Notifications.NotificationResponse response = notifications.sendNotification(notifications1);
            System.out.println("NotificationResponse = " + response);

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "Statement of account sent to your email", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "Error occured, kindly try again later", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @Async("billsPaymentExecutor")
    public void processPaymentAndQuery(
            MakePaymentApiResponse makePaymentResponse,
            BillsPaymentData billsPaymentData,
            String requestReference,
            BillType billType,
            DeferredResult<ResponseEntity<ResponseSchema<?>>> deferredResult) {

        try {
            System.out.println("got here in 1112233 in " + time());

            // Step 2: Save initial makePayment response
            billsPaymentData.setResponse(makePaymentResponse);
            billsPaymentData.setBillsAdditionalData(makePaymentResponse.getBillsAdditionalData());
            billsPaymentDataRepository.save(billsPaymentData);

            // Step 3: Wait 60 seconds (on bills-payment thread, NOT the request thread)
            log.info("Waiting 60 seconds before calling queryBills...");
//            Thread.sleep(60_000);
            System.out.println("got here in 222 in " + time());

            // Step 4: Call queryBills
            TransactionStatusResponse queryBillsResponse = historyService.getTransactionDetails(TransactionCategory.BILL_PAYMENT, requestReference);
            BillsAdditionalData billsAdditionalData = null;
            if (Optional.ofNullable(queryBillsResponse)
                    .map(TransactionStatusResponse::getAdditionalInfo)
                    .filter(info -> !info.isEmpty())
                    .isPresent()) {
                System.out.println("data112 = " + queryBillsResponse.getAdditionalInfo());
                billsAdditionalData = objectMapper.readValue(queryBillsResponse.getAdditionalInfo(), BillsAdditionalData.class);
            }
            log.info("queryBills completed for reference: {}", requestReference);
            System.out.println("queryBillsResponse = " + queryBillsResponse);
            System.out.println("billsAdditionalData = " + billsAdditionalData);

//            if(billsAdditionalData == null){
//                billsAdditionalData = objectMapper.readValue(queryBillsResponse.getAdditionalInfo(), BillsAdditionalData.class);
//            }
            BillsTsqResponseData billsTsqResponseData = new BillsTsqResponseData();
            billsTsqResponseData.setCode(queryBillsResponse.getCode());
            billsPaymentData.setBillsAdditionalData(billsAdditionalData);
            billsTsqResponseData.setMessage(queryBillsResponse.getMessage());

            // Step 5: Update record with final response
            billsPaymentData.setResponse(queryBillsResponse);
            billsPaymentData.setBillsAdditionalData(billsAdditionalData);
            billsPaymentDataRepository.save(billsPaymentData);

            // Step 6: Write response back to the waiting HTTP client
            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "successful", billsAdditionalData, "", ZonedDateTime.now(), true);
            deferredResult.setResult(new ResponseEntity<>(responseSchema, HttpStatus.OK));

        } catch (Exception e) {
            log.error("Error processing bills payment", e);
            ResponseSchema<?> responseSchema = new ResponseSchema<>(500, e.getMessage(), null, "", ZonedDateTime.now(), true);
            deferredResult.setResult(new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    private DeferredResult<ResponseEntity<ResponseSchema<?>>> immediateResult(ResponseEntity<ResponseSchema<?>> response) {
        DeferredResult<ResponseEntity<ResponseSchema<?>>> result = new DeferredResult<>();
        result.setResult(response);
        return result;
    }

    private String time(){
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        System.out.println(formattedTime);
        return formattedTime;
    }
}
