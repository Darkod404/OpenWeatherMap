package com.proyecto.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.proyecto.proyecto.security.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date fechaCreacion;
    
    private String ciudad;
    
    @Lob
    private String peticion;
    
    
    @Lob
    private String respuesta;
    
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    public void setUsuarioId(long id) {
        this.id = id;
    }
}
