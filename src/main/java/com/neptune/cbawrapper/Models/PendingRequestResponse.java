package com.neptune.cbawrapper.Models;

import java.util.List;

public class PendingRequestResponse {

    private Integer totalFilteredRecords;
    private List<CustomersModel> pageItems;

    public Integer getTotalFilteredRecords() {
        return totalFilteredRecords;
    }

    public void setTotalFilteredRecords(Integer totalFilteredRecords) {
        this.totalFilteredRecords = totalFilteredRecords;
    }

    public List<CustomersModel> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<CustomersModel> pageItems) {
        this.pageItems = pageItems;
    }
}
