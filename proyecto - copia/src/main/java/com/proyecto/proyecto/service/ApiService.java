package com.proyecto.proyecto.service;

public interface ApiService {
    String getCurrentWeather(String cityName);
    String getWeatherForecast(String cityName);
    String getAirPollutionForecast(String cityName);
}
