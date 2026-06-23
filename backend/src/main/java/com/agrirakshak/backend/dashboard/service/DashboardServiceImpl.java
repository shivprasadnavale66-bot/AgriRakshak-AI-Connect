package com.agrirakshak.backend.dashboard.service;

import com.agrirakshak.backend.dashboard.dto.DashboardResponse;
import com.agrirakshak.backend.fertilizer.repository.FertilizerRepository;
import com.agrirakshak.backend.market.repository.MarketPriceRepository;
import com.agrirakshak.backend.repository.CropRepository;
import com.agrirakshak.backend.repository.FarmerRepository;
import com.agrirakshak.backend.repository.UserRepository;
import com.agrirakshak.backend.scheme.repository.SchemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final FarmerRepository farmerRepository;
    private final CropRepository cropRepository;
    private final MarketPriceRepository marketPriceRepository;
    private final SchemeRepository schemeRepository;
    private final UserRepository userRepository;
    private final FertilizerRepository fertilizerRepository;

    @Override
    public DashboardResponse getDashboardData() {

        return new DashboardResponse(
                farmerRepository.count(),
                cropRepository.count(),
                marketPriceRepository.count(),
                schemeRepository.count(),
                userRepository.count(),
                fertilizerRepository.count()
        );
    }
}