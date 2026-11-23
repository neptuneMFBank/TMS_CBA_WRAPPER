package com.neptune.cbawrapper.RequestRessponseSchema;

public class GetPOSResponse {
    private String terminalID;
    private String applicationStatus;
    private String posAcctNum;
    private String posName;
    private String posLongitude;
    private String posLatitude;
    private String balance;
    private String status;
    private Boolean payBills;
    private Boolean initiateTrans;

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getPosAcctNum() {
        return posAcctNum;
    }

    public void setPosAcctNum(String posAcctNum) {
        this.posAcctNum = posAcctNum;
    }

    public String getPosLongitude() {
        return posLongitude;
    }

    public void setPosLongitude(String posLongitude) {
        this.posLongitude = posLongitude;
    }

    public String getPosLatitude() {
        return posLatitude;
    }

    public void setPosLatitude(String posLatitude) {
        this.posLatitude = posLatitude;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

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
}
