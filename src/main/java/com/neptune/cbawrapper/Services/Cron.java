package com.neptune.cbawrapper.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neptune.cba.transaction.debit_credit.DebitCreditResponse;
import com.neptune.cba.transaction.debit_credit.DebitCreditStatusResponse;
import com.neptune.cbawrapper.Configuration.Helpers;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.*;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.*;
import com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment.CategoryServices;
import com.virtualAccountApplication.createAccount.proto.CreateAccountResponse;
import com.virtualAccountApplication.createAccount.proto.CreateBulkAccResponse;
import customers.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@Slf4j
@Controller
public class Cron {
    @Value("${spring.profiles.active}")
    private String env;

    @Value("${client.url}")
    private String client_url;

    @Autowired
    private CorePayRestController corePayRestController;

    @Autowired
    private BillsPayment billsPayment;

    @Autowired
    private TmsCoreWalletAccount tmsCoreWalletAccount;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Logger log = LoggerFactory.getLogger(Cron.class);
    private final CustomersRepository customersRepository;
    private final CustomerService customerService;
    private final ErrorLogsRepository errorLogsRepository;
    private final Helpers helpers;
    private final CbaTransactionRequestsRepository cbaTransactionRequests;
    private final AuthCredentialsRepository authCredentialsRepository;
    private final VirtualAccountService virtualAccountService;
    private final VirtualAccountRepository virtualAccountRepository;
    private final DebitCreditService debitCreditService;
    private final CategoriesRepository categoriesRepository;
    private final CategoryServicesRepository categoryServicesRepository;
    private final TransactionCoreController transactionCoreController;
    private final PlatformChargeRepository platformChargeRepository;
    private final CbaTransactionRequestsRepository cbaTransactionRequestsRepository;
    private final BusinessPlatformChargesRepository businessPlatformChargesRepository;
    private final Notifications notifications;

    public Cron(CustomersRepository customersRepository, CategoryServicesRepository categoryServicesRepository, CategoriesRepository categoriesRepository, CbaTransactionRequestsRepository cbaTransactionRequests, CustomerService customerService, ErrorLogsRepository errorLogsRepository, Helpers helpers, AuthCredentialsRepository authCredentialsRepository, VirtualAccountService virtualAccountService, VirtualAccountRepository virtualAccountRepository, DebitCreditService debitCreditService, TransactionCoreController transactionCoreController, PlatformChargeRepository platformChargeRepository, CbaTransactionRequestsRepository cbaTransactionRequestsRepository, BusinessPlatformChargesRepository businessPlatformChargesRepository, AuthCredentialsRepository authCredentialsRepository1, Notifications notifications) {
        this.customersRepository = customersRepository;
        this.customerService = customerService;
        this.errorLogsRepository = errorLogsRepository;
        this.helpers = helpers;
        this.categoryServicesRepository = categoryServicesRepository;
        this.categoriesRepository = categoriesRepository;
        this.cbaTransactionRequests = cbaTransactionRequests;
        this.authCredentialsRepository = authCredentialsRepository;
        this.virtualAccountService = virtualAccountService;
        this.virtualAccountRepository = virtualAccountRepository;
        this.debitCreditService = debitCreditService;
        this.transactionCoreController = transactionCoreController;
        this.platformChargeRepository = platformChargeRepository;
        this.cbaTransactionRequestsRepository = cbaTransactionRequestsRepository;
        this.businessPlatformChargesRepository = businessPlatformChargesRepository;
        this.notifications = notifications;
    }

    @Scheduled(cron = "0 */3 * * * *")
    public void getCustomersFromCorePay() {
        String tin = "";
        try {
            //TODO: get customers from corePay
            PendingRequestResponse customersModels = corePayRestController.getPending();

            if (customersModels.getTotalFilteredRecords() <= 0 || customersModels.getPageItems().isEmpty()) {
                return;
            }
            log.info("getCustomersFromCorePay 1: {}", customersModels.getTotalFilteredRecords());
            log.info("getCustomersFromCorePay 2: {}", Arrays.toString(customersModels.getPageItems().toArray()));

            List<String> data2 = customersModels.getPageItems()
                    .stream()
                    .map(CustomersModel::getTin) // Extracts TIN from each CustomersModel
                    .collect(Collectors.toList()); // Collects the result into a List
            log.info("getCustomersFromCorePay data2: {}", Arrays.toString(data2.toArray()));

            List<String> customerTin = customersRepository.findByAccountId(
                    data2
            ).stream().map(CustomersModel::getTin).toList();
            log.info("getCustomersFromCorePay customerTin: {}", Arrays.toString(customerTin.toArray()));

            //TODO: create a new list from customersModels, then remove all customer thing from mongodb and create customer from what is left
            List<String> resultList = data2.stream()
                    .filter(item -> !customerTin.contains(item)) // Retain only elements not in listB
                    .toList();
            log.info("getCustomersFromCorePay resultList: {}", Arrays.toString(resultList.toArray()));

            //TODO: check if customer with TIN already exists on middleware if not save customer
            for (int i = 0; i < customersModels.getPageItems().size(); i++) {
                tin = customersModels.getPageItems().get(i).getTin();
                String fullName = customersModels.getPageItems().get(i).getDisplayName();
                if (StringUtils.isNotBlank(tin) && resultList.contains(tin)) {
                    CustomersModel customersModel2 = getCustomersModel(customersModels, i);
                    customersRepository.save(customersModel2);
                } else {
                    ErrorLogsModel errorLogsModel = new ErrorLogsModel(fullName, "TIN is not available");
                    errorLogsModel.setType("CorePay_CREATION");
                    errorLogsModel.setCreatedAt(Instant.now());
                    errorLogsModel.setUpdatedAt(Instant.now());
                    errorLogsRepository.save(errorLogsModel);
                }
            }
        } catch (Exception e) {
            log.warn("savingsEntityRecord: ", e);
            ErrorLogsModel errorLogsModel = new ErrorLogsModel(tin, e.getMessage());
            errorLogsModel.setCreatedAt(Instant.now());
            errorLogsModel.setUpdatedAt(Instant.now());
            errorLogsModel.setType("CorePay_CREATION");
            errorLogsRepository.save(errorLogsModel);
        }
    }

    private static CustomersModel getCustomersModel(PendingRequestResponse customersModels, int i) {

        CustomersModel customersModel = customersModels.getPageItems().get(i);

        //TODO check if phone number exists or email exists before adding email or phone notification
        String firstName = customersModel.getFirstname();
        String companyName = customersModel.getCompany_name();
        boolean sendMail = true;
        boolean sendPhone = true;
        if (StringUtils.isBlank(customersModel.getEmailAddress())) {
            sendMail = false;
        }
        if (StringUtils.isBlank(customersModel.getMobileNo())) {
            sendPhone = false;
        }
        if (StringUtils.isBlank(customersModel.getFirstname())) {
            firstName = customersModel.getDisplayName();
        }
        if (StringUtils.isBlank(customersModel.getCompany_name())) {
            companyName = customersModel.getDisplayName();
        }
        return new CustomersModel(firstName, customersModel.getMiddlename(), companyName, customersModel.getIncorpNo(), customersModel.getDateOfBirth(), customersModel.getCountryOfRegistration(), sendPhone, sendMail, customersModel.getTin(), customersModel.getEmailAddress(), customersModel.getMobileNo(), false, customersModel.getSavingsId(), ZonedDateTime.now().toString(), ZonedDateTime.now().toString());
    }

//    @Scheduled(cron = "0 */5 * * * *")
//    public void updateCustomerAccountNumFromCba() {
//        try {
//            //TODO: get customers without account number and send them to CBA to generate account numbers for them
//            List<CustomersModel> customersModels = customersRepository.getCustomersWithoutAccountId();
//            System.out.println("customersModels = " + customersModels.size());
//            if (customersModels.isEmpty()) {
//                return;
//            }
//
//            //TODO: check if customer already exists on CBA if true, use the customer's account number else create a new account for the customer
//            for (CustomersModel customer : customersModels) {
//                Customer.GetCorporateCustomerResponse checkCustomer = customerService.getCorporateCustomer(customer.getContact_phone_number());
//
//                if(checkCustomer.hasCustomer()){
//                    customer.setAccount_num(checkCustomer.getCustomer().getProducts(1).getAccountNumber());
//                    customer.setCba_customer_id(checkCustomer.getCustomer().getId());
//                    customersRepository.save(customer);
//                }
//
//                customersModels.remove(customer);
//            }
//
//            //TODO add error logging to the db
//            Customer.CreateBulkCorpCustomerResponse response = customerService.createCustomers(customersModels);
//            if (response == null) {
//                return;
//            }
//            List<Customer.CreateBulkCustomerErrResponse> errorResponse = response.getErrorDataList();
//
//            System.out.println("response = " + response);
//            System.out.println("errorResponse = " + errorResponse);
//
//            if (!errorResponse.isEmpty()) {
//                for (Customer.CreateBulkCustomerErrResponse response1 : errorResponse) {
//                    ErrorLogsModel errorLogsModel = new ErrorLogsModel(response1.getTin(), response1.getReason());
//                    errorLogsModel.setType("CBA_CREATION");
//                    errorLogsRepository.save(errorLogsModel);
//                }
//            }
//
//            //TODO: update the generated account number to the customer's entry on the database
//            List<String> data2 = customersModels
//                    .stream()
//                    .map(CustomersModel::getTin) // Extracts TIN from each CustomersModel
//                    .collect(Collectors.toList()); //
//
//            Map<String, List<CustomersModel>> customers = customersRepository.findByAccountId(
//                    data2
//            ).stream().collect(Collectors.groupingBy(CustomersModel::getTin));
//
//            if (customers.isEmpty()) {
//                return;
//            }
//
//            for (int i = 0; i < response.getResponseList().size(); i++) {
//                Optional<CustomersModel> customersModel = customers.get(response.getResponseList().get(i).getTin()).stream().findFirst();
//                final String accountNumber = response.getResponseList().get(i).getAccountNumber();
//                if (customersModel.isPresent() && StringUtils.isNotBlank(accountNumber)) {
//                    customersModel.get().setAccount_num(accountNumber);
//                    customersModel.get().setCba_customer_id(response.getResponseList().get(i).getId());
//                    customersRepository.save(customersModel.get());
//                }
//            }
//        } catch (Exception e) {
//            ErrorLogsModel errorLogsModel = new ErrorLogsModel("tin", e.getMessage());
//            errorLogsModel.setCreatedAt(Instant.now());
//            errorLogsModel.setUpdatedAt(Instant.now());
//            errorLogsModel.setType("CBA_ACCOUNT_UPDATE");
//            errorLogsRepository.save(errorLogsModel);
//        }
//
//    }

    @Scheduled(cron = "0 */5 * * * *")
    @Transactional
    public void updateCustomerAccountNumFromCba() {
        try {
            log.info("Starting scheduled customer account update from CBA");

            // Fetch customers without account numbers
            List<CustomersModel> customersWithoutAccounts = customersRepository.getCustomersWithoutAccountId();

            if (customersWithoutAccounts.isEmpty()) {
                log.info("No customers found without account numbers");
                return;
            }

            log.info("Found {} customers without account numbers", customersWithoutAccounts.size());

            // Separate existing and new customers
            CustomerSegmentation segmentation = segmentCustomers(customersWithoutAccounts);

            // Update existing customers (found in CBA)
            updateExistingCustomers(segmentation.getExistingCustomers());

            // Create new customers in bulk
            if (!segmentation.getNewCustomers().isEmpty()) {
                createNewCustomersInBulk(segmentation.getNewCustomers());
            }

            log.info("Customer account update completed successfully");

        } catch (Exception e) {
            log.error("Error during customer account update", e);
            logError("SCHEDULED_UPDATE_FAILURE", "Global", e.getMessage());
        }
    }

    @Scheduled(cron = "0 */7 * * * *")
    public void updateCustomersToCorePay() {
        try {
            List<CustomersModel> customersModels = customersRepository.getCustomersWithAccountId();
            log.info("updateCustomersToCorePay: {}", customersModels);
            //TODO: send customers with account numbers to corePay
            if (customersModels.isEmpty()) {
                return;
            }

            List<Data> data1 = customersModels.stream()
                    .map(customersModel -> new Data(customersModel.getSavingsId(), customersModel.getAccount_num()))
                    .collect(Collectors.toList());

            log.info("updateCustomersToCorePay data1: {}", data1);

            CustomerData<?> customerData = new CustomerData<>(data1);

            log.info("updateCustomersToCorePay customerData: {}", customerData);

            Object res = corePayRestController.postCustomers(customerData);

            log.info("updateCustomersToCorePay res: {}", res);

            ObjectMapper mapper = new ObjectMapper();
            CorePayUpdateCustomerRes res1 = mapper.convertValue(res, CorePayUpdateCustomerRes.class);
            log.info("updateCustomersToCorePay res1: {}", res1.getRequestResponse());

            //TODO: update customers' is_updated status to true on customer corePay update success response
            if (res1.getRequestResponse().equals("Accounts Sync Successful")) {
                for (CustomersModel customersModel : customersModels) {
                    customersModel.setIs_updated(true);
                    customersRepository.save(customersModel);
                }
            }
        } catch (Exception e) {
            ErrorLogsModel errorLogsModel = new ErrorLogsModel("tin", e.getMessage());
            errorLogsModel.setCreatedAt(Instant.now());
            errorLogsModel.setUpdatedAt(Instant.now());
            errorLogsModel.setType("CUSTOMER_UPDATE_TO_COREPAY");
            errorLogsRepository.save(errorLogsModel);
        }
    }

    @Scheduled(cron = "0 */3 * * * *")
    public void getVirtualTerminalRecords() {
        try {
            List<PendingTerminalData> pendingTerminalData = tmsCoreWalletAccount.getPending();

            System.out.println("pendingTerminalData = " + pendingTerminalData);

            if (pendingTerminalData.isEmpty()) {
                return;
            }

            System.out.println("111111111111");
            List<Integer> details = pendingTerminalData.stream().map(PendingTerminalData::getParentSavingsId).filter(Objects::nonNull).toList();
            List<CustomersModel> customersModels = helpers.getCustomersBySavingsId(details);
            System.out.println("2222222222222");
            Optional<AuthCredentials> authCredentials = authCredentialsRepository.getAuth(env);
            System.out.println("3333333333333");
            List<String> details2 = pendingTerminalData.stream().map(PendingTerminalData::getTerminalId).filter(Objects::nonNull).toList();
            List<VirtualAccountModel> findByVirtualAccountsByTerminalId = virtualAccountRepository.findByVirtualAccountsByTerminalId(details2);

            for (PendingTerminalData data : pendingTerminalData) {
                Optional<CustomersModel> customersModel = customersModels.stream().filter(customersModel1 -> data.getParentSavingsId().equals(customersModel1.getSavingsId())).findFirst();
                System.out.println("444444444444444");
                System.out.println("env = " + env);
                if (authCredentials.isPresent()) {
                    if (customersModel.isPresent()) {
                        Optional<VirtualAccountModel> virtualAccountModel = findByVirtualAccountsByTerminalId.stream().filter(virtualAccountModel1 -> data.getTerminalId().equals(virtualAccountModel1.getTerminalId())).findFirst();
                        System.out.println("55555555555555");
                        if (virtualAccountModel.isEmpty()) {
                            System.out.println("66666666666666");
                            VirtualAccountModel virtualAccountModel1 = getVirtualAccountModel(customersModel.get(), authCredentials, data);
                            System.out.println("virtualAccountModel1 = " + virtualAccountModel1);
                            virtualAccountRepository.save(virtualAccountModel1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            ErrorLogsModel errorLogsModel = new ErrorLogsModel("Virtual_account_creation", e.getMessage());
            errorLogsModel.setCreatedAt(Instant.now());
            errorLogsModel.setUpdatedAt(Instant.now());
            errorLogsModel.setType("CUSTOMER_VIRTUAL_ACCOUNT");
            errorLogsRepository.save(errorLogsModel);
        }
    }

    private static VirtualAccountModel getVirtualAccountModel(CustomersModel customersModel, Optional<AuthCredentials> authCredentials, PendingTerminalData data) {
        VirtualAccountModel virtualAccountModel = new VirtualAccountModel();
        virtualAccountModel.setSavingsId(customersModel.getSavingsAccountId());
        virtualAccountModel.setPhone_number(customersModel.getContact_phone_number());
        virtualAccountModel.setAccount_name(data.getParentEntityName() + "_" + data.getTerminalName());
        virtualAccountModel.setEmail(customersModel.getEmailAddress());
        virtualAccountModel.setBvn("");
        virtualAccountModel.setTerminalId(data.getTerminalId());
        virtualAccountModel.setNin("");
        virtualAccountModel.setIs_updated(false);
        virtualAccountModel.setTin(customersModel.getTin());
        virtualAccountModel.setParent_id(customersModel.getId());
        virtualAccountModel.setParent_account(customersModel.getAccount_num());
        virtualAccountModel.setBusinessName(data.getBusinessName());
        virtualAccountModel.setBusinessSavingsId(data.getBusinessSavingsId());
        virtualAccountModel.setBusinessWalletId(data.getBusinessWalletId());
        virtualAccountModel.setCreated_at(ZonedDateTime.now().toString());
        virtualAccountModel.setUpdated_at(ZonedDateTime.now().toString());
        return virtualAccountModel;
    }

    @Scheduled(cron = "0 */2 * * * *")
    public void updateVirtualAccount() {
        try {
            Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getCustomersWithoutAccountId();

            System.out.println("virtualAccountModel = " + virtualAccountModel);

            if (virtualAccountModel.isEmpty()) {
                return;
            }

            //TODO: check if POS has already been created for this business with an account number else use the business account number
            Optional<VirtualAccountModel> virtualAccount = virtualAccountRepository.getCustomersWithAccountId(virtualAccountModel.get().getParent_account());

            if(virtualAccount.isEmpty()){
                VirtualAccountModel virtualAccountModel1 = virtualAccountModel.get();
                virtualAccountModel1.setVirtual_account_number(virtualAccountModel.get().getParent_account());
                virtualAccountRepository.save(virtualAccountModel1);

                sendPasswordMail(virtualAccountModel.get());
                return;
            }

            //TODO: create corporate account for POS
            Customer.CreateCustomerProductResponse response = customerService.getCorporateCustomerAcctNum(virtualAccountModel.get().getParent_id(),  virtualAccountModel.get().getParent_account());

            System.out.println("response = " + response);
            if (virtualAccountModel.get().getParent_id().equals(response.getCustomerProductId())) {
                VirtualAccountModel virtualAccountModel1 = virtualAccountModel.get();
                virtualAccountModel1.setVirtual_account_number(response.getAccountNumber());
                virtualAccountRepository.save(virtualAccountModel1);

                sendPasswordMail(virtualAccountModel.get());
            }

        } catch (Exception e) {
            ErrorLogsModel errorLogsModel = new ErrorLogsModel("Virtual_account_update", e.getMessage());
            errorLogsModel.setCreatedAt(Instant.now());
            errorLogsModel.setUpdatedAt(Instant.now());
            errorLogsModel.setType("CUSTOMER_VIRTUAL_ACCOUNT_UPDATE");
            errorLogsRepository.save(errorLogsModel);
        }
    }


    @Scheduled(cron = "0 */6 * * * *")
    public void updateVirtualAccountToCorePay() {
        List<VirtualAccountModel> virtualAccountModelList = virtualAccountRepository.getCustomersNotAddedToCorePay();

        if (virtualAccountModelList.isEmpty()) {
            return;
        }

        List<TerminalData> data1 = virtualAccountModelList.stream()
                .map(virtualModel -> new TerminalData(virtualModel.getTerminalId(), virtualModel.getVirtual_account_number()))
                .toList();

        CustomerData<?> customerData = new CustomerData<>(data1);

        //TODO: rewrite this to pass all responses from above to the
        Object res = tmsCoreWalletAccount.postWallets(customerData);
        System.out.println("res5 = " + res);
        if (res != null) {
            for (VirtualAccountModel virtualAccountModel3 : virtualAccountModelList) {
                virtualAccountModel3.setIs_updated(true);
                virtualAccountRepository.save(virtualAccountModel3);
            }
        }
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void pushTransactionsToCba() {
        List<TransactionDrCr> transactionDrCr = cbaTransactionRequestsRepository.findTransactionsNotLoggedToCba(false);

        System.out.println("transactionDrCr = " + transactionDrCr);

        if(transactionDrCr.isEmpty()){
            return;
        }

        for (TransactionDrCr transactionDrCr1 : transactionDrCr) {
            if (transactionDrCr1.getAccountnumber() != null && transactionDrCr1.getAmount() > 0) {

                if (transactionDrCr1.getResponseCode().equals("00")) {

                    //todo: 1. debit transaction charge from terminal transactionDrCr1.getAccountnumber()) using business_platform-charge repo
                    //todo: 2. credit charge value from no.1 to business_platform-charge.getAccountnumber())

                    Optional<PlatformCharges> platformCharges = platformChargeRepository.getChargeByName(transactionDrCr1.getTransaction_platform_id());
//                    Optional<BusinessPlatformCharges> businessPlatformCharges = businessPlatformChargesRepository.getChargeByBusinessPlatformId(transactionDrCr1.getTransaction_business_platform_id());
//
//                    System.out.println("========================================= 1");
//                    if (businessPlatformCharges.isEmpty()) {
//                        return;
//                    }

                    System.out.println("========================================= 2");
                    if (platformCharges.isPresent()) {
                        System.out.println("========================================= 3");
                        //todo: debit platform charge from terminal
                        String chargeType = platformCharges.get().getChargeType();
                        double amount = (0.5/100) * transactionDrCr1.getAmount();
                        if(amount > 100){
                            amount = 100;
                        }
//                        double amount2;
//
//                        if (chargeType.equalsIgnoreCase("percentage")) {
//                            amount = (platformCharges.get().getTotal() / 100) * transactionDrCr1.getAmount();
//                        } else {
//                            amount = platformCharges.get().getAmount();
//                        }
//
//                        if (amount > platformCharges.get().getThreshold()) {
//                            amount = platformCharges.get().getThreshold();
//                        }

//                        String chargeType2 = businessPlatformCharges.get().getChargeType();
//                        if (chargeType2.equalsIgnoreCase("percentage")) {
//                            amount2 = (businessPlatformCharges.get().getAmount() / 100) * amount;
//                        } else {
//                            amount2 = businessPlatformCharges.get().getAmount();
//                        }

//                        if (amount2 > businessPlatformCharges.get().getThreshold()) {
//                            amount2 = businessPlatformCharges.get().getThreshold();
//                        }

                        DebitCreditResponse response = debitCreditService.debitCredit(transactionDrCr1, amount, "");

                        if (response != null) {
                            if (response.getCode().equals("200")) {
                                String id = transactionDrCr1.getId();
                                transactionDrCr1.setUpdatedToCba(true);
                                transactionDrCr1.setCbaMessage(response.getMessage());
                                transactionDrCr1.setCreated_at(LocalDateTime.now().toString());
                                transactionDrCr1.setUpdated_at(LocalDateTime.now().toString());
                                cbaTransactionRequestsRepository.save(transactionDrCr1);

                                UpdateTransactionRequestSchema requestSchema = new UpdateTransactionRequestSchema();
                                requestSchema.setNote("SUBMITTED");
                                requestSchema.setStatus(200);
                                System.out.println("requestSchema = " + requestSchema);
                                Object updateTransactionResponseSchema = transactionCoreController.updateTransaction(transactionDrCr1.getResourceId(), requestSchema);
                                System.out.println("SENT_TO_CBA");
                                System.out.println("updateTransactionResponseSchema = " + updateTransactionResponseSchema);
                            } else {
                                System.out.println("jjjjjjjj here");
                                UpdateTransactionRequestSchema requestSchema = new UpdateTransactionRequestSchema();
                                requestSchema.setNote(response.getMessage());
                                requestSchema.setStatus(100);
                                System.out.println("kkkkkkkkkkkkk");
                                Object updateTransactionResponseSchema = transactionCoreController.updateTransaction(transactionDrCr1.getResourceId(), requestSchema);
                                System.out.println("jjsjsjadj");
                                System.out.println("NOT_SENT_TO_CBA");
                                System.out.println("updateTransactionResponseSchema = " + updateTransactionResponseSchema);
                            }
                        }
                    }
                }
            }
        }
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void checkTransactionStatusOnCba() {
        List<TransactionDrCr> transactionDrCr = cbaTransactionRequestsRepository.findTransactionsLoggedToCba(true);
        for (TransactionDrCr transactionDrCr1 : transactionDrCr) {
            if (transactionDrCr1.getStatus_response_code() == null) {
                this.checkTransactionStatus(transactionDrCr1);
            } else if (!transactionDrCr1.getStatus_response_code().equals("200") && !transactionDrCr1.getStatus_response_code().equals("400")) {
                this.checkTransactionStatus(transactionDrCr1);
            }
        }
    }

    public void checkTransactionStatus(TransactionDrCr transactionDrCr1) {
        System.out.println("transactionDrCr1.getTransactionreference() = " + transactionDrCr1.getTransactionreference());
        DebitCreditStatusResponse response = debitCreditService.debitCreditStatusResponse(transactionDrCr1.getTransactionreference());

        System.out.println("status response = " + response);

        UpdateTransactionRequestSchema requestSchema = new UpdateTransactionRequestSchema();
        if (response.getCode().equals("200")) {
            transactionDrCr1.setStatus_response_code(response.getCode());
            transactionDrCr1.setStatus_response_message(response.getResponse());
            cbaTransactionRequestsRepository.save(transactionDrCr1);

            requestSchema.setNote("COMPLETED");
            requestSchema.setStatus(300);
            System.out.println("requestSchema = " + requestSchema);
            Object updateTransactionResponseSchema = transactionCoreController.updateTransaction(transactionDrCr1.getResourceId(), requestSchema);
            System.out.println("updateTransactionResponseSchema from status check= " + updateTransactionResponseSchema);
        } else {
            transactionDrCr1.setStatus_response_code(response.getCode());
            transactionDrCr1.setStatus_response_message(response.getResponse());
            cbaTransactionRequestsRepository.save(transactionDrCr1);

            requestSchema.setNote(response.getResponse());
            requestSchema.setStatus(300);
            System.out.println("requestSchema = " + requestSchema);
            Object updateTransactionResponseSchema = transactionCoreController.updateTransaction(transactionDrCr1.getResourceId(), requestSchema);
        }
    }

    @Scheduled(cron = "0 0 0 ? * FRI")
    public void getCategories(){
        Categories getBillsCat = billsPayment.getBillsCategories();
        if(!getBillsCat.getData().isEmpty()){
            for (DataItems i : getBillsCat.getData()) {
                Optional<CategoriesModel> categoriesModel = categoriesRepository.findCategory(i.getId(), i.getName());
                if(categoriesModel.isEmpty()) {
                    System.out.println("Kalu");
                    boolean isActive = i.getName().equalsIgnoreCase("Utility Bills") || i.getName().equalsIgnoreCase("Cable TV Bills") || i.getName().equalsIgnoreCase("State Payments") || i.getName().equalsIgnoreCase("Mobile/Recharge");
                    CategoriesModel categories = new CategoriesModel();
                    categories.setInterswitchId(i.getId());
                    categories.setName(i.getName());
                    categories.setDescription(i.getDescription());
                    categories.setActive(isActive);
                    categories.setLogo("");
                    categories.setPaymentTypeId(3);
                    categories.setValidateNum(true);
                    if(i.getName().equalsIgnoreCase("Mobile Recharge") || i.getName().equalsIgnoreCase("Airtime and Data") || i.getName().equalsIgnoreCase("Internet Services")){
                        categories.setPaymentTypeId(2);
                        categories.setValidateNum(false);
                    }
                    categoriesRepository.save(categories);
                }
            }

            List<CategoriesModel> dataItems = categoriesRepository.findCategory(true);

            for (CategoriesModel model : dataItems){
                System.out.println("Philomena");
                if(model.getActive()) {
                    System.out.println("Here");
                    CategoryServices getCatServices = billsPayment.getCategoryServices(model.getInterswitchId());

                    if (!getCatServices.getData().isEmpty()) {
                        for (DataServices i : getCatServices.getData()) {
                            List<CategoryServicesModel> categoryServicesChecker = categoryServicesRepository.findCategoryService(i.getServiceId(), i.getCategoryName());
                            if(categoryServicesChecker.isEmpty()) {
                                System.out.println("Danny");
                                CategoryServicesModel categoryServicesModel = new CategoryServicesModel();
                                categoryServicesModel.setServiceName(i.getServiceName());
                                categoryServicesModel.setCategoryName(i.getCategoryName());
                                categoryServicesModel.setLogo(i.getLogo());
                                categoryServicesModel.setInterswitchId(model.getInterswitchId());
                                categoryServicesModel.setServiceId(i.getServiceId());
                                categoryServicesModel.setSupportEmail(i.getSupportEmail());

                                BillInfo getBillInfo = billsPayment.getBillerInfo(i.getServiceId());
                                List<BillerInfo> billerInfos = new ArrayList<>();
                                if (!getBillInfo.getData().isEmpty()) {
                                    for (BillInfoData j : getBillInfo.getData()) {
                                        BillerInfo info = new BillerInfo();
                                        info.setAmount(j.getAmount());
                                        info.setName(j.getName());
                                        info.setFee(j.getFee());
                                        info.setBillerInfoId(j.getId());
                                        info.setPaymentCode(j.getPaymentCode());
                                        info.setCustomerIdField(j.getCustomerIdField());
                                        info.setIsAmountFixed(j.getIsAmountFixed());
                                        info.setCurrencySymbol(j.getCurrencySymbol());
                                        billerInfos.add(info);
                                    }
                                }
                                categoryServicesModel.setBillerInfos(billerInfos);
                                categoryServicesRepository.save(categoryServicesModel);
                            }
                        }
                    }
                }
            }

            System.out.println("DONE");
        }
    }

    public notification_service.Notifications.NotificationResponse sendPasswordMail(VirtualAccountModel virtualAccountModel){
        System.out.println("virtualAccountModel.getSavingsId() = " + virtualAccountModel.getBusinessSavingsId());
        Optional<CustomersModel> customersModel = helpers.getCustomerBySavingsId(virtualAccountModel.getBusinessSavingsId());

        if(customersModel.isEmpty()){
            return null;
        }
        String genericCode = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmssSSS"));
        virtualAccountModel.setGenericCode(genericCode);
        virtualAccountModel.setCodeExpired(false);
        virtualAccountModel.setToken_expiry(LocalDateTime.now().plusMinutes(10).toString());
        virtualAccountRepository.save(virtualAccountModel);
        String message = "Kindly click on the link below to activate your POS transaction pin <br /> <a href=\"" +client_url+genericCode + "\" target=\"_blank\">Set Pin</a>";
        SendNotifications notifications1 = SendNotifications.builder()
                .title("Set POS Password")
                .file("")
                .message(message)
                .receiver_email(customersModel.get().getEmail_address())
                .sendmail(true)
                .attachment(true)
                .build();
        return notifications.sendNotification(notifications1);
    }

    /**
     * Segments customers into existing (already in CBA) and new (need to be created)
     */
    private CustomerSegmentation segmentCustomers(List<CustomersModel> customers) {
        List<CustomersModel> existingCustomers = new ArrayList<>();
        List<CustomersModel> newCustomers = new ArrayList<>();
        List<CompletableFuture<CustomerCheckResult>> futures = new ArrayList<>();

        // Check customers in parallel batches to avoid overwhelming the gRPC service
        int batchSize = 10; // Adjust based on your gRPC server capacity
        for (int i = 0; i < customers.size(); i += batchSize) {
            int end = Math.min(i + batchSize, customers.size());
            List<CustomersModel> batch = customers.subList(i, end);

            for (CustomersModel customer : batch) {
                CompletableFuture<CustomerCheckResult> future = CompletableFuture.supplyAsync(() ->
                                checkCustomerExists(customer),
                        executorService // Use virtual threads (Java 21) or a thread pool
                );
                futures.add(future);
            }

            // Wait for current batch to complete before starting next batch
            try {
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                        .get(30, TimeUnit.SECONDS); // Timeout per batch
            } catch (Exception e) {
                log.error("Error processing batch starting at index {}", i, e);
            }
        }

        // Collect results
        for (CompletableFuture<CustomerCheckResult> future : futures) {
            try {
                CustomerCheckResult result = future.get();
                if (result.isExists()) {
                    existingCustomers.add(result.getCustomer());
                } else {
                    newCustomers.add(result.getCustomer());
                }
            } catch (Exception e) {
                log.error("Error getting customer check result", e);
                // Add to new customers by default if check fails
//                newCustomers.add(result.getCustomer());
            }
        }

        log.info("Segmentation complete: {} existing, {} new customers",
                existingCustomers.size(), newCustomers.size());

        return new CustomerSegmentation(existingCustomers, newCustomers);
    }


    private final ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * 2 // tune based on gRPC server capacity
    );

    /**
     * Check if customer exists in CBA
     */
    private CustomerCheckResult checkCustomerExists(CustomersModel customer) {
        try {
            Customer.GetCorporateCustomerResponse response =
                    customerService.getCorporateCustomer(customer.getContact_phone_number());

            if (response.hasCustomer()) {
                // Extract account number safely
                String accountNumber = extractAccountNumber(response);
                if (accountNumber != null) {
                    customer.setAccount_num(accountNumber);
                    customer.setCba_customer_id(response.getCustomer().getId());
                    return new CustomerCheckResult(customer, true);
                }
            }

            return new CustomerCheckResult(customer, false);

        } catch (Exception e) {
            log.error("Error checking customer existence for phone: {}",
                    customer.getContact_phone_number(), e);
            logError("CUSTOMER_CHECK_FAILED", customer.getTin(), e.getMessage());
            return new CustomerCheckResult(customer, false);
        }
    }

    /**
     * Safely extract account number from gRPC response
     */
    private String extractAccountNumber(Customer.GetCorporateCustomerResponse response) {
        try {
            if (response.getCustomer().getProductsCount() > 0) {
                // Use getProducts(0) instead of getProducts(1) - lists are 0-indexed
                return response.getCustomer().getProducts(0).getAccountNumber();
            }
        } catch (Exception e) {
            log.warn("Error extracting account number", e);
        }
        return null;
    }

    /**
     * Update existing customers in database
     */
    private void updateExistingCustomers(List<CustomersModel> existingCustomers) {
        if (existingCustomers.isEmpty()) {
            return;
        }

        log.info("Updating {} existing customers", existingCustomers.size());

        try {
            // Batch save for better performance
            customersRepository.saveAll(existingCustomers);
            log.info("Successfully updated {} existing customers", existingCustomers.size());

        } catch (Exception e) {
            log.error("Error updating existing customers", e);
            logError("EXISTING_CUSTOMER_UPDATE_FAILED", "BATCH", e.getMessage());

            // Fallback: try saving one by one
            for (CustomersModel customer : existingCustomers) {
                try {
                    customersRepository.save(customer);
                } catch (Exception ex) {
                    log.error("Failed to update customer: {}", customer.getTin(), ex);
                    logError("CUSTOMER_UPDATE_FAILED", customer.getTin(), ex.getMessage());
                }
            }
        }
    }

    /**
     * Create new customers in CBA in bulk
     */
    private void createNewCustomersInBulk(List<CustomersModel> newCustomers) {
        log.info("Creating {} new customers in CBA", newCustomers.size());

        try {
            Customer.CreateBulkCorpCustomerResponse response =
                    customerService.createCustomers(newCustomers);

            if (response == null) {
                log.error("Received null response from bulk customer creation");
                logError("BULK_CREATE_NULL_RESPONSE", "BATCH", "Null response from CBA");
                return;
            }

            // Process errors
            processCreationErrors(response.getErrorDataList());

            // Update successfully created customers
            updateCreatedCustomers(newCustomers, response.getResponseList());

        } catch (Exception e) {
            log.error("Error creating customers in bulk", e);
            logError("BULK_CREATE_FAILED", "BATCH", e.getMessage());
        }
    }

    /**
     * Process and log customer creation errors
     */
    private void processCreationErrors(List<Customer.CreateBulkCustomerErrResponse> errors) {
        if (errors.isEmpty()) {
            return;
        }

        log.warn("Encountered {} errors during customer creation", errors.size());

        List<ErrorLogsModel> errorLogs = errors.stream()
                .map(error -> {
                    ErrorLogsModel errorLog = new ErrorLogsModel(error.getTin(), error.getReason());
                    errorLog.setType("CBA_CREATION");
                    errorLog.setCreatedAt(Instant.now());
                    errorLog.setUpdatedAt(Instant.now());
                    return errorLog;
                })
                .collect(Collectors.toList());

        try {
            errorLogsRepository.saveAll(errorLogs);
        } catch (Exception e) {
            log.error("Error saving error logs", e);
        }
    }

    /**
     * Update database with created customer account numbers
     */
    private void updateCreatedCustomers(
            List<CustomersModel> customers,
            List<Customer.CreateBulkCustomerResponse> responses) {

        if (responses.isEmpty()) {
            log.info("No successful customer creations to update");
            return;
        }

        // Create TIN to customer map for O(1) lookup
        Map<String, CustomersModel> customersByTin = customers.stream()
                .collect(Collectors.toMap(
                        CustomersModel::getTin,
                        customer -> customer,
                        (existing, duplicate) -> existing // Handle duplicates
                ));

        List<CustomersModel> customersToUpdate = new ArrayList<>();

        for (Customer.CreateBulkCustomerResponse response : responses) {
            CustomersModel customer = customersByTin.get(response.getTin());

            if (customer != null && StringUtils.isNotBlank(response.getAccountNumber())) {
                customer.setAccount_num(response.getAccountNumber());
                customer.setCba_customer_id(response.getId());
                customersToUpdate.add(customer);
            } else {
                log.warn("Could not find customer for TIN: {} or account number is blank",
                        response.getTin());
            }
        }

        if (!customersToUpdate.isEmpty()) {
            try {
                customersRepository.saveAll(customersToUpdate);
                log.info("Successfully updated {} created customers", customersToUpdate.size());
            } catch (Exception e) {
                log.error("Error updating created customers", e);
                logError("CREATED_CUSTOMER_UPDATE_FAILED", "BATCH", e.getMessage());
            }
        }
    }

    private void logError(String type, String tin, String message) {
        try {
            ErrorLogsModel errorLog = new ErrorLogsModel(tin, message);
            errorLog.setType(type);
            errorLog.setCreatedAt(Instant.now());
            errorLog.setUpdatedAt(Instant.now());
            errorLogsRepository.save(errorLog);
        } catch (Exception e) {
            log.error("Failed to log error to database", e);
        }
    }
}


