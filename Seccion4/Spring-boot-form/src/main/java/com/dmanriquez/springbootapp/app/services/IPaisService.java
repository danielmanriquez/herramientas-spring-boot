package com.dmanriquez.springbootapp.app.services;

import com.dmanriquez.springbootapp.app.models.domain.Pais;
import java.util.List;


public interface IPaisService {
    
    
    public List<Pais> listar();
    public Pais obtenerPaisPorId(Integer id);
}
