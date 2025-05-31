package com.experience.mcp.tools.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService{
    @Value("${weather.api.key}")
    private String apiKey;

    private final WeatherApiClient weatherApiClient;

    public WeatherServiceImpl(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }


    @Override
    public Map<String, Object> getForecastWeather(String city, int days) {
        return weatherApiClient.getForecast(apiKey, city, days);
    }

    @Override
    public Map<String, Object> getCurrentWeather(String city) {
        return weatherApiClient.getCurrentWeather(apiKey, city);
    }
}
