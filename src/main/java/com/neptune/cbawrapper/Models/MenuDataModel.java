package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection = "menu")
public class MenuDataModel {

    @Id
    private String id;
    private String menuName;
    private List<MenuListModel> menuListList;
    private TerminalProfileModel terminalProfile;
    private String serialNo;
}
