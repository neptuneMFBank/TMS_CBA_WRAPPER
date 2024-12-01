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
import com.neptune.cbawrapper.RequestRessponseSchema.CorepayPosTransactionRequest;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import com.neptune.cbawrapper.RequestRessponseSchema.TransactionRequestSchema;
import com.neptune.cbawrapper.RequestRessponseSchema.UpdateTransactionResponseSchema;
import com.neptune.cbawrapper.Services.TransactionCoreController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final PosTransactionRepository posTransactionRepository;
    private final Helpers helpers;


    public TransactionController(TransactionsRepository transactionsRepository, TransactionCoreController transactionCoreController, VirtualAccountRepository virtualAccountRepository, CbaTransactionRequestsRepository cbaTransactionRequests, ErrorLoggingException errorLoggingException, PosTransactionRepository posTransactionRepository, Helpers helpers) {
        this.transactionsRepository = transactionsRepository;
        this.transactionCoreController = transactionCoreController;
        this.virtualAccountRepository = virtualAccountRepository;
        this.cbaTransactionRequests = cbaTransactionRequests;
        this.errorLoggingException = errorLoggingException;
        this.posTransactionRepository = posTransactionRepository;
        this.helpers = helpers;
    }

    //todo: transactions notifications from CBA
    @GetMapping("/pending-transactions-notification")
    public ResponseSchema<List<Transactions>> posTransactionNotification() {
        ResponseSchema<List<Transactions>> response = new ResponseSchema<>();
        try {
            List<Transactions> checkTransactionStatus = transactionsRepository.checkTransactionStatus("pending");

            if (checkTransactionStatus.isEmpty()) {
                response.setData(null);
                response.setMessage("Transaction not found");
                response.setTimeStamp(ZonedDateTime.now());
                response.setEnc(false);
                response.setStatus(404);
                return response;
            }

            for (Transactions t : checkTransactionStatus) {
                t.setStatus("approved");
                transactionsRepository.save(t); // int status, String message, T data, String uri, ZonedDateTime timeStamp, boolean enc
            }
            response = new ResponseSchema<>( 200, "success", checkTransactionStatus, "", ZonedDateTime.now(), false);

        } catch (Exception e) {
            System.out.println("hello world");
        }
        return response;
    }

    //TODO: CBA transaction notification webhook
    @PostMapping("/pos-credit-webhook")
    public ResponseSchema getCreditUpdate(VerifyUser verifyUser) {
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

            return new ResponseSchema<>( status_code, event, null, "", ZonedDateTime.now(), false);
        } catch (Exception e) {
            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
            log.error("error from debit credit1 =: {}", e.getMessage());
            return new ResponseSchema<>( 500, e.getMessage(), null, "", ZonedDateTime.now(), false);
        }
    }

    @PostMapping("/transaction")
    public ResponseSchema creditDebitAcct(@RequestHeader("auth_token") String authToken, @RequestBody CorepayPosTransactionRequest request) {
        ResponseSchema responseData = new ResponseSchema<>();
//        try {

        request.setDateFormat("dd MMMM yyyy");
        request.setStatus("pending");
        request.setNarration("credit user");
        request.setLocale("en");
        System.out.println("request = " + request);

        boolean checkIfTokenIsValid = helpers.isAuthTokenValid(authToken, request);

        if (!checkIfTokenIsValid) {
            responseData.setData(null);
            responseData.setMessage("Invalid auth token");
            responseData.setTimeStamp(ZonedDateTime.now());
            responseData.setEnc(false);
            responseData.setStatus(404);
            return responseData;
        }

        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountByTerminalId(request.getTerminalId());

        if (virtualAccountModel.isEmpty()) {
            responseData.setMessage("account with Terminal id not found");
            responseData.setStatus(502);
            responseData.setTimeStamp(ZonedDateTime.now());
            responseData.setData(null);
            return responseData;
        }

        String status = "";

        if (request.getResponseCode().equals("00")) {
            status = "SUCCESS";
        }

        TransactionRequestSchema transactionRequestSchema = new TransactionRequestSchema();
        transactionRequestSchema.setPan(transactionRequestSchema.getPan());
        transactionRequestSchema.setResponseCode(transactionRequestSchema.getResponseCode());
        transactionRequestSchema.setPtad(transactionRequestSchema.getPtad());
        transactionRequestSchema.setReference(transactionRequestSchema.getReference());
        transactionRequestSchema.setTransactionReference(transactionRequestSchema.getTransactionReference());
        transactionRequestSchema.setAmount(transactionRequestSchema.getAmount());
        transactionRequestSchema.setTransactionDate(transactionRequestSchema.getTransactionDate());
        transactionRequestSchema.setTransactionType(transactionRequestSchema.getTransactionType());
        transactionRequestSchema.setDateFormat("dd MMMM yyyy");
        transactionRequestSchema.setStatus("pending");
        transactionRequestSchema.setNarration("credit user");
        transactionRequestSchema.setTerminalId(transactionRequestSchema.getTerminalId());
        transactionRequestSchema.setTransactionPlatform(transactionRequestSchema.getTransactionPlatform());
        transactionRequestSchema.setPaymentTypeId(transactionRequestSchema.getPaymentTypeId());
        transactionRequestSchema.setMerchantId(transactionRequestSchema.getMerchantId());
        transactionRequestSchema.setLocale("en");
        transactionRequestSchema.setSerialNo(transactionRequestSchema.getSerialNo());
        transactionRequestSchema.setStan(transactionRequestSchema.getStan());
        transactionRequestSchema.setMerchantName(transactionRequestSchema.getMerchantName());
        transactionRequestSchema.setReversal(transactionRequestSchema.getReversal());
        transactionRequestSchema.setMerchantCode(transactionRequestSchema.getMerchantCode());
        transactionRequestSchema.setAuthCode(transactionRequestSchema.getAuthCode());
        transactionRequestSchema.setRetrievalReferencenumber(transactionRequestSchema.getRetrievalReferencenumber());
        transactionRequestSchema.setProcessingFee(transactionRequestSchema.getProcessingFee());
        transactionRequestSchema.setTransactionFee(transactionRequestSchema.getTransactionFee());
        transactionRequestSchema.setCardExpiry(transactionRequestSchema.getCardExpiry());
        posTransactionRepository.save(transactionRequestSchema);


        UpdateTransactionResponseSchema responseSchema = transactionCoreController.createTransaction(request);

        System.out.println("responseSchema = " + responseSchema.getResourceId());

        if (status.equals("SUCCESS")) {

            TransactionDrCr transactionDrCr = new TransactionDrCr();
            transactionDrCr.setAccountnumber(virtualAccountModel.get().getVirtual_account_number());
            transactionDrCr.setIsccode("2");
            transactionDrCr.setAccountstatus("active");
            transactionDrCr.setUpdatedToCba(false);
            transactionDrCr.setAcctname(virtualAccountModel.get().getAccount_name());
            transactionDrCr.setDrcr("cr");
            transactionDrCr.setAcctype("savings");
            transactionDrCr.setAmount(transactionRequestSchema.getAmount());
            transactionDrCr.setTransactionreference(transactionRequestSchema.getTransactionReference());
            transactionDrCr.setNarration(transactionRequestSchema.getNarration());
            transactionDrCr.setChannel("1");
            transactionDrCr.setEid("");
            transactionDrCr.setResourceId(responseSchema.getResourceId());
            transactionDrCr.setTransaction_platform_id(transactionRequestSchema.getTransactionPlatform());
            cbaTransactionRequests.save(transactionDrCr);

            responseData.setMessage("success");
            responseData.setStatus(200);
            responseData.setTimeStamp(ZonedDateTime.now());
            responseData.setData(transactionDrCr);
            return responseData;
        }

//        } catch (Exception e) {
//            errorLoggingException.logError("DEBIT_CREDIT_API_REQUEST_2", String.valueOf(e.getCause()), e.getMessage());
//            log.error("error from debit credit1 =: {}", e.getMessage());
//            responseData.setMessage(e.getMessage());
//            responseData.setStatus(500);
//            responseData.setTimeStamp(ZonedDateTime.now());
//            responseData.setResponseData(null);
//            return responseData;
//        }
        return responseData;
    }

}
