package com.proyecto.proyecto.service;

public interface ApiService {
    String getCurrentWeather(String cityName);
    String getForecast(String cityName);
    String getAirPolution(String cityName);
}
