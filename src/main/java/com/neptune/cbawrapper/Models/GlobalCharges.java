package com.neptune.cbawrapper.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "global_charges")
public class GlobalCharges {
    private String paymentTypeIId;

}
