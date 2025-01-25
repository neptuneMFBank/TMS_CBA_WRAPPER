package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;

@Data
public class CreateRes {
    private String idxb;

    public String getIdxb() {
        return idxb;
    }

    public void setIdxb(String idxb) {
        this.idxb = idxb;
    }
}
