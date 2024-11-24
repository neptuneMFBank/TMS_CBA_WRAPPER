package com.neptune.cbawrapper.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.AuthCredentialsRepository;
import com.neptune.cbawrapper.Repository.CustomersRepository;
import com.neptune.cbawrapper.Repository.ErrorLogsRepository;
import com.neptune.cbawrapper.Repository.VirtualAccountRepository;
import com.neptune.cbawrapper.RequestRessponseSchema.CorePayUpdateCustomerRes;
import com.neptune.cbawrapper.RequestRessponseSchema.CustomerData;
import com.neptune.cbawrapper.RequestRessponseSchema.Data;
import com.virtualAccountApplication.createAccount.proto.CreateAccountResponse;
import customers.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Cron {

    @Autowired
    private CorePayRestController corePayRestController;

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Logger log = LoggerFactory.getLogger(Cron.class);
    private final CustomersRepository customersRepository;
    private final CustomerService customerService;
    private final ErrorLogsRepository errorLogsRepository;
    private final AuthCredentialsRepository authCredentialsRepository;
    private final VirtualAccountService virtualAccountService;
    private final VirtualAccountRepository virtualAccountRepository;

    @Scheduled(cron = "0 */1 * * * *")
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
//
//
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
        return new CustomersModel(firstName, customersModel.getMiddlename(), companyName, customersModel.getIncorpNo(), customersModel.getDateOfBirth(), customersModel.getCountryOfRegistration(), sendPhone, sendMail, customersModel.getTin(), customersModel.getEmailAddress(), customersModel.getMobileNo(), false, customersModel.getSavingsId());
    }

    @Scheduled(cron = "0 */10 * * * *")
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

            CustomerData customerData = new CustomerData(data1);

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

    @Scheduled(cron = "0 */7 * * * *")
    public void updateCustomerAccountNumFromCba() {
        try {
            //TODO: get customers without account number and send them to CBA to generate account numbers for them
            List<CustomersModel> customersModels = customersRepository.getCustomersWithoutAccountId();
            System.out.println("customersModels = " + customersModels.size());
            if (customersModels.isEmpty()) {
                return;
            }

            //TODO add error logging to the db
            Customer.CreateBulkCorpCustomerResponse response = customerService.createCustomers(customersModels);
            if(response == null){
                return;
            }
            List<Customer.CreateBulkCustomerErrResponse> errorResponse = response.getErrorDataList();

            if (!errorResponse.isEmpty()) {
                for (Customer.CreateBulkCustomerErrResponse response1 : errorResponse) {
                    ErrorLogsModel errorLogsModel = new ErrorLogsModel(response1.getTin(), response1.getReason());
                    errorLogsModel.setType("CBA_CREATION");
                    errorLogsRepository.save(errorLogsModel);
                }
            }

            //TODO: update the generated account number to the customer's entry on the database
            List<String> data2 = customersModels
                    .stream()
                    .map(CustomersModel::getTin) // Extracts TIN from each CustomersModel
                    .collect(Collectors.toList()); //

            Map<String, List<CustomersModel>> customers = customersRepository.findByAccountId(
                    data2
            ).stream().collect(Collectors.groupingBy(CustomersModel::getTin));

            if (customers.isEmpty()) {
                return;
            }

            for (int i = 0; i < response.getResponseList().size(); i++) {
                Optional<CustomersModel> customersModel = customers.get(response.getResponseList().get(i).getTin()).stream().findFirst();
                final String accountNumber = response.getResponseList().get(i).getAccountNumber();
                if (customersModel.isPresent() && StringUtils.isNotBlank(accountNumber)) {
                    customersModel.get().setAccount_num(accountNumber);
                    customersModel.get().setCba_customer_id(response.getResponseList().get(i).getId());
                    customersRepository.save(customersModel.get());
                }
            }
        } catch (Exception e) {
            ErrorLogsModel errorLogsModel = new ErrorLogsModel("tin", e.getMessage());
            errorLogsModel.setCreatedAt(Instant.now());
            errorLogsModel.setUpdatedAt(Instant.now());
            errorLogsModel.setType("CBA_ACCOUNT_UPDATE");
            errorLogsRepository.save(errorLogsModel);
        }

    }

    @Scheduled(cron = "0 */15 * * * *")
    public  void getVirtualTerminalRecords(){
        try {
            Optional<AuthCredentials> authCredentials = authCredentialsRepository.getAuth();

            if(authCredentials.isPresent()){
                VirtualAccountModel virtualAccountModel = new VirtualAccountModel();
                virtualAccountModel.setPhone_number("07014149266");
                virtualAccountModel.setAccount_name("Abel Kalu");
                virtualAccountModel.setEmail("abelkelly6022@gmail.com");
                virtualAccountModel.setBvn("22234788891");
                virtualAccountModel.setNin("5453456789");
                virtualAccountModel.setIs_updated(false);
                virtualAccountModel.setParent_id(authCredentials.get().getCustomer_id());
                virtualAccountModel.setParent_account("2020202200");
                virtualAccountRepository.save(virtualAccountModel);
            }
        } catch (Exception e) {
            ErrorLogsModel errorLogsModel = new ErrorLogsModel("Virtual_account_creation", e.getMessage());
            errorLogsModel.setCreatedAt(Instant.now());
            errorLogsModel.setUpdatedAt(Instant.now());
            errorLogsModel.setType("CUSTOMER_VIRTUAL_ACCOUNT");
            errorLogsRepository.save(errorLogsModel);
        }
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void updateVirtualAccount(){
        try {
            List<VirtualAccountModel> virtualAccountModelList = virtualAccountRepository.getCustomersWithoutAccountId();
            Optional<AuthCredentials> authCredentials = authCredentialsRepository.getAuth();

            if(virtualAccountModelList == null){
                return;
            }

            if(authCredentials.isEmpty()){
                return;
            }

            for(VirtualAccountModel virtualAccountModel : virtualAccountModelList) {
                virtualAccountModel.setParent_id(authCredentials.get().getCustomer_id());
                CreateAccountResponse response = virtualAccountService.createVirtualAccount(virtualAccountModel);

                if (response != null) {
                    virtualAccountModel.setVirtual_account_number(response.getStaticAccountCreationResponse().getAccountNumber());
                    virtualAccountRepository.save(virtualAccountModel);
                }
            }
        } catch (Exception e) {
            ErrorLogsModel errorLogsModel = new ErrorLogsModel("Virtual_account_update", e.getMessage());
            errorLogsModel.setCreatedAt(Instant.now());
            errorLogsModel.setUpdatedAt(Instant.now());
            errorLogsModel.setType("CUSTOMER_VIRTUAL_ACCOUNT_UPDATE");
            errorLogsRepository.save(errorLogsModel);
        }
    }
}
