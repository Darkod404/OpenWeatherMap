package com.proyecto.proyecto.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.proyecto.entity.Geocoding;

@Service
public class OpenweatherService implements ApiService{
    
    private final String apiKey = "1dc3929bb99168e29431b2ba08de4fb6";
    private final RestTemplate restTemplate = new RestTemplate();



    @Override
    public String getCurrentWeather(String cityName) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;
        return restTemplate.getForObject(apiUrl,String.class);
    }
    @Override
    public String getForecast(String cityName) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + apiKey;
        return restTemplate.getForObject(apiUrl, String.class);
    }
    @Override
    public String getAirPolution(String cityName) {
        String geoApiUrl = "http://api.openweathermap.org/geo/1.0/direct?q=" + cityName + "&appid=" + apiKey;
        Geocoding[] geocodings = restTemplate.getForObject(geoApiUrl, Geocoding[].class);

        if (geocodings != null && geocodings.length > 0) {

            Geocoding geocoding = geocodings[0];
            double lat = geocoding.getLat();
            double lon = geocoding.getLon();

            String airPollutionApiUrl = "http://api.openweathermap.org/data/2.5/air_pollution/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
            return restTemplate.getForObject(airPollutionApiUrl, String.class);
        } else {
            return "No se encontraron coordenadas para la ciudad: " + cityName;
        }
    }

}
