package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

@Data
public class TerminalProfile {
    private String id;
    private String terminalId;
    private String parentEntityName;
    private String entityType;
    private Integer menuId;
    private Integer businessId;
    private String logo;
    private String serialNo;
    private String merchantCode;
    private String walletId;
    private String terminalName;
    private String status;
    // The owner's settlement account (merchants). Outward transfers from a MERCHANT terminal must go to it.
    private String settlementAcct;
    private String settlementBankCode;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
