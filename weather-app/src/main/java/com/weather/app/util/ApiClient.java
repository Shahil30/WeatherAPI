package com.weather.app.util;

import com.weather.app.model.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ApiClient {
    private static final String API_URL = "http://api.weatherapi.com/v1/current.json";
    private static final String API_KEY = "76e63212c3e74e4286d123724242807";
    private static final Logger logger = LoggerFactory.getLogger(ApiClient.class);

    public WeatherResponse fetchWeatherData(String location) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("key", API_KEY)
                .queryParam("q", location)
                .queryParam("aqi", "no");

        String url = uriBuilder.toUriString();
        String rawResponse = restTemplate.getForObject(url, String.class);
        logger.info("Raw JSON response: " + rawResponse);

        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
