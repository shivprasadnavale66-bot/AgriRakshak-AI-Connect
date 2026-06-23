package com.agrirakshak.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/farmer/test")
    public String farmer() {
        return "Welcome Farmer";
    }

    @GetMapping("/api/admin/test")
    public String admin() {
        return "Welcome Admin";
    }
}