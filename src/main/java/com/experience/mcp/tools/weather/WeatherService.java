package com.experience.mcp.tools.weather;

import java.util.Map;

public interface WeatherService {
    Map<String, Object> getForecastWeather(String city, int days);

    Map<String, Object> getCurrentWeather(String city);
}
