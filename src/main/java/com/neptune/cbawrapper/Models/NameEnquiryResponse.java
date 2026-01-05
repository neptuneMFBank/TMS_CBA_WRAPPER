package com.neptune.cbawrapper.Models;

public class NameEnquiryResponse {

    private String message;
    private NameEnquiryData data;
    private boolean success;
    private String timezone;

    // No-args constructor
    public NameEnquiryResponse() {
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NameEnquiryData getData() {
        return data;
    }

    public void setData(NameEnquiryData data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
