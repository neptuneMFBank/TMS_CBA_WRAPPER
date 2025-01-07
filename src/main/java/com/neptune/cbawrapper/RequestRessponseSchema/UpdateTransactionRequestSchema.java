package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateTransactionRequestSchema implements Serializable {
    private Integer status;
    private String note;
}
