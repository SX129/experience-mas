package com.experience.tools.weather;

import com.google.adk.tools.Annotations.Schema;

import java.util.Map;

public class WeatherTool {
    private final WeatherService weatherService;

    public WeatherTool(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getCurrentWeather(@Schema(name = "city", description = "The name of the city for which to retrieve the weather report") String city){
        Map<String, Object> result = weatherService.getCurrentWeather(city);
        Map<String, Object> current = (Map<String, Object>) result.get("current");

        double tempF = (double) current.get("temp_f");
        String condition = (String) ((Map<String, Object>) current.get("condition")).get("text");
        String lastUpdated = (String) current.get("last_updated");

        return String.format("As of %s, the weather in %s is %s with a temperature of %.1f°C.", lastUpdated, city, condition, tempF);
    }
}
