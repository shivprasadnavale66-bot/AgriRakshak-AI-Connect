package com.agrirakshak.backend.weather.service;

import com.agrirakshak.backend.weather.dto.WeatherResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void init() {
        System.out.println("======================================");
        System.out.println("Loaded Weather API Key: " + apiKey);
        System.out.println("======================================");
    }

    @Override
    public WeatherResponse getWeather(String city) {

        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&appid="
                + apiKey
                + "&units=metric";

        System.out.println("Weather URL : " + url);

        Map<String, Object> response =
                restTemplate.getForObject(url, Map.class);

        if (response == null) {
            throw new RuntimeException("Unable to fetch weather data.");
        }

        Map<String, Object> main =
                (Map<String, Object>) response.get("main");

        Map<String, Object> wind =
                (Map<String, Object>) response.get("wind");

        List<Map<String, Object>> weatherList =
                (List<Map<String, Object>>) response.get("weather");

        WeatherResponse weather = new WeatherResponse();

        weather.setCity((String) response.get("name"));

        weather.setTemperature(
                ((Number) main.get("temp")).doubleValue());

        weather.setHumidity(
                ((Number) main.get("humidity")).intValue());

        weather.setPressure(
                ((Number) main.get("pressure")).intValue());

        weather.setWindSpeed(
                ((Number) wind.get("speed")).doubleValue());

        if (weatherList != null && !weatherList.isEmpty()) {
            weather.setDescription(
                    (String) weatherList.get(0).get("description"));
        }

        return weather;
    }
}