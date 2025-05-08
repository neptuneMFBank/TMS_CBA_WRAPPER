package com.neptune.cbawrapper.RequestRessponseSchema;

public class InstitutionData {
    private String institutionCode;
    private String institutionName;
    private Integer category;

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public InstitutionData() {
    }
}
