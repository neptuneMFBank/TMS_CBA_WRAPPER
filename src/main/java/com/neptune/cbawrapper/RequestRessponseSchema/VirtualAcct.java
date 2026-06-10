package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class VirtualAcct {
    private Boolean payBills;
    private Boolean initiateTrans;
    private String acctNum;

    public Boolean getPayBills() {
        return payBills;
    }

    public void setPayBills(Boolean payBills) {
        this.payBills = payBills;
    }

    public Boolean getInitiateTrans() {
        return initiateTrans;
    }

    public void setInitiateTrans(Boolean initiateTrans) {
        this.initiateTrans = initiateTrans;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }
}
