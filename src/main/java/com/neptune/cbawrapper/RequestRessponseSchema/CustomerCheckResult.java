package com.neptune.cbawrapper.RequestRessponseSchema;


import com.neptune.cbawrapper.Models.CustomersModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerCheckResult {
    private CustomersModel customer;
    private boolean exists;

}
