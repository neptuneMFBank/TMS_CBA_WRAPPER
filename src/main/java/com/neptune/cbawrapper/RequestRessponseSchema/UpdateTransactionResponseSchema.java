package com.neptune.cbawrapper.RequestRessponseSchema;

public class UpdateTransactionResponseSchema {
    private Integer resourceId;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "UpdateTransactionResponseSchema{" +
                "resourceId='" + resourceId + '\'' +
                '}';
    }
}
