package com.agrirakshak.backend.dashboard.controller;

import com.agrirakshak.backend.dashboard.dto.DashboardResponse;
import com.agrirakshak.backend.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/analytics")
    public DashboardResponse getDashboardAnalytics() {
        return dashboardService.getDashboardData();
    }
}
