package com.proyecto.proyecto.service;

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

    public Consulta guardarConsulta(Consulta consulta) {
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
