package com.proyecto.proyecto.service;

public interface ApiService {
    String getWeather(String cityName);
    String getForecast(String cityName);
    String getAirPolution(String cityName);
}
