package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

import java.util.List;

public class ResponseCustomerData {
    private List<Customer> Customers;
    private String ResponseCode;
    private String ResponseCodeGrouping;

    public List<Customer> getCustomers() {
        return Customers;
    }

    public void setCustomers(List<Customer> customers) {
        Customers = customers;
    }

    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseCodeGrouping() {
        return ResponseCodeGrouping;
    }

    public void setResponseCodeGrouping(String responseCodeGrouping) {
        ResponseCodeGrouping = responseCodeGrouping;
    }
}
