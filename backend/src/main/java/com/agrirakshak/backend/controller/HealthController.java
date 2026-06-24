package com.agrirakshak.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "AgriRakshak Backend Running";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}