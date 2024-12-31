package com.neptune.cbawrapper.RequestRessponseSchema;


import lombok.Data;

import java.util.List;

@Data
public class MenuData {

    private Integer id;
    private String menuName;
    private List<MenuList> menuList;
}
