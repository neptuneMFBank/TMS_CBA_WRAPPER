package com.neptune.cbawrapper.RequestRessponseSchema;

import java.util.List;

public class EasyPayListResponseData {
    private List<EasyPayRequestData> easyPayRequestData;
    private Long totalItems;
    private Long totalPages;
    private Long currentPages;

    public List<EasyPayRequestData> getEasyPayRequestData() {
        return easyPayRequestData;
    }

    public void setEasyPayRequestData(List<EasyPayRequestData> easyPayRequestData) {
        this.easyPayRequestData = easyPayRequestData;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(Long currentPages) {
        this.currentPages = currentPages;
    }

    public EasyPayListResponseData() {
    }
}
