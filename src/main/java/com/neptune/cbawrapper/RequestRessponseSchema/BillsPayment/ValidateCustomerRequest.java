package com.neptune.cbawrapper.RequestRessponseSchema.BillsPayment;

public class ValidateCustomerRequest {
    private String customerId;
    private String productId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ValidateCustomerRequest() {
    }
}
