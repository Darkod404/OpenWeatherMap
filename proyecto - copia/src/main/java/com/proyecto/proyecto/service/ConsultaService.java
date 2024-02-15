package com.proyecto.proyecto.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.entity.Consulta;
import com.proyecto.proyecto.repository.ConsultaRepository;

@SuppressWarnings("null")
@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta guardarConsulta(String cityName, String peticion, String respuesta) {

        Consulta consulta = new Consulta();
        consulta.setFechaCreacion(new Date());
        consulta.setCiudad(cityName);
        consulta.setPeticion(peticion);
        consulta.setRespuesta(respuesta);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> obtenerTodasLasConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta obtenerConsultaPorId(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    public void eliminarConsultaPorId(Long id) {
        consultaRepository.deleteById(id);
    }


}
