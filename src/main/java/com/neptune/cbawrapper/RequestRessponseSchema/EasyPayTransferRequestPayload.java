package com.neptune.cbawrapper.RequestRessponseSchema;

public class EasyPayTransferRequestPayload {
    private String narration;
    private Double amount;
    private String unique_id;

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public EasyPayTransferRequestPayload() {
    }
}
