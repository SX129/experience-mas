package com.experience.tools.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherServiceImpl implements WeatherService{
    @Value("${weather.api.key}")
    private String apiKey;

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<String, Object> getForecastWeather(String city, int days) {
        String uri = String.format("http://api.weatherapi.com/v1/forecast.json?key=%s&q=%s&days=%d", apiKey, city, days);
        return sendRequest(uri);
    }

    @Override
    public Map<String, Object> getCurrentWeather(String city) {
        String uri = String.format("http://api.weatherapi.com/v1/current.json?key=%s&q=%s", apiKey, city);
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
