package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class PlatformChargesRequest {

    private String id;
    private String platformName;
    private String chargeType;
    private Double amount;
    private Double threshold;
    private Double businessValue;
    private Double total;

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
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

    public Double getBusinessValue() {
        return businessValue;
    }

    public void setBusinessValue(Double businessValue) {
        this.businessValue = businessValue;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlatformChargesRequest{" +
                "id='" + id + '\'' +
                ", platformName='" + platformName + '\'' +
                ", chargeType='" + chargeType + '\'' +
                ", amount=" + amount +
                ", threshold=" + threshold +
                ", businessValue=" + businessValue +
                ", total=" + total +
                '}';
    }
}
