package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {
    
    /**
     *
     * @param model
     * @return
     */
    @GetMapping({"/index" , "/" , "/home" , "" })
    public String index(Model model){
        
        String titulo ="Hola mundo pasando datos desde el controlador con Model";
        
        model.addAttribute("hola", titulo);
        
        return "index";
    }
    
    @RequestMapping("/perfil")
    public String perfil(Model model , Usuario usuario){
        
        usuario.setNombre("Daniel");
        usuario.setApellido("Manriquez");
        usuario.setEmail("dmanriquez@mail.com");
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Pasando datos desde POJO hacia Vista");
        return "perfil";
    }
    
    @RequestMapping("/listar")
    public String listar(Model model){
        
        
        return "listar";
    }
    
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        for(int i =0 ; i<99 ; i++){
        
            Usuario usuarioTemporal = new Usuario();
            usuarioTemporal.setNombre("Nombre_"+i);
            usuarioTemporal.setApellido("Apellido_"+i);
            usuarioTemporal.setEmail("Email_"+i+"@mail.");
            
            
            usuarios.add(usuarioTemporal);
            
            usuarioTemporal = null;
        }
        
        return usuarios;
    }
}
