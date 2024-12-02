package com.neptune.cbawrapper.RequestRessponseSchema;

public class UpdateTransactionResponseSchema {
    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "UpdateTransactionResponseSchema{" +
                "resourceId='" + resourceId + '\'' +
                '}';
    }
}
