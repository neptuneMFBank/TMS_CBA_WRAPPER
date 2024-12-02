package com.neptune.cbawrapper.Models;

public class PendingTerminalData {
    private Integer id;
    private String parentEntityName;
    private String entityType;
    private Integer menuId;
    private String serialNo;
    private Double latitude;
    private Double longitude;
    private String terminalName;
    private String status;
    private Integer parentSavingsId;
    private String terminalId;
    private String businessName;
    private Integer businessSavingsId;
    private String businessWalletId;

    public String getParentEntityName() {
        return parentEntityName;
    }

    public void setParentEntityName(String parentEntityName) {
        this.parentEntityName = parentEntityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public Integer getParentSavingsId() {
        return parentSavingsId;
    }

    public void setParentSavingsId(Integer parentSavingsId) {
        this.parentSavingsId = parentSavingsId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getBusinessSavingsId() {
        return businessSavingsId;
    }

    public void setBusinessSavingsId(Integer businessSavingsId) {
        this.businessSavingsId = businessSavingsId;
    }

    public String getBusinessWalletId() {
        return businessWalletId;
    }

    public void setBusinessWalletId(String businessWalletId) {
        this.businessWalletId = businessWalletId;
    }

    @Override
    public String toString() {
        return "PendingTerminalData{" +
                "id=" + id +
                ", parentEntityName='" + parentEntityName + '\'' +
                ", entityType='" + entityType + '\'' +
                ", menuId=" + menuId +
                ", serialNo='" + serialNo + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", terminalName='" + terminalName + '\'' +
                ", status='" + status + '\'' +
                ", parentSavingsId=" + parentSavingsId +
                ", terminalId='" + terminalId + '\'' +
                '}';
    }
}
