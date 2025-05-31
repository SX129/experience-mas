package com.experience.mcp.tools.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public Map<String, Object> getForecastWeather(@RequestParam String city, @RequestParam int days) {
        return weatherService.getForecastWeather(city, days);
    }

    @GetMapping("/current")
    public Map<String, Object> getCurrentWeather(@RequestParam String city) {
        return weatherService.getCurrentWeather(city);
    }
}
