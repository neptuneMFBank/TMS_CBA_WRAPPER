package com.neptune.cbawrapper.Models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "menu_terminal_profiles")
public class TerminalProfileModel {

    @Id
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
