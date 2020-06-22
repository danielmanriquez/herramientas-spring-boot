package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablesRutaController {
    
    
    @GetMapping("/")
    public String index (Model model){
        model.addAttribute("titulo", "Enviar Parametros de la ruta " );
        return "/variables/index";
    }
    
    @GetMapping("/string/{texto}")
    public String variables1(@PathVariable String texto, Model model){
        
        model.addAttribute("titulo", "Recibir parametros de la ruta metodo variables 1");
        
        model.addAttribute("resultado", "el parametro recibido es : "+ texto);
                
        
        
        
        return "variables/ver";
    }
    
    @GetMapping("/string/{texto}/{numero}")
    public String variables2(@PathVariable String texto , @PathVariable Integer numero , Model model){
        
        model.addAttribute("titulo", "Recibir parametros de la ruta");
        
        model.addAttribute("resultado", "el parametro recibido es : "+ texto + " y el numero enviado en el path"
                + "es: "+numero+" metodo variables2");
                
        
        
        
        return "variables/ver";
    }
}
