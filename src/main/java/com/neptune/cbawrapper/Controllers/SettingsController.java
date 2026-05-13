package com.neptune.cbawrapper.Controllers;

import com.neptune.cba.transaction.balance.BalanceResponse;
import com.neptune.cba.transaction.balance.BulkBalanceResponse;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.*;
import com.neptune.cbawrapper.RequestRessponseSchema.*;
import com.neptune.cbawrapper.Services.*;
import com.neptune.cbawrapper.utils.SequenceGenerator;
import customers.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/settings")
public class SettingsController {

    @Value("${pos.settlement.bank.name}")
    private String pos_settlement_bank_name;

    @Value("${pos.settlement.bank.number}")
    private String pos_settlement_bank_number;

    @Value("${pos.visa.acquirer.id.number}")
    private String pos_visa_acquirer_id_number;

    @Value("${pos.verve.acquirer.id.number}")
    private String pos_verve_acquirer_id_number;

    @Value("${pos.mastercard.acquirer.id.number}")
    private String pos_mastercard_acquirer_id_number;

    @Value("${pos.afrigo.acquirer.id.number}")
    private String pos_afrigo_acquirer_id_number;


    private final TmsCoreWalletAccount tmsCoreWalletAccount;
    private final PasswordEncoder passwordEncoder;
    private final MerchantRepository merchantRepository;
    private final VirtualAccountRepository virtualAccountRepository;
    private final DisputeRepository disputeRepository;
    private final Cron cron;
    private final MerchantExcelService merchantExcelService;
    private final BankRepository bankRepository;
    private final SequenceGenerator sequenceGenerator;
    private final LgaRepository lgaRepository;
    private final CustomerService customerService;
    private final StateRepository stateRepository;
    private final TransactionService transactionService;

    public SettingsController(TransactionService transactionService, MerchantExcelService merchantExcelService, SequenceGenerator sequenceGenerator, MerchantRepository merchantRepository, CustomerService customerService, BankRepository bankRepository, LgaRepository lgaRepository, StateRepository stateRepository, TmsCoreWalletAccount tmsCoreWalletAccount, Cron cron, VirtualAccountRepository virtualAccountRepository, PasswordEncoder passwordEncoder, DisputeRepository disputeRepository) {
        this.tmsCoreWalletAccount = tmsCoreWalletAccount;
        this.cron = cron;
        this.transactionService = transactionService;
        this.bankRepository = bankRepository;
        this.merchantExcelService = merchantExcelService;
        this.merchantRepository = merchantRepository;
        this.customerService = customerService;
        this.lgaRepository = lgaRepository;
        this.sequenceGenerator = sequenceGenerator;
        this.stateRepository = stateRepository;
        this.disputeRepository = disputeRepository;
        this.virtualAccountRepository = virtualAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/fetch-terminal-menu/{serialNo}")
    public ResponseEntity<ResponseSchema<?>> getMenuData(@PathVariable String serialNo) {
        MenuDetails menuDetails = tmsCoreWalletAccount.getTerminalMenus(serialNo);
        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "terminal data fetched successfully", menuDetails, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/set-password")
    public ResponseEntity<ResponseSchema<?>> setPassword(@RequestBody PinRequest request) {
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByGenericCode(request.getGenericCode());

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid code", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        if (virtualAccountModel.get().isCodeExpired()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(400, "Code expired", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.BAD_REQUEST);
        }

        if (virtualAccountModel.get().getGenericCode().equalsIgnoreCase(request.getGenericCode())) {
            if (LocalDateTime.parse(virtualAccountModel.get().getToken_expiry()).isBefore(LocalDateTime.now())) {
                cron.sendPasswordMail(virtualAccountModel.get());

                ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "Password expired, kindly check your mail for new password link", "", "", ZonedDateTime.now(), false);
                return new ResponseEntity<>(responseSchema, HttpStatus.OK);
            }

            String hashedPassword = passwordEncoder.encode(request.getPin());
            virtualAccountModel.get().setPin(hashedPassword);
            virtualAccountModel.get().setCodeExpired(true);
            virtualAccountRepository.save(virtualAccountModel.get());

            ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "Password set successfully", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.OK);
        }

        ResponseSchema<?> responseSchema = new ResponseSchema<>(501, "Code mismatch", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/reset-password")
    public ResponseEntity<ResponseSchema<?>> resetPassword(@RequestParam String account) {
        Optional<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.getVirtualAccountModelByAccount(account);

        if (virtualAccountModel.isEmpty()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "invalid account", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        cron.sendPasswordMail(virtualAccountModel.get());

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "Password expired, kindly check your mail for new password link", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/create-dispute-reason")
    public ResponseEntity<ResponseSchema<?>> createDisputeReason(@RequestBody DisputeReasonRequest request) {
        Optional<DisputeReasons> checkDispute = disputeRepository.getDispute(request.getReason());

        if (checkDispute.isPresent()) {
            ResponseSchema<?> responseSchema = new ResponseSchema<>(501, "Dispute type already created", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        DisputeReasons reasons = new DisputeReasons();
        reasons.setReason(request.getReason());
        reasons.setType(request.getType());

        disputeRepository.save(reasons);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "Dispute type created successfully", "", "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-dispute-reasons")
    public ResponseEntity<ResponseSchema<?>> getDisputeReason() {
        List<DisputeReasons> getDisputeReasons = disputeRepository.findAll();

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "Dispute type created successfully", getDisputeReasons, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create-pos-request")
    public ResponseEntity<ResponseSchema<?>> generateTerminalIds(@RequestBody TerminalUsers request) {
        Optional<Bank> getBanks = bankRepository.findByBankName(pos_settlement_bank_name);
        List<Lgas> getLga = lgaRepository.findAll();

        Optional<MerchantData> geMerchantAcct = merchantRepository.findFirstByOrderByCreatedAtDesc();
        Optional<VirtualAccountModel> getVirtualAcct = virtualAccountRepository.findFirstByOrderByCreatedAtDesc();

        Customer.GetCorporateByAccountResponse response =
                customerService.getCustomerAcctNum(request.getBusinessAcct());

        if(response == null){
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "Business with account number not found", null, "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        String terminalLgaCode = getLga.stream()
                .filter(lga -> lga.getLgaName().equalsIgnoreCase(request.getTerminalAddressLga()))
                .map(Lgas::getLgaCode)
                .findFirst()
                .orElse(null);

        String merchantLgaCode = getLga.stream()
                .filter(lga -> lga.getLgaName().equalsIgnoreCase(request.getMerchantAddressLga()))
                .map(Lgas::getLgaCode)
                .findFirst()
                .orElse(null);

        String stateCode = stateRepository.findByStateNameIgnoreCase(normalizeStateName(request.getState()))
                .map(States::getStateCode)
                .orElseThrow(() -> new RuntimeException("State not found"));

        String terminalId;
        String merchantId = "";
        terminalId = geMerchantAcct.map(MerchantData -> sequenceGenerator.nextValue(sequenceGenerator.getValueAfter2NEP(MerchantData.getTerminalId()))).orElseGet(() -> sequenceGenerator.nextValue(sequenceGenerator.getValueAfter2NEP(getVirtualAcct.get().getTerminalId())));
        merchantId = geMerchantAcct.map(merchantData -> terminalId + sequenceGenerator.incrementString(sequenceGenerator.getValueAfter2NEP(merchantData.getMerchantId()))).orElseGet(() -> terminalId + sequenceGenerator.incrementString(sequenceGenerator.getValueAfter2NEP("2NEP00000000001")));

        MerchantData merchant = MerchantData.builder()
                .uploaded(false)
                .merchantId("2NEP" + merchantId)
                .merchantName(request.getDisplayName())
                .contactName(request.getOfficeName())
                .contactTitle(request.getTitle())
                .mobilePhone(request.getMobileNo())
                .email(request.getEmailAddress())
                .merchantPhysicalAddr(response.getKyc().getCorporateCustomerAddress().getAddress())
                .terminalId("2NEP"+terminalId)
                .businessAcct(request.getBusinessAcct())
                .bankCode(getBanks.get().getBankCode())
                .bankAccNo(pos_settlement_bank_number)
                .businessOccupationCode("5411")
                .merchantCategoryCode("5999")
                .stateCode(stateCode)
                .status("Pending")
                .gpsLongitude(request.getGpsLongitude())
                .gpsLatitude(request.getGpsLongitude())
                .dateOfIncorporation(request.getDateOfIncorporation())
                .officeName(request.getOfficeName())
                .rcNumber(request.getRcNumber())
                .officeAddress(request.getOfficeAddress())
                .visaAcquirerIdNumber(pos_visa_acquirer_id_number)
                .verveAcquirerIdNumber(pos_verve_acquirer_id_number)
                .mastercardAcquirerIdNumber(pos_mastercard_acquirer_id_number)
                .terminalOwnerCode("507")
                .merchantAccountName(getBanks.get().getBankName())
                .ptspCode("Interswitch")
                .merchantAcctDomicileBankCode(getBanks.get().getBankCode())
                .terminalGroupId("2NEP")
                .bvn("")
                .tin(request.getTin())
                .merchantAddressLgaCode(merchantLgaCode)
                .agentCode("AG001")
                .terminalAddressLgaCode(terminalLgaCode)
                .terminalAddress(request.getTerminalAddress())
                .merchantAcquirerId("ACQ001")
                .terminalModelDescription("PAX S90")
                .appName("NeptunePay")
                .appVersion("1.0.0")
                .terminalType("POS")
                .createdAt(ZonedDateTime.now().toString())
                .updatedAt(ZonedDateTime.now().toString())
                .build();

        merchantRepository.save(merchant);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "Business details for POS created successfully", null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-pos-request-businesses")
    public ResponseEntity<ResponseSchema<?>> downloadableTerminalCount() {
        List<MerchantData> merchant = merchantRepository.findByUploadedFalse();

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "downloadable merchant count is " + merchant.size(), merchant, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get-business-pos")
    public ResponseEntity<ResponseSchema<?>> getCustomerPOS(@RequestParam String businessAcct) {
        List<MerchantData> merchant = merchantRepository.findMerchantByBusinessAcct(businessAcct);
        List<VirtualAccountModel> virtualAccountModel = virtualAccountRepository.findAllByBusinessWalletId(businessAcct);

        if(merchant.isEmpty()){
            ResponseSchema<?> responseSchema = new ResponseSchema<>(404, "No POS registered associated with this account", "", "", ZonedDateTime.now(), false);
            return new ResponseEntity<>(responseSchema, HttpStatus.NOT_FOUND);
        }

        Map<String, String> accountData = new HashMap<>();

        for (VirtualAccountModel account : virtualAccountModel) {
            if (account.getVirtual_account_number() != null) {

                accountData.put(
                        account.getParent_id(), // key
                        account.getVirtual_account_number() // value
                );
            }
        }

        BulkBalanceResponse response = transactionService.getBulkBalance(accountData, "savings", "key");

        List<GetPOSResponse> data = getGetPOSResponses(merchant, virtualAccountModel, response);

        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "You have requested for " + merchant.size(), data, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    private static List<GetPOSResponse> getGetPOSResponses(
            List<MerchantData> merchants,
            List<VirtualAccountModel> virtualAccounts,
            BulkBalanceResponse response
    ) {
        List<GetPOSResponse> data = new ArrayList<>();

        // Build lookup map: terminalId → virtual account number
        Map<String, String> accountMap = new HashMap<>();

        for (VirtualAccountModel v : virtualAccounts) {
            if (v.getTerminalId() != null && v.getVirtual_account_number() != null) {
                accountMap.put(v.getTerminalId(), v.getVirtual_account_number());
            }
        }

        for (MerchantData m : merchants) {
            GetPOSResponse posResponse = new GetPOSResponse();
            String posAcct = accountMap.getOrDefault(m.getTerminalId(), "");

            double balance = response.getBalanceResponseList()
                    .stream()
                    .filter(b -> posAcct.equals(b.getAccountNumber()))
                    .map(BalanceResponse::getEffectiveBalance) // ✅ FIX
                    .findFirst()
                    .orElse(0.0);

            posResponse.setTerminalID(m.getTerminalId());
            posResponse.setApplicationStatus(m.getStatus());
            posResponse.setStatus(m.getStatus());
            posResponse.setPosLongitude(m.getGpsLongitude());
            posResponse.setPosLatitude(m.getGpsLatitude());
            posResponse.setBalance(String.valueOf(balance));
            // Match account using terminalId
            posResponse.setPosAcctNum(posAcct);

            data.add(posResponse);
        }

        return data;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/download-terminal-sheet")
    public ResponseEntity<?> downloadTerminalSheet(@RequestParam String type) {

        List<MerchantData> merchant =
                merchantRepository.findByUploadedFalse();

        if (merchant.isEmpty()) {

            ResponseSchema<?> responseSchema =
                    new ResponseSchema<>(
                            404,
                            "No merchant data to download at the moment",
                            "",
                            "",
                            ZonedDateTime.now(),
                            false
                    );

            return new ResponseEntity<>(
                    responseSchema,
                    HttpStatus.NOT_FOUND
            );
        }

        try {

            byte[] file =
                    merchantExcelService.generateExcel(merchant);

            return ResponseEntity.ok()
                    .header("Content-Disposition",
                            "attachment; filename=merchant_upload.xlsx")
                    .header("Content-Type",
                            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                    .body(file);

        } catch (Exception e) {

            ResponseSchema<?> responseSchema =
                    new ResponseSchema<>(
                            500,
                            "Failed to generate file",
                            "",
                            e.getMessage(),
                            ZonedDateTime.now(),
                            false
                    );

            return new ResponseEntity<>(
                    responseSchema,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    private String normalizeStateName(String value) {
        return value
                .trim()
                .replaceAll("(?i)state", "")   // remove STATE / state
                .replaceAll("\\s+", " ")       // fix spaces
                .trim();
    }
}
