package com.neptune.cbawrapper.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "bill_categories")
public class CategoriesModel {

    @Id
    private String Id;
    private String interswitchId;
    private String name;
    private String description;
    private Boolean isActive;
    private String logo;
    private Integer paymentTypeId; // 2	Airtime_Data	Airtime and Data || 3	Bills	Bills Payment
    private boolean validateNum;

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getActive() {
        return isActive;
    }
}
