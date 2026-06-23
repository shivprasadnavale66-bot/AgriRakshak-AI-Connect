package com.agrirakshak.backend.weather.controller;

import com.agrirakshak.backend.weather.dto.WeatherResponse;
import com.agrirakshak.backend.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherResponse getWeather(
            @PathVariable String city
    ) {

        return weatherService.getWeather(city);
    }
}