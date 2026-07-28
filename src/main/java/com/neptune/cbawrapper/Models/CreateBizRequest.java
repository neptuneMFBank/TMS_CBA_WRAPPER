package com.neptune.cbawrapper.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreateBizRequest {
    private String id;
    private String pos_account_number;
    private String parent_account_number;
}
