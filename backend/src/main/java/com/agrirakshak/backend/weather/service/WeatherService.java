package com.agrirakshak.backend.weather.service;

import com.agrirakshak.backend.weather.dto.WeatherResponse;

public interface WeatherService {

    WeatherResponse getWeather(String city);

}