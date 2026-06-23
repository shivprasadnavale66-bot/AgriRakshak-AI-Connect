package com.agrirakshak.backend.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

    private String city;
    private double temperature;
    private int humidity;
    private int pressure;
    private double windSpeed;
    private String description;

}