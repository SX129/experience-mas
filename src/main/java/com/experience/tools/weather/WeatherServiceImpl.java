package com.experience.tools.weather;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherServiceImpl implements WeatherService{
    private final String apiKey;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public WeatherServiceImpl() {
        this.apiKey = System.getenv("WEATHER_API_KEY");

        if(this.apiKey == null){
            throw new IllegalStateException("WEATHER_API_KEY environment variable is not set.");
        }

        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Map<String, Object> getForecastWeather(String city, int days) {
        String uri = String.format("http://api.weatherapi.com/v1/forecast.json?key=%s&q=%s&days=%d", apiKey, city, days);
        return sendRequest(uri);
    }

    @Override
    public Map<String, Object> getCurrentWeather(String city) {
        String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String uri = String.format("http://api.weatherapi.com/v1/current.json?key=%s&q=%s", apiKey, encodedCity);
        return sendRequest(uri);
    }

    private Map<String, Object> sendRequest(String uri) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), Map.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error calling Weather API", e);
        }
    }
}
