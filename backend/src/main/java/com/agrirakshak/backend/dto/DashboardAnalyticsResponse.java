package com.agrirakshak.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardAnalyticsResponse {

    private long totalFarmers;
    private long totalCrops;
    private long totalMarketPrices;
    private long totalSchemes;

}