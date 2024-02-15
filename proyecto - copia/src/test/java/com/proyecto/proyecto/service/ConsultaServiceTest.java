package com.proyecto.proyecto.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.proyecto.proyecto.entity.Consulta;
import com.proyecto.proyecto.repository.ConsultaRepository;

public class ConsultaServiceTest {

    @Mock
    private ConsultaRepository consultaRepository;

    @InjectMocks
    private ConsultaService consultaService;

    private Consulta consulta;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        consulta = new Consulta();
        consulta.setId(11L);
        consulta.setCiudad("Francia");
        consulta.setFechaCreacion(new Date());
        consulta.setPeticion("Esta es una peticion");
        consulta.setRespuesta("Esta es una respuesta");
    }

    @Test
    void testObtenerTodasLasConsultas() {
        when(consultaRepository.findAll()).thenReturn(Arrays.asList(consulta));
        assertNotNull(consultaService.obtenerTodasLasConsultas());
    }

    @SuppressWarnings("null")
    @Test
    void testGuardarConsulta() {
        when(consultaRepository.save(any(Consulta.class))).thenReturn(consulta);
        consulta = consultaService.guardarConsulta("Ciudad","peticion","respuesta");
        assertNotNull(consulta);
    }
}
