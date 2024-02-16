package com.proyecto.proyecto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class OpenweatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("prueba1")
    public void testGetWeather() throws Exception {
        String cityName = "London";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/weather")
                .param("cityName", cityName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    @WithUserDetails("prueba1")
    public void testGetForecast() throws Exception {
        String cityName = "London";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/forecast")
                .param("cityName", cityName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    @WithUserDetails("prueba1")
    public void testGetAirPollution() throws Exception {
        String cityName = "London";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/airpolution")
                .param("cityName", cityName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=UTF-8"));
    }
}
