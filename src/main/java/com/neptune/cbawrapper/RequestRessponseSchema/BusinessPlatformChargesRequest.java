package com.neptune.cbawrapper.RequestRessponseSchema;

public class BusinessPlatformChargesRequest {


    private String businessId;
    private String businessWalletId;
    private String chargeType;
    private Double amount;
    private Double threshold;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessWalletId() {
        return businessWalletId;
    }

    public void setBusinessWalletId(String businessWalletId) {
        this.businessWalletId = businessWalletId;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }
}
