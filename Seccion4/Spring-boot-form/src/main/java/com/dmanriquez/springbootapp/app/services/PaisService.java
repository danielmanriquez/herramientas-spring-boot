/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmanriquez.springbootapp.app.services;

import com.dmanriquez.springbootapp.app.models.domain.Pais;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PaisService implements IPaisService {

    List<Pais> listaPaises;

    public PaisService() {

        this.listaPaises = Arrays.asList(
                new Pais(1, "CL", "Chile"),
                new Pais(2, "ES", "España"),
                new Pais(3, "MX", "Mexico"),
                new Pais(4, "PE", "Peru"),
                new Pais(5, "AR", "Argentina"),
                new Pais(6, "CO", "Colombia"),
                new Pais(7, "VE", "Venezuela")
        );
    }

    @Override
    public List<Pais> listar() {
        return listaPaises;
    }

    @Override
    public Pais obtenerPaisPorId(Integer id) {
        
       Pais resultado = null ;
       
       for (Pais pais : listaPaises){
           if( id == pais.getId()){
               resultado = pais;
               break;
           }
       }
       
       return resultado;
    }

}
