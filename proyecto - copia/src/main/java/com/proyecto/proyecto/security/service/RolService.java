package com.proyecto.proyecto.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.security.entity.Rol;
import com.proyecto.proyecto.security.enums.RolNombre;
import com.proyecto.proyecto.security.repository.RolRepository;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }

    @SuppressWarnings("null")
    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}