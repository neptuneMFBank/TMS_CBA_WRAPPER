package com.neptune.cbawrapper.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neptune.cbawrapper.Models.MerchantData;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantExcelService {

    public byte[] generateExcel(List<MerchantData> merchants) throws Exception {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Merchant Upload");

        // Header Style
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        // Headers
        String[] headers = {
                "merchantId", "merchantName", "contactName", "contactTitle",
                "mobilePhone", "email", "merchantPhysicalAddr",
                "terminalId", "bankCode", "bankAccNo",
                "businessOccupationCode", "merchantCategoryCode",
                "stateCode", "visaAcquirerIdNumber",
                "verveAcquirerIdNumber", "mastercardAcquirerIdNumber",
                "terminalOwnerCode", "merchantAccountName",
                "ptspCode", "merchantAcctDomicileBankCode",
                "terminalGroupId", "bvn", "tin",
                "merchantAddressLgaCode", "agentCode", "gpsInfo",
                "terminalAddressLgaCode", "terminalAddress",
                "merchantAcquirerId", "terminalModelDescription",
                "appName", "appVersion", "terminalType"
        };

        // Header Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // Data Rows
        int rowNum = 1;

        for (MerchantData m : merchants) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(m.getMerchantId());
            row.createCell(1).setCellValue(m.getMerchantName());
            row.createCell(2).setCellValue(m.getContactName());
            row.createCell(3).setCellValue(m.getContactTitle());
            row.createCell(4).setCellValue(m.getMobilePhone());
            row.createCell(5).setCellValue(m.getEmail());
            row.createCell(6).setCellValue(m.getMerchantPhysicalAddr());
            row.createCell(7).setCellValue(m.getTerminalId());
            row.createCell(8).setCellValue(m.getBankCode());
            row.createCell(9).setCellValue(m.getBankAccNo());
            row.createCell(10).setCellValue(m.getBusinessOccupationCode());
            row.createCell(11).setCellValue(m.getMerchantCategoryCode());
            row.createCell(12).setCellValue(m.getStateCode());
            row.createCell(13).setCellValue(m.getVisaAcquirerIdNumber());
            row.createCell(14).setCellValue(m.getVerveAcquirerIdNumber());
            row.createCell(15).setCellValue(m.getMastercardAcquirerIdNumber());
            row.createCell(16).setCellValue(m.getTerminalOwnerCode());
            row.createCell(17).setCellValue(m.getMerchantAccountName());
            row.createCell(18).setCellValue(m.getPtspCode());
            row.createCell(19).setCellValue(m.getMerchantAcctDomicileBankCode());
            row.createCell(20).setCellValue(m.getTerminalGroupId());
            row.createCell(21).setCellValue(m.getBvn());
            row.createCell(22).setCellValue(m.getTin());
            row.createCell(23).setCellValue(m.getMerchantAddressLgaCode());
            row.createCell(24).setCellValue(m.getAgentCode());
            row.createCell(25).setCellValue(m.getGpsInfo());
            row.createCell(26).setCellValue(m.getTerminalAddressLgaCode());
            row.createCell(27).setCellValue(m.getTerminalAddress());
            row.createCell(28).setCellValue(m.getMerchantAcquirerId());
            row.createCell(29).setCellValue(m.getTerminalModelDescription());
            row.createCell(30).setCellValue(m.getAppName());
            row.createCell(31).setCellValue(m.getAppVersion());
            row.createCell(32).setCellValue(m.getTerminalType());
        }

        // Auto size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }

    public byte[] convertJsonToExcel(String jsonString) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        List<MerchantData> merchants = objectMapper.readValue(
                jsonString,
                objectMapper.getTypeFactory().constructCollectionType(List.class, MerchantData.class)
        );

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Merchant Upload");

        // ── Header Style ──────────────────────────────────────────────────────────
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        // ── Headers (exact same order as generateExcel) ───────────────────────────
        String[] headers = {
                "merchantId", "merchantName", "contactName", "contactTitle",
                "mobilePhone", "email", "merchantPhysicalAddr",
                "terminalId", "bankCode", "bankAccNo",
                "businessOccupationCode", "merchantCategoryCode",
                "stateCode", "visaAcquirerIdNumber",
                "verveAcquirerIdNumber", "mastercardAcquirerIdNumber",
                "terminalOwnerCode", "merchantAccountName",
                "ptspCode", "merchantAcctDomicileBankCode",
                "terminalGroupId", "bvn", "tin",
                "merchantAddressLgaCode", "agentCode", "gpsInfo",
                "terminalAddressLgaCode", "terminalAddress",
                "merchantAcquirerId", "terminalModelDescription",
                "appName", "appVersion", "terminalType"
        };

        // ── Header Row ────────────────────────────────────────────────────────────
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        // ── Text Cell Style (prevents numeric fields losing leading zeros) ─────────
        // e.g. BVN "08031234567" must not be stored as a number
        CellStyle textStyle = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        textStyle.setDataFormat(dataFormat.getFormat("@"));

        // ── Data Rows ─────────────────────────────────────────────────────────────
        int rowNum = 1;
        for (MerchantData m : merchants) {
            Row row = sheet.createRow(rowNum++);

            createTextCell(row, 0,  m.getMerchantId(),                  textStyle);
            createTextCell(row, 1,  m.getMerchantName(),                 textStyle);
            createTextCell(row, 2,  m.getContactName(),                  textStyle);
            createTextCell(row, 3,  m.getContactTitle(),                 textStyle);
            createTextCell(row, 4,  m.getMobilePhone(),                  textStyle);
            createTextCell(row, 5,  m.getEmail(),                        textStyle);
            createTextCell(row, 6,  m.getMerchantPhysicalAddr(),         textStyle);
            createTextCell(row, 7,  m.getTerminalId(),                   textStyle);
            createTextCell(row, 8,  m.getBankCode(),                     textStyle);
            createTextCell(row, 9,  m.getBankAccNo(),                    textStyle);
            createTextCell(row, 10, m.getBusinessOccupationCode(),       textStyle);
            createTextCell(row, 11, m.getMerchantCategoryCode(),         textStyle);
            createTextCell(row, 12, m.getStateCode(),                    textStyle);
            createTextCell(row, 13, m.getVisaAcquirerIdNumber(),         textStyle);
            createTextCell(row, 14, m.getVerveAcquirerIdNumber(),        textStyle);
            createTextCell(row, 15, m.getMastercardAcquirerIdNumber(),   textStyle);
            createTextCell(row, 16, m.getTerminalOwnerCode(),            textStyle);
            createTextCell(row, 17, m.getMerchantAccountName(),          textStyle);
            createTextCell(row, 18, m.getPtspCode(),                     textStyle);
            createTextCell(row, 19, m.getMerchantAcctDomicileBankCode(), textStyle);
            createTextCell(row, 20, m.getTerminalGroupId(),              textStyle);
            createTextCell(row, 21, m.getBvn(),                          textStyle);
            createTextCell(row, 22, m.getTin(),                          textStyle);
            createTextCell(row, 23, m.getMerchantAddressLgaCode(),       textStyle);
            createTextCell(row, 24, m.getAgentCode(),                    textStyle);
            createTextCell(row, 25, m.getGpsInfo(),                      textStyle);
            createTextCell(row, 26, m.getTerminalAddressLgaCode(),       textStyle);
            createTextCell(row, 27, m.getTerminalAddress(),              textStyle);
            createTextCell(row, 28, m.getMerchantAcquirerId(),           textStyle);
            createTextCell(row, 29, m.getTerminalModelDescription(),     textStyle);
            createTextCell(row, 30, m.getAppName(),                      textStyle);
            createTextCell(row, 31, m.getAppVersion(),                   textStyle);
            createTextCell(row, 32, m.getTerminalType(),                 textStyle);
        }

        // ── Auto-size all columns ─────────────────────────────────────────────────
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // ── Write to bytes ────────────────────────────────────────────────────────
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        return out.toByteArray();
    }

// ── Helper ────────────────────────────────────────────────────────────────────
    /**
     * Creates a cell at the given column, sets its value as a String,
     * and applies the text format style so Excel never auto-converts
     * numeric-looking values (BVN, account numbers, phone numbers) to numbers.
     * Null-safe — writes an empty string if the value is null.
     */
    private void createTextCell(Row row, int col, String value, CellStyle textStyle) {
        Cell cell = row.createCell(col);
        cell.setCellStyle(textStyle);
        cell.setCellValue(value != null ? value : "");
    }

}
