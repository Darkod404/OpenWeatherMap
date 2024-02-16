package com.proyecto.proyecto.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class OpenweatherServiceTest {

    @InjectMocks
    private OpenweatherService openweatherService;

    @Mock
    private ConsultaService consultaService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetWeather() {
        String cityName = "Medellin";
        String respuestaWeather = openweatherService.getWeather(cityName);
        assertNotNull(respuestaWeather);

    }

    @Test
	void testGetForecast() {
		String cityName = "Medellin";
        String respuestaForecast = openweatherService.getForecast(cityName);
        assertNotNull(respuestaForecast);
	}

	@Test
	void testGetAirPolution() {
		String cityName = "Medellin";
        String respuestaAirPolution = openweatherService.getAirPolution(cityName);
        assertNotNull(respuestaAirPolution);
	}
}
