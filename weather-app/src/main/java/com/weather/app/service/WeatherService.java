package com.weather.app.service;

import com.weather.app.model.WeatherResponse;
import com.weather.app.util.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private ApiClient apiClient;

    public WeatherResponse fetchWeatherData(String location) {
        return apiClient.fetchWeatherData(location);
    }
}
