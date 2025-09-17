package com.neptune.cbawrapper.RequestRessponseSchema;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GenerateStatementRequest {
    private String acctNo;
    private String fromdate;
    private String todate;
}
