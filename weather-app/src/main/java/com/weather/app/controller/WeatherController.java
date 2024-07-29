package com.weather.app.controller;

import com.weather.app.model.WeatherResponse;
import com.weather.app.util.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private ApiClient apiClient;

    @GetMapping("/{location}")
    public WeatherDetails getDetailedWeather(@PathVariable String location) {
        WeatherResponse weatherResponse = apiClient.fetchWeatherData(location);
        WeatherDetails details = new WeatherDetails();
        details.setLocation(weatherResponse.getLocation().getName());
        details.setTempC(weatherResponse.getCurrent().getTempC());
        details.setTempF(weatherResponse.getCurrent().getTempF());
        details.setHumidity(weatherResponse.getCurrent().getHumidity());
        details.setCondition(weatherResponse.getCurrent().getCondition().getText());
        details.setWindKph(weatherResponse.getCurrent().getWindKph());
        details.setPressureMb(weatherResponse.getCurrent().getPressureMb());
        details.setPrecipMm(weatherResponse.getCurrent().getPrecipMm());
        details.setFeelslikeC(weatherResponse.getCurrent().getFeelslikeC());
        details.setVisibilityKm(weatherResponse.getCurrent().getVisKm());
        details.setUv(weatherResponse.getCurrent().getUv());
        return details;
    }

    @GetMapping("/summary/{location}")
    public WeatherSummary getWeatherSummary(@PathVariable String location) {
        WeatherResponse weatherResponse = apiClient.fetchWeatherData(location);
        WeatherSummary summary = new WeatherSummary();
        summary.setTempC(weatherResponse.getCurrent().getTempC());
        summary.setTempF(weatherResponse.getCurrent().getTempF());
        summary.setHumidity(weatherResponse.getCurrent().getHumidity());
        summary.setCondition(weatherResponse.getCurrent().getCondition().getText());
        return summary;
    }

    public static class WeatherDetails {
        private String location;
        private double tempC;
        private double tempF;
        private int humidity;
        private String condition;
        private double windKph;
        private double pressureMb;
        private double precipMm;
        private double feelslikeC;
        private double visibilityKm;
        private double uv;

        // Getters and Setters
        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public double getTempC() {
            return tempC;
        }

        public void setTempC(double tempC) {
            this.tempC = tempC;
        }

        public double getTempF() {
            return tempF;
        }

        public void setTempF(double tempF) {
            this.tempF = tempF;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public double getWindKph() {
            return windKph;
        }

        public void setWindKph(double windKph) {
            this.windKph = windKph;
        }

        public double getPressureMb() {
            return pressureMb;
        }

        public void setPressureMb(double pressureMb) {
            this.pressureMb = pressureMb;
        }

        public double getPrecipMm() {
            return precipMm;
        }

        public void setPrecipMm(double precipMm) {
            this.precipMm = precipMm;
        }

        public double getFeelslikeC() {
            return feelslikeC;
        }

        public void setFeelslikeC(double feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        public double getVisibilityKm() {
            return visibilityKm;
        }

        public void setVisibilityKm(double visibilityKm) {
            this.visibilityKm = visibilityKm;
        }

        public double getUv() {
            return uv;
        }

        public void setUv(double uv) {
            this.uv = uv;
        }
    }

    public static class WeatherSummary {
        private double tempC;
        private double tempF;
        private int humidity;
        private String condition;

        // Getters and Setters
        public double getTempC() {
            return tempC;
        }

        public void setTempC(double tempC) {
            this.tempC = tempC;
        }

        public double getTempF() {
            return tempF;
        }

        public void setTempF(double tempF) {
            this.tempF = tempF;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }
    }
}
