package com.agrirakshak.backend.analytics.service;

import com.agrirakshak.backend.dto.DashboardAnalyticsResponse;
import com.agrirakshak.backend.market.repository.MarketPriceRepository;
import com.agrirakshak.backend.repository.CropRepository;
import com.agrirakshak.backend.repository.FarmerRepository;
import com.agrirakshak.backend.scheme.repository.SchemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements AnalyticsService {

    private final FarmerRepository farmerRepository;
    private final CropRepository cropRepository;
    private final MarketPriceRepository marketPriceRepository;
    private final SchemeRepository schemeRepository;

    @Override
    public DashboardAnalyticsResponse getDashboardAnalytics() {

        return DashboardAnalyticsResponse.builder()
                .totalFarmers(farmerRepository.count())
                .totalCrops(cropRepository.count())
                .totalMarketPrices(marketPriceRepository.count())
                .totalSchemes(schemeRepository.count())
                .build();
    }
}