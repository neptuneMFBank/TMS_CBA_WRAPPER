package com.neptune.cbawrapper.Controllers;

import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.TransactionDrCr;
import com.neptune.cbawrapper.Models.Transactions;
import com.neptune.cbawrapper.Models.VerifyUser;
import com.neptune.cbawrapper.Models.VirtualAccountModel;
import com.neptune.cbawrapper.Repository.CbaTransactionRequestsRepository;
import com.neptune.cbawrapper.Repository.PosTransactionRepository;
import com.neptune.cbawrapper.Repository.TransactionsRepository;
import com.neptune.cbawrapper.Repository.VirtualAccountRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.Notifications;
import com.neptune.cbawrapper.Services.TransactionCoreController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pos")
public class TransactionController {


    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionsRepository transactionsRepository;
    private final TransactionCoreController transactionCoreController;
    private final VirtualAccountRepository virtualAccountRepository;
    private final CbaTransactionRequestsRepository cbaTransactionRequests;
    private final ErrorLoggingException errorLoggingException;
    private final Notifications notifications;
    private final PosTransactionRepository posTransactionRepository;
    private final Helpers helpers;


    public TransactionController(TransactionsRepository transactionsRepository, TransactionCoreController transactionCoreController, VirtualAccountRepository virtualAccountRepository, CbaTransactionRequestsRepository cbaTransactionRequests, ErrorLoggingException errorLoggingException, Notifications notifications, PosTransactionRepository posTransactionRepository, Helpers helpers) {
        this.transactionsRepository = transactionsRepository;
        this.transactionCoreController = transactionCoreController;
        this.virtualAccountRepository = virtualAccountRepository;
        this.cbaTransactionRequests = cbaTransactionRequests;
        this.errorLoggingException = errorLoggingException;
        this.notifications = notifications;
        this.posTransactionRepository = posTransactionRepository;
        this.helpers = helpers;
    }

    //todo: transactions notifications from CBA
    @PutMapping("/update-terminal-fcm-token")
    public ResponseEntity<ResponseSchema<?>> updateTerminalFcmToken(@RequestBody FcmRequest request) {
        try {
            Optional<VirtualAccountModel> getVirtualAccount = virtualAccountRepository.getVirtualAccountModelByAccount(request.getAccountId());

            if(getVirtualAccount.isPresent()) {
                VirtualAccountModel virtualAccountModel = getVirtualAccount.get();
                virtualAccountModel.setFcmToken(request.getFcmToken());
                virtualAccountRepository.save(virtualAccountModel);
                ResponseSchema<?> responseSchema = new ResponseSchema<>( 200, "fcm token added successfully", null, "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.OK);
            }
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 409, "Error occurred please try again later", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.CONFLICT);
        }catch (Exception e) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //TODO: CBA transaction notification webhook
    @PostMapping("/pos-credit-webhook")
    public ResponseEntity<ResponseSchema<?>> getCreditUpdate(VerifyUser verifyUser) {
        try {
            Optional<Transactions> checkIfTransactionWithRefExists = transactionsRepository.checkIfTransactionWithRefExists(verifyUser.getRef());

            Transactions transactions;
            if (checkIfTransactionWithRefExists.isEmpty()) {
                transactions = new Transactions();
                transactions.setEvent(verifyUser.getEvent());
                transactions.setMessage(verifyUser.getMessage());
                transactions.setStatus("Pending");
                transactions.setAccount(verifyUser.getAccount());
                transactions.setRef(verifyUser.getRef());
            } else {
                transactions = checkIfTransactionWithRefExists.get();
                transactions.setAmount(verifyUser.getAmount());
                transactions.setEvent(verifyUser.getEvent());
            }
            transactionsRepository.save(transactions);
            String event;
            int status_code;

            if (verifyUser.getEvent().equalsIgnoreCase("transaction.init")) {
                event = "Transaction initialized";
                status_code = 201;
            } else if ((verifyUser.getEvent().equalsIgnoreCase("transaction.successful"))) {
                event = "Transaction successful";
                status_code = 200;
            } else if (verifyUser.getEvent().equalsIgnoreCase("transaction.failed")) {
                event = "Transaction failed";
                status_code = 500;
            } else {
                event = "Unknown event occured";
                status_code = 500;
            }

            Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByAccount(verifyUser.getAccount());
            if(virtualAccountModel.isPresent()) {
                SendNotifications notifications1 = new SendNotifications();
                notifications1.setMessage("Transaction received");
                notifications1.setTitle("Transactions Notifications");
                notifications1.setReceiverFcmToken(virtualAccountModel.get().getFcmToken());
                notifications.sendNotification(notifications1);
            }

            ResponseSchema<?> responseSchema = new ResponseSchema<>( status_code, event, null, "", ZonedDateTime.now(), false);
            if(status_code == 200) {
                return new ResponseEntity<>(responseSchema, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from debit credit1 =: {}", e.getMessage());
            ResponseSchema<?> responseSchema = new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/transaction")
    public ResponseEntity<ResponseSchema<?>> creditDebitAcct(@RequestHeader("auth_token") String authToken, @RequestBody CorepayPosTransactionRequest request) {
        ResponseSchema responseData = new ResponseSchema<>();
        try {

//        request.setDateFormat("dd MMMM yyyy");
//        request.setStatus("pending");
//        request.setNarration("credit user");
//        request.setLocale("en");
        System.out.println("request = " + request);

        boolean checkIfTokenIsValid = helpers.isAuthTokenValid(authToken, request);

        CorepayPosTransactionRequest decryptedData = helpers.decryptObject(authToken, CorepayPosTransactionRequest.class);

        System.out.println("decryptedData = " + decryptedData);

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
        transactionRequestSchema.setTransactionPlatform(request.getTransactionPlatform());
        transactionRequestSchema.setPaymentTypeId(request.getPaymentTypeId());
        transactionRequestSchema.setMerchantId(request.getMerchantId());
        transactionRequestSchema.setLocale("en");
        transactionRequestSchema.setSerialNo(request.getSerialNo());
        transactionRequestSchema.setStan(request.getStan());
        transactionRequestSchema.setMerchantName(request.getMerchantName());
        transactionRequestSchema.setReversal(request.getReversal());
        transactionRequestSchema.setMerchantCode(request.getMerchantCode());
        transactionRequestSchema.setAuthCode(request.getAuthCode());
        transactionRequestSchema.setRetrievalReferencenumber(request.getRetrievalReferencenumber());
        transactionRequestSchema.setProcessingFee(request.getProcessingFee());
        transactionRequestSchema.setTransactionFee(request.getTransactionFee());
        transactionRequestSchema.setCardExpiry(request.getCardExpiry());
        posTransactionRepository.save(transactionRequestSchema);


        UpdateTransactionResponseSchema responseSchema = transactionCoreController.createTransaction(request);

        System.out.println("responseSchema = " + responseSchema.getResourceId());

        if (status.equals("SUCCESS")) {

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
            transactionDrCr.setTransactionreference(transactionRequestSchema.getTransactionReference());
            transactionDrCr.setNarration(transactionRequestSchema.getNarration());
            transactionDrCr.setChannel("1");
            transactionDrCr.setEid("");
            transactionDrCr.setResourceId(responseSchema.getResourceId());
            transactionDrCr.setTransaction_platform_id(String.valueOf(transactionRequestSchema.getTransactionPlatform()));
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

}
