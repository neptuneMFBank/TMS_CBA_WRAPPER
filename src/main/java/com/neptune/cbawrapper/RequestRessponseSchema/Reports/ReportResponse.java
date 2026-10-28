package com.neptune.cbawrapper.RequestRessponseSchema.Reports;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ReportResponse<T> {
    private String startDate;
    private String endDate;
    private Map<String, Object> totals;
    private List<T> rows;
}
