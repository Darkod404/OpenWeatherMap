package com.proyecto.proyecto.security.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class JwtDto {
    private String token;

    public JwtDto(String token){
        this.token = token;
    }
}
