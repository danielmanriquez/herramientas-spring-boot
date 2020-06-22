/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsControllers {
    
    
    @GetMapping("/")
    public String index(){
        
        
        
        return "params/index";
    }
    
    @GetMapping("/string")
    public String param(@RequestParam(required = false , defaultValue="Hola Daniel") String texto ,Model model){
        
        model.addAttribute("resultado","El parametro enviado es: "+texto);
        return "params/ver";
    
    }
    
    
    @GetMapping("/mix-params")
    public String mixParametros(@RequestParam String saludo ,@RequestParam Integer numero, Model model){
        
        model.addAttribute("resultado","El parametro enviado es : " + saludo+ " Y el numero es :"+ numero);
        return "params/ver";
    
    }
    
    @GetMapping("/mix-params-request")
    public String mixParametros2(HttpServletRequest request, Model model){
        
        String saludo = request.getParameter("saludo");
        Integer numero ;
        try{
            numero = Integer.parseInt(request.getParameter("numero"));
        }catch (NumberFormatException e){
            numero=0;
        
        }
        
        model.addAttribute("resultado","El parametro enviado es : " + saludo+ " Y el numero es :"+ numero);
        return "params/ver";
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
