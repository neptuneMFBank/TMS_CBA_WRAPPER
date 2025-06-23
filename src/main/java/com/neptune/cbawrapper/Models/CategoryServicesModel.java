package com.neptune.cbawrapper.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "category_services")
public class CategoryServicesModel {

    @Id
    private String id;
    private String serviceName;
    private String categoryName;
    private String logo;
    private String serviceId;
    private String interswitchId;
    private String supportEmail;
    private List<BillerInfo> billerInfos;

    public List<BillerInfo> getBillerInfos() {
        return billerInfos;
    }

    public void setBillerInfos(List<BillerInfo> billerInfos) {
        this.billerInfos = billerInfos;
    }
}
