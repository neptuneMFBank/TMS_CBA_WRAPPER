package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

@Data
public class TerminalProfile {
    private String id;
    private String terminalId;
    private String parentEntityName;
    private String entityType;
    private Integer menuId;
    private Integer logoId;
    private String serialNo;
    private String merchantCode;
    private String terminalName;
    private String status;
}
