/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmanriquez.springbootapp.app.services;

import com.dmanriquez.springbootapp.app.models.domain.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    
    List <Role> roles;
    
    public RoleService(){
    
        roles = new ArrayList();
        
        roles.add(new Role(1,"Administrador" , "ROLE_ADMIN"));
        roles.add(new Role(2,"Usuario" , "ROLE_USER"));
        roles.add(new Role(3,"Invitado" , "ROLE_INVITADO"));
        
    }
    
    
    @Override
    public List<Role> listarRoles() {
        return roles;
    }

    @Override
    public Role buscarPorId(Integer id) {
        
        Role resultado = null;
        for(Role role : roles ){
            
            if(id==role.getIdRole()){
                resultado = role;
                break;
            }
        }
        
        return resultado;
        
    }
    
}
