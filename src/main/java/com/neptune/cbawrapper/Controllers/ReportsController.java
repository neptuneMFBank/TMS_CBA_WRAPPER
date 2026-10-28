package com.neptune.cbawrapper.Controllers;

import com.neptune.cba.transaction.report.PosTransactionSummary;
import com.neptune.cba.transaction.report.PosTransactionSummaryRequest;
import com.neptune.cba.transaction.report.PosTransactionSummaryResponse;
import com.neptune.cbawrapper.Exception.ErrorLoggingException;
import com.neptune.cbawrapper.Models.*;
import com.neptune.cbawrapper.Repository.*;
import com.neptune.cbawrapper.RequestRessponseSchema.Reports.DetailedReportRow;
import com.neptune.cbawrapper.RequestRessponseSchema.Reports.ReportResponse;
import com.neptune.cbawrapper.RequestRessponseSchema.Reports.RsmSummaryReportRow;
import com.neptune.cbawrapper.RequestRessponseSchema.ResponseSchema;
import com.neptune.cbawrapper.RequestRessponseSchema.TransactionRequestSchema;
import com.neptune.cbawrapper.Services.Reports;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/reports")
@RequiredArgsConstructor
public class ReportsController {

    private static final String WITHDRAWAL = "WITHDRAWAL";
    private static final String TRANSFER = "TRANSFER";
    private static final String SUCCESSFUL = "SUCCESSFUL";
    private static final String FAILED = "FAILED";
    private static final String REVERSED = "REVERSED";
    private static final Logger log = LoggerFactory.getLogger(ReportsController.class);

    private final Reports reports;
    private final PosTransactionRepository posTransactionRepository;
    private final VirtualAccountRepository virtualAccountRepository;
    private final ErrorLoggingException errorLoggingException;
    private final CustomersRepository customersRepository;
    private final MerchantRepository merchantRepository;
    private final EasypayTransactionsRepository easypayTransactionsRepository;
    private final CbaTransactionRequestsRepository cbaTransactionRequestsRepository;

    // ==============================
    // RSM Summary Report - one row per terminal
    // period: today | last7days | last30days | custom (requires startDate & endDate, yyyy-MM-dd)
    // ==============================
    @CrossOrigin(origins = "*")
    @GetMapping("/rsm-summary")
    public ResponseEntity<ResponseSchema<?>> rsmSummaryReport(@RequestParam(defaultValue = "today") String period,
                                                              @RequestParam(required = false) String startDate,
                                                              @RequestParam(required = false) String endDate,
                                                              @RequestParam(required = false) String rsm) {
        LocalDate[] range;
        try {
            range = resolveDateRange(period, startDate, endDate);
        } catch (IllegalArgumentException e) {
            return error(400, e.getMessage());
        }

        try {
            List<TerminalInfo> terminals = loadTerminals(null, rsm);
            log.info("terminals {}", terminals);
            if (terminals.isEmpty()) {
                return ok(new ReportResponse<>(range[0].toString(), range[1].toString(), Map.of(), List.of()));
            }
            log.info("summaries start ==============");
            Map<String, PosTransactionSummary> summaries = fetchSummaries(terminals, range);
            log.info("summaries {}", summaries);
            if (summaries == null) {
                return error(500, "unable to fetch transaction summary from core");
            }

            List<String> terminalIds = terminals.stream().map(t -> t.terminalId).toList();
            log.info("terminalIds {}", terminalIds);
            Map<String, String> terminalStatuses = virtualAccountRepository.findByTerminalIdIn(terminalIds).stream()
                    .filter(p -> p.getTerminalId() != null)
                    .collect(Collectors.toMap(VirtualAccountModel::getTerminalId, p -> StringUtils.defaultString(p.getStatus()), (a, b) -> a));

            Map<String, List<DetailedReportRow>> transfersByTerminal = buildTransferRows(terminals, range).stream()
                    .filter(r -> !FAILED.equals(r.getTransactionStatus()))
                    .collect(Collectors.groupingBy(DetailedReportRow::getTerminalId));

            Map<String, List<DetailedReportRow>> withdrawalsByTerminal = buildWithdrawalRows(terminals, range).stream()
                    .filter(r -> SUCCESSFUL.equals(r.getTransactionStatus()))
                    .collect(Collectors.groupingBy(DetailedReportRow::getTerminalId));

            String dateTime = range[0] + " to " + range[1];
            List<RsmSummaryReportRow> rows = new ArrayList<>();
            for (TerminalInfo terminal : terminals) {
                PosTransactionSummary summary = summaries.getOrDefault(terminal.accountNumber, PosTransactionSummary.getDefaultInstance());
                List<DetailedReportRow> transfers = transfersByTerminal.getOrDefault(terminal.terminalId, List.of());
                List<DetailedReportRow> withdrawals = withdrawalsByTerminal.getOrDefault(terminal.terminalId, List.of());

                RsmSummaryReportRow row = new RsmSummaryReportRow();
                row.setDateTime(dateTime);
                row.setCustomerName(terminal.customerName);
                row.setTerminalId(terminal.terminalId);
                row.setAccountNumber(terminal.accountNumber);
                row.setLocation(terminal.location);
                row.setTerminalStatus(terminalStatuses.getOrDefault(terminal.terminalId, ""));
                row.setCardTransactionCount(withdrawals.size());
                row.setTotalCardTransaction(withdrawals.stream().mapToDouble(DetailedReportRow::getAmount).sum());
                row.setCardCharges(summary.getTotalCardCharge());
                row.setTransferCount(transfers.size());
                row.setTotalTransfer(transfers.stream().mapToDouble(DetailedReportRow::getAmount).sum());
                row.setTransferCharges(summary.getTotalOutwardCharge());
                row.setRsm(terminal.rsm);
                rows.add(row);
            }

            Map<String, Object> totals = new LinkedHashMap<>();
            totals.put("terminals", rows.size());
            totals.put("totalCardTransaction", rows.stream().mapToDouble(RsmSummaryReportRow::getTotalCardTransaction).sum());
            totals.put("cardCharges", rows.stream().mapToDouble(RsmSummaryReportRow::getCardCharges).sum());
            totals.put("totalTransfer", rows.stream().mapToDouble(RsmSummaryReportRow::getTotalTransfer).sum());
            totals.put("transferCharges", rows.stream().mapToDouble(RsmSummaryReportRow::getTransferCharges).sum());

            return ok(new ReportResponse<>(range[0].toString(), range[1].toString(), totals, rows));
        } catch (Exception e) {
            errorLoggingException.logError("RSM_SUMMARY_REPORT", String.valueOf(e.getCause()), e.getMessage());
            return error(500, e.getMessage());
        }
    }

    // ==============================
    // Detailed Report - one row per withdrawal / transfer
    // Can be spooled by terminalId, rsm and date
    // ==============================
    @CrossOrigin(origins = "*")
    @GetMapping("/detailed")
    public ResponseEntity<ResponseSchema<?>> detailedReport(@RequestParam(defaultValue = "today") String period,
                                                            @RequestParam(required = false) String startDate,
                                                            @RequestParam(required = false) String endDate,
                                                            @RequestParam(required = false) String terminalId,
                                                            @RequestParam(required = false) String rsm,
                                                            @RequestParam(required = false) String transactionType) {
        LocalDate[] range;
        try {
            range = resolveDateRange(period, startDate, endDate);
        } catch (IllegalArgumentException e) {
            return error(400, e.getMessage());
        }

        try {
            List<TerminalInfo> terminals = loadTerminals(terminalId, rsm);
            if (terminals.isEmpty()) {
                return ok(new ReportResponse<>(range[0].toString(), range[1].toString(), Map.of(), List.of()));
            }

            List<DetailedReportRow> rows = new ArrayList<>();
            if (transactionType == null || WITHDRAWAL.equalsIgnoreCase(transactionType)) {
                rows.addAll(buildWithdrawalRows(terminals, range));
            }
            if (transactionType == null || TRANSFER.equalsIgnoreCase(transactionType)) {
                rows.addAll(buildTransferRows(terminals, range));
            }
            rows.sort(Comparator.comparing(DetailedReportRow::getDate, Comparator.nullsLast(Comparator.reverseOrder())));
            for (int i = 0; i < rows.size(); i++) {
                rows.get(i).setSn(i + 1);
            }

            Map<String, Object> totals = new LinkedHashMap<>();
            totals.put("transactions", rows.size());
            totals.put("totalAmount", rows.stream().mapToDouble(DetailedReportRow::getAmount).sum());
            totals.put("byStatus", rows.stream().collect(Collectors.groupingBy(DetailedReportRow::getTransactionStatus, LinkedHashMap::new, Collectors.counting())));

            // core summary per account, alongside the locally logged rows
            Map<String, PosTransactionSummary> summaries = fetchSummaries(terminals, range);
            if (summaries != null) {
                totals.put("coreCardTransactionCount", summaries.values().stream().mapToLong(PosTransactionSummary::getTransactionCount).sum());
                totals.put("coreTotalCardTransaction", summaries.values().stream().mapToDouble(PosTransactionSummary::getTotalAmount).sum());
                totals.put("coreCardCharges", summaries.values().stream().mapToDouble(PosTransactionSummary::getTotalCardCharge).sum());
                totals.put("coreTransferCharges", summaries.values().stream().mapToDouble(PosTransactionSummary::getTotalOutwardCharge).sum());
            }

            return ok(new ReportResponse<>(range[0].toString(), range[1].toString(), totals, rows));
        } catch (Exception e) {
            errorLoggingException.logError("DETAILED_REPORT", String.valueOf(e.getCause()), e.getMessage());
            return error(500, e.getMessage());
        }
    }

    // Card withdrawals: successful ones are logged to cba_transaction_requests by creditDebitAcct,
    // failed / reversed card attempts only exist in pos_transaction_requests.
    private List<DetailedReportRow> buildWithdrawalRows(List<TerminalInfo> terminals, LocalDate[] range) {
        Map<String, TerminalInfo> byTerminal = terminals.stream().collect(Collectors.toMap(t -> t.terminalId, t -> t, (a, b) -> a));
        List<String> terminalIds = new ArrayList<>(byTerminal.keySet());

        List<TransactionRequestSchema> unsuccessful =
                posTransactionRepository.findUnsuccessfulTransactions(
                        terminalIds,
                        range[0].toString(),
                        range[1].plusDays(1).toString()
                );

        Set<String> reversedPosRefs = unsuccessful.stream()
                .filter(t -> Boolean.TRUE.equals(t.getReversal()))
                .map(TransactionRequestSchema::getTransactionReference)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        List<TransactionDrCr> withdrawals =
                cbaTransactionRequestsRepository.findCreditTransactionsByTerminalIdsAndDateRange(
                        terminalIds,
                        range[0].toString(),
                        range[1].plusDays(1).toString()
                );

        List<DetailedReportRow> rows = new ArrayList<>();
        Set<String> reportedPosRefs = new HashSet<>();
        for (TransactionDrCr w : withdrawals) {
            TerminalInfo terminal = byTerminal.get(w.getTerminalId());
            boolean reversed = w.getPosRef() != null && reversedPosRefs.contains(w.getPosRef());
            if (w.getPosRef() != null) {
                reportedPosRefs.add(w.getPosRef());
            }
            rows.add(row(terminal, w.getTerminalId(), w.getAmount(), w.getCreated_at(), w.getTransactionreference(),
                    w.getNarration(), WITHDRAWAL, reversed ? REVERSED : SUCCESSFUL));
        }
        for (TransactionRequestSchema t : unsuccessful) {
            if (t.getTransactionReference() != null && reportedPosRefs.contains(t.getTransactionReference())) {
                continue;
            }
            TerminalInfo terminal = byTerminal.get(t.getTerminalId());
            rows.add(row(terminal, t.getTerminalId(), t.getAmount(), t.getCreated_at(), t.getReference(),
                    t.getNarration(), WITHDRAWAL, Boolean.TRUE.equals(t.getReversal()) ? REVERSED : FAILED));
        }
        return rows;
    }

    // Transfers are logged to pos_transaction_requests with an intra_ / inter_ reference.
    // Outward (inter) status comes from easy_pay_transaction; intra transfers keep the logged status.
    private List<DetailedReportRow> buildTransferRows(List<TerminalInfo> terminals, LocalDate[] range) {
        Map<String, TerminalInfo> byTerminal = terminals.stream().collect(Collectors.toMap(t -> t.terminalId, t -> t, (a, b) -> a));

        List<TransactionRequestSchema> transfers =
                posTransactionRepository.findTransfersByTerminalIdsAndDateRange(
                        byTerminal.keySet(),
                        range[0].toString(),
                        range[1].plusDays(1).toString()
                );

        List<String> interRefs = transfers.stream()
                .map(TransactionRequestSchema::getReference)
                .filter(r -> r.startsWith("inter_"))
                .toList();

        Map<String, EasypayTransactionsModel> outward = easypayTransactionsRepository
                .findByPaymentReferenceIn(interRefs)
                .stream()
                .collect(Collectors.toMap(
                        EasypayTransactionsModel::getPaymentReference,
                        e -> e,
                        (a, b) -> a
                ));

        List<DetailedReportRow> rows = new ArrayList<>();
        for (TransactionRequestSchema t : transfers) {
            String status;
            String narration = t.getNarration();
            if (t.getReference().startsWith("inter_")) {
                EasypayTransactionsModel easypay = outward.get(t.getReference());
                status = easypay != null && "00".equals(easypay.getCode()) ? SUCCESSFUL : FAILED;
                if (easypay != null && easypay.getOriginatorNarration() != null) {
                    narration = easypay.getOriginatorNarration();
                }
            } else {
                status = StringUtils.defaultIfBlank(t.getStatus(), "PENDING").toUpperCase();
            }
            rows.add(row(byTerminal.get(t.getTerminalId()), t.getTerminalId(), t.getAmount(), t.getCreated_at(),
                    t.getReference(), narration, TRANSFER, status));
        }
        return rows;
    }

    private Map<String, PosTransactionSummary> fetchSummaries(List<TerminalInfo> terminals, LocalDate[] range) {
        PosTransactionSummaryRequest request = PosTransactionSummaryRequest.newBuilder()
                .addAllAccountNumbers(terminals.stream().map(t -> t.accountNumber).filter(Objects::nonNull).distinct().toList())
                .setStartDate(range[0].toString())
                .setEndDate(range[1].toString())
                .build();
        PosTransactionSummaryResponse response = reports.getTransactionReports(request);
        if (response == null) {
            return null;
        }
        return response.getSummariesList().stream()
                .collect(Collectors.toMap(PosTransactionSummary::getAccountNumber, s -> s, (a, b) -> a));
    }

    // Terminals come from virtual_accounts; the RSM and location sit on the parent business customer.
    private List<TerminalInfo> loadTerminals(String terminalId, String rsm) {
        List<VirtualAccountModel> accounts = StringUtils.isNotBlank(terminalId)
                ? virtualAccountRepository.findByTerminalIdOrderByAccountNameAsc(terminalId)
                : virtualAccountRepository.findByTerminalIdNotNullOrEmptyOrderByAccountNameAsc();

        List<String> parentAccounts = accounts.stream()
                .map(VirtualAccountModel::getParent_account)
                .filter(Objects::nonNull)
                .distinct()
                .toList();

        List<String> terminalIDs = accounts.stream()
                .map(VirtualAccountModel::getTerminalId)
                .filter(Objects::nonNull)
                .distinct()
                .toList();

        log.info("parentAccounts {}", parentAccounts);

        Map<String, CustomersModel> customers = customersRepository
                .findByAccountNumIn(parentAccounts)
                .stream()
                .collect(Collectors.toMap(
                        CustomersModel::getAccount_num,
                        c -> c,
                        (a, b) -> a
                ));

        Map<String, MerchantData> merchantDataMap = merchantRepository
                .findByTerminalIdIn(terminalIDs)
                .stream()
                .collect(Collectors.toMap(
                        MerchantData::getTerminalId,
                        c -> c,
                        (a, b) -> a
                ));

        log.info("merchantDataMap {}", merchantDataMap);

        List<TerminalInfo> terminals = new ArrayList<>();
        for (VirtualAccountModel account : accounts) {
            CustomersModel customer = customers.get(account.getParent_account());
            MerchantData merchantData = merchantDataMap.get(account.getTerminalId());
            if (StringUtils.isNotBlank(rsm) && !rsm.equalsIgnoreCase(account.getRsm())) {
                continue;
            }
            TerminalInfo info = new TerminalInfo();
            info.terminalId = account.getTerminalId();
            info.accountNumber = account.getVirtual_account_number();
            info.customerName = account.getAccount_name();
            info.rsm = account.getRsm();
            if(merchantData != null) {
                info.location = merchantData.getMerchantPhysicalAddr();
            }else {
                info.location = customer == null ? "" : StringUtils.defaultIfBlank(customer.getCompany_address(), StringUtils.defaultString(customer.getAddress()));
            }
            terminals.add(info);
        }
        return terminals;
    }

    private LocalDate[] resolveDateRange(String period, String startDate, String endDate) {
        LocalDate today = LocalDate.now();
        switch (period.toLowerCase()) {
            case "today":
                return new LocalDate[]{today, today};
            case "last7days":
                return new LocalDate[]{today.minusDays(6), today};
            case "last30days":
                return new LocalDate[]{today.minusDays(29), today};
            case "custom":
                if (StringUtils.isAnyBlank(startDate, endDate)) {
                    throw new IllegalArgumentException("startDate and endDate are required for a custom period");
                }
                try {
                    LocalDate start = LocalDate.parse(startDate);
                    LocalDate end = LocalDate.parse(endDate);
                    if (end.isBefore(start)) {
                        throw new IllegalArgumentException("endDate cannot be before startDate");
                    }
                    return new LocalDate[]{start, end};
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("dates must be in yyyy-MM-dd format");
                }
            default:
                throw new IllegalArgumentException("period must be one of today, last7days, last30days, custom");
        }
    }

    private DetailedReportRow row(TerminalInfo terminal, String terminalId, Double amount, String date, String reference,
                                  String narration, String type, String status) {
        DetailedReportRow row = new DetailedReportRow();
        row.setCustomerName(terminal != null ? terminal.customerName : "");
        row.setRsm(terminal != null ? terminal.rsm : "");
        row.setTerminalId(terminalId);
        row.setAmount(amount != null ? amount : 0);
        row.setDate(date);
        row.setReference(reference);
        row.setNarration(narration);
        row.setTransactionType(type);
        row.setTransactionStatus(status);
        return row;
    }

    private ResponseEntity<ResponseSchema<?>> ok(Object data) {
        ResponseSchema<?> responseSchema = new ResponseSchema<>(200, "report generated successfully", data, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.OK);
    }

    private ResponseEntity<ResponseSchema<?>> error(int status, String message) {
        ResponseSchema<?> responseSchema = new ResponseSchema<>(status, message, null, "", ZonedDateTime.now(), false);
        return new ResponseEntity<>(responseSchema, HttpStatus.valueOf(status));
    }

    private static class TerminalInfo {
        String terminalId;
        String accountNumber;
        String customerName;
        String location;
        String rsm;

        @Override
        public String toString() {
            return "TerminalInfo{" +
                    "terminalId='" + terminalId + '\'' +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", customerName='" + customerName + '\'' +
                    ", location='" + location + '\'' +
                    ", rsm='" + rsm + '\'' +
                    '}';
        }
    }
}
