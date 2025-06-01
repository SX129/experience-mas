package com.experience.mcp.tools.weather;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeatherTool {
    private final WeatherService weatherService;

    public WeatherTool(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Tool(name = "getCurrentWeather", description = "Get the current weather for a given city")
    public String getCurrentWeather(String city){
        Map<String, Object> result = weatherService.getCurrentWeather(city);
        Map<String, Object> current = (Map<String, Object>) result.get("current");

        double tempF = (double) current.get("temp_f");
        String condition = (String) ((Map<String, Object>) current.get("condition")).get("test");
        String lastUpdated = (String) current.get("last_updated");

        return String.format("As of %s, the weather in %s is %s with a temperature of %.1f°C.", lastUpdated, city, condition, tempF);
    }
}
