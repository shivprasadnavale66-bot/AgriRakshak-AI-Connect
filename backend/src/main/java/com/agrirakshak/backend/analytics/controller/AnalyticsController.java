package com.agrirakshak.backend.analytics.controller;

import com.agrirakshak.backend.analytics.service.AnalyticsService;
import com.agrirakshak.backend.dto.DashboardAnalyticsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/dashboard")
    public DashboardAnalyticsResponse getDashboardAnalytics() {
        return analyticsService.getDashboardAnalytics();
    }
}