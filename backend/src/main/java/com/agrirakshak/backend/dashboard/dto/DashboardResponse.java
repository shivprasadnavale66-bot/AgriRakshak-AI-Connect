package com.agrirakshak.backend.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long farmerCount;
    private long cropCount;
    private long marketCount;
    private long schemeCount;
    private long userCount;
    private long fertilizerCount;
}