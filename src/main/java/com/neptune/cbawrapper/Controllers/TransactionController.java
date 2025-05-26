package com.neptune.cbawrapper.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neptune.cba.transaction.balance.BalanceResponse;
import com.neptune.cba.transaction.history.HistoryResponse;
import com.neptune.cbawrapper.BuilderPattern.HistoryBuilder;
import com.neptune.cbawrapper.BuilderPattern.TransactionHistoryBuilder;
import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.*;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/v1/pos")
public class TransactionController {


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


    public TransactionController(DebitCreditService debitCreditService, HistoryService historyService, PlatformChargeRepository platformChargeRepository, PushyAPI pushyAPI, TransactionsRepository transactionsRepository, TransactionCoreController transactionCoreController, VirtualAccountRepository virtualAccountRepository, CbaTransactionRequestsRepository cbaTransactionRequests, ErrorLoggingException errorLoggingException, PosTransactionRepository posTransactionRepository, Helpers helpers) {
        this.transactionsRepository = transactionsRepository;
        this.transactionCoreController = transactionCoreController;
        this.virtualAccountRepository = virtualAccountRepository;
        this.cbaTransactionRequests = cbaTransactionRequests;
        this.debitCreditService = debitCreditService;
        this.errorLoggingException = errorLoggingException;
        this.platformChargeRepository = platformChargeRepository;
        this.pushyAPI = pushyAPI;
        this.historyService = historyService;
        this.posTransactionRepository = posTransactionRepository;
        this.helpers = helpers;
    }

    //todo: transactions notifications from CBA
    @PutMapping("/update-terminal-fcm-token")
    public ResponseEntity<ResponseSchema<?>> updateTerminalFcmToken(@RequestBody FcmRequest request) {
        try {
            Optional<VirtualAccountModel> getVirtualAccount = virtualAccountRepository.getVirtualAccountModelByAccount(request.getTerminalId());

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
    @PostMapping("/pos-credit-webhook")
    public ResponseEntity<ResponseSchema<?>> getCreditUpdate(@RequestBody WebHookRequest webHookRequest) {
        try {
            System.out.println("webHookRequest = " + webHookRequest);
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
                payload.put("message", "Hello World!");
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

    @PostMapping("/transaction")
    public ResponseEntity<ResponseSchema<?>> creditDebitAcct(@RequestHeader("auth_token") String authToken, @Valid @RequestBody String data) {
        System.out.println("data = " + data);
        ResponseSchema responseData = new ResponseSchema<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            boolean checkIfTokenIsValid = helpers.isAuthTokenValid(authToken, data);

            CorepayPosTransactionRequest request = mapper.readValue(data, CorepayPosTransactionRequest.class);

            System.out.println("request = " + request);
            request.setDateFormat("dd MMMM yyyy");
            request.setStatus("pending");
            request.setNarration("credit user");
            request.setLocale("en");


//        CorepayPosTransactionRequest decryptedData = helpers.decryptObject(authToken, CorepayPosTransactionRequest.class);

//        System.out.println("decryptedData = " + decryptedData);

//        if (!checkIfTokenIsValid) {
//            responseData.setData(null);
//            responseData.setMessage("Invalid auth token");
////            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
//            responseData.setTimeStamp(ZonedDateTime.now());
//            responseData.setEnc(false);
//            responseData.setStatus(401);
//            return new ResponseEntity<>(responseData, HttpStatus.UNAUTHORIZED);
//        }

            Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

            if (virtualAccountModel.isEmpty()) {
                errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "account with Terminal id not found", "account with Terminal id not found");
                responseData.setMessage("account with Terminal id not found");
                responseData.setStatus(404);
                responseData.setTimeStamp(ZonedDateTime.now());
                responseData.setData(null);
                return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
            }

            String status = "";

            if (request.getResponseCode().equals("00")) {
                status = "SUCCESS";
            }

            System.out.println("platformName = " + request.getTransactionPlatform());
            System.out.println("platformId = " + request.getPaymentTypeId());

            Optional<PlatformCharges> platformCharges = platformChargeRepository.getChargeByNameAndId(request.getTransactionPlatform(), Integer.parseInt(request.getPaymentTypeId()));

            if(platformCharges.isEmpty()){
                errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", "transactionPlatform not found", "transactionPlatform not found");
                responseData.setMessage("transactionPlatform not found");
                responseData.setStatus(404);
                responseData.setTimeStamp(ZonedDateTime.now());
                responseData.setData(null);
                return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);
            }

            TransactionDetails transactionDetails = new TransactionDetails();
            transactionDetails.setTerminalId(request.getTerminalId());
            transactionDetails.setNarration("POS");
            transactionDetails.setStatus("PENDING");
            transactionDetails.setDateFormat("dd MMMM yyyy");
            transactionDetails.setTransactionType(request.getTransactionType());
            transactionDetails.setTransactionDate(request.getTransactionDate());
            transactionDetails.setAmount(request.getAmount());
            transactionDetails.setTransactionReference(request.getTransactionReference());
            transactionDetails.setReference(request.getReference());
            transactionDetails.setPtad(request.getPtad());
            transactionDetails.setTransactionPlatformId(platformCharges.get().getPlatformId());
            transactionDetails.setResponseCode(request.getResponseCode());
            transactionDetails.setPan(request.getPan());
            transactionDetails.setCardExpiry(request.getCardExpiry());
            transactionDetails.setTransactionFee(request.getTransactionFee());
            transactionDetails.setProcessingFee(request.getProcessingFee());
            transactionDetails.setRetrievalReferencenumber(request.getRetrievalReferenceNumber());
            transactionDetails.setAuthCode(request.getAuthCode());
            transactionDetails.setMerchantCode(request.getMerchantCode());
            transactionDetails.setReversal(request.getReversal());
            transactionDetails.setMerchantName(request.getMerchantName());
            transactionDetails.setStan(request.getStan());
            transactionDetails.setSerialNo(request.getSerialNo());
            transactionDetails.setLocale(request.getLocale());
            transactionDetails.setCardScheme(request.getCardScheme());


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
//            transactionRequestSchema.setTransactionPlatformId(platformCharges.get().getId());
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

            System.out.println("request = " + transactionDetails);
            UpdateTransactionResponseSchema responseSchema = transactionCoreController.createTransaction(transactionDetails);

            System.out.println("responseSchema = " + responseSchema.getResourceId());

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
                transactionDrCr.setTransaction_platform_id(String.valueOf(request.getPaymentTypeId()));
                transactionDrCr.setCardScheme(request.getCardScheme());
                transactionDrCr.setCreated_at(LocalDateTime.now().toString());
                transactionDrCr.setUpdated_at(LocalDateTime.now().toString());
                cbaTransactionRequests.save(transactionDrCr);

                responseData.setMessage("success");
                responseData.setStatus(200);
                responseData.setTimeStamp(ZonedDateTime.now());
                responseData.setData(transactionDrCr);
                return new ResponseEntity<>(responseData, HttpStatus.OK);
            }

        } catch (Exception e) {
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from debit credit1 =: {}", e.getMessage());
            responseData.setMessage(e.getMessage());
            responseData.setStatus(500);
            responseData.setTimeStamp(ZonedDateTime.now());
            responseData.setData(null);
            return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return responseData;
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-balance")
    public ResponseEntity<ResponseSchema<?>> getBalance(@RequestParam String accountNum, @RequestParam String type){
        try {
            Optional<VirtualAccountModel> virtualAccountModel;
            if(type.equalsIgnoreCase("virtual_account")){
                virtualAccountModel = virtualAccountRepository.getCustomersWithAccountId(accountNum);
            }else if(type.equalsIgnoreCase("business_account")){
                virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByBusinessAccount(accountNum);
            }else {
                virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByParentAccount(accountNum);
            }

            if(virtualAccountModel.isEmpty()) {
                ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "account not found", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
            }

            BalanceResponse response = debitCreditService.getBalance(accountNum, virtualAccountModel.get().getParent_id());

            System.out.println("response = " + response);
            com.neptune.cbawrapper.RequestRessponseSchema.BalanceResponse balanceResponse = new com.neptune.cbawrapper.RequestRessponseSchema.BalanceResponse();

            if(response != null){
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
    public ResponseEntity<ResponseSchema<?>> getTransactionHistory(@RequestParam String accountNum, @RequestParam String narration, @RequestParam String start_date, @RequestParam String end_date, @RequestParam int page, @RequestParam int size){
        HistoryResponse response = historyService.getAcctHistory(accountNum, start_date, narration, end_date, page, size);

        System.out.println("response = " + response);

        if(response == null){
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
                    .setAccountnumber(response.getHistory(i).getAccountnumber());
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
}
