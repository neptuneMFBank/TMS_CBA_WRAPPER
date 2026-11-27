package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerResponse {
    private Integer officeId;
    private Integer clientId;
    private Integer resourceId;
    // The client's default savings account, when one was opened with it. resourceId is the client ID.
    private Integer savingsId;

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getSavingsId() {
        return savingsId;
    }

    public void setSavingsId(Integer savingsId) {
        this.savingsId = savingsId;
    }
}
