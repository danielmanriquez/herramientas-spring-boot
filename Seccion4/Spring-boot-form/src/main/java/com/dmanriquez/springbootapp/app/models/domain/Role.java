package com.dmanriquez.springbootapp.app.models.domain;

import lombok.Data;

@Data
public class Role {
    
    
    private Integer idRole;
    private String nombre;
    private String role;

    public Role() {
    }

    public Role(Integer idRole, String nombre, String role) {
        this.idRole = idRole;
        this.nombre = nombre;
        this.role = role;
    }
    
    
    
}
