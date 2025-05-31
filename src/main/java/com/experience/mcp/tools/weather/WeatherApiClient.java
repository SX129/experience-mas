package com.experience.mcp.tools.weather;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "weatherApiClient", url = "http://api.weatherapi.com/v1")
public interface WeatherApiClient {

    @GetMapping("/forecast.json")
    Map<String, Object> getForecast(
            @RequestParam("key") String apiKey,
            @RequestParam("q") String city,
            @RequestParam("days") int days
    );

    @GetMapping("/current.json")
    Map<String, Object> getCurrentWeather(
            @RequestParam("key") String apiKey,
            @RequestParam("q") String city
    );
}
