package com.neptune.cbawrapper.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillerInfo {
    private String amount;
    private String name;
    private String fee;
    private String billerInfoId;
    private String paymentCode;
    private String customerIdField;
    private String isAmountFixed;
    private String currencySymbol;

}
