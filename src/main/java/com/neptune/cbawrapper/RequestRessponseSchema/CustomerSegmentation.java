package com.neptune.cbawrapper.RequestRessponseSchema;

import com.neptune.cbawrapper.Models.CustomersModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerSegmentation {
    private List<CustomersModel> existingCustomers;
    private List<CustomersModel> newCustomers;
}
