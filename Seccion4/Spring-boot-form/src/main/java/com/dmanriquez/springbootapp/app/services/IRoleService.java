package com.dmanriquez.springbootapp.app.services;

import com.dmanriquez.springbootapp.app.models.domain.Role;
import java.util.List;


public interface IRoleService {
    
    public List<Role> listarRoles();
    
    public Role buscarPorId(Integer id);
    
}
