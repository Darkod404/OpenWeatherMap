package com.proyecto.proyecto.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.entity.Consulta;
import com.proyecto.proyecto.repository.ConsultaRepository;
import com.proyecto.proyecto.security.entity.Usuario;
import com.proyecto.proyecto.security.entity.UsuarioPrincipal;


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

    public void saveConsulta(String cityName, String peticion, String respuesta) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        Usuario usuario = new Usuario();
        usuario.setId(usuarioPrincipal.getId());

        Consulta consulta = new Consulta();
        consulta.setFechaCreacion(new Date());
        consulta.setCiudad(cityName);
        consulta.setPeticion(peticion);
        consulta.setRespuesta(respuesta);
        consulta.setUsuario(usuario);

        guardarConsulta(consulta);
    }
    
}
