package com.experience.tools.weather;

import com.google.adk.tools.Annotations.Schema;

import java.util.Map;

public class WeatherTool {
    private static final WeatherServiceImpl weatherServiceImpl = new WeatherServiceImpl();

    public static Map<String, Object> getCurrentWeather(@Schema(name = "city", description = "The name of the city for which to retrieve the weather report") String city){
        Map<String, Object> result = weatherServiceImpl.getCurrentWeather(city);
        Map<String, Object> current = (Map<String, Object>) result.get("current");

        double tempF = (double) current.get("temp_f");
        String condition = (String) ((Map<String, Object>) current.get("condition")).get("text");
        String lastUpdated = (String) current.get("last_updated");

        return Map.of("weather", String.format("As of %s, the weather in %s is %s with a temperature of %.1f°F.", lastUpdated, city, condition, tempF));
    }
}
