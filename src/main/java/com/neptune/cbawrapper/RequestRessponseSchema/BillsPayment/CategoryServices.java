package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

import java.util.List;

public class CategoryServices {
    private String success;
    private String message;
    private String status;
    private List<DataServices> data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataServices> getData() {
        return data;
    }

    public void setData(List<DataServices> data) {
        this.data = data;
    }

    public CategoryServices() {
    }
}
