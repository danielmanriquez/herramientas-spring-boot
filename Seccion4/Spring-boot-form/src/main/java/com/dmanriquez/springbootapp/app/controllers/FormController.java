package com.dmanriquez.springbootapp.app.controllers;

import com.dmanriquez.springbootapp.app.editors.MayusculasEditor;
import com.dmanriquez.springbootapp.app.editors.PaisEditor;
import com.dmanriquez.springbootapp.app.editors.RoleEditor;
import com.dmanriquez.springbootapp.app.models.domain.Pais;
import com.dmanriquez.springbootapp.app.models.domain.Role;
import com.dmanriquez.springbootapp.app.models.domain.Usuario;
import com.dmanriquez.springbootapp.app.services.IPaisService;
import com.dmanriquez.springbootapp.app.validation.UsuarioValidador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.dmanriquez.springbootapp.app.services.IRoleService;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@SessionAttributes("usuario")
public class FormController {
    
    @Autowired
    private IPaisService paisService;
    
    @Autowired
    private UsuarioValidador usuarioValidador;
    
    @Autowired
    private PaisEditor paisEditor;
    
    @Autowired 
    private IRoleService rolService;
    
    @Autowired
    private RoleEditor roleEditor;
    
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(usuarioValidador);
        
        //filtro para formatear la fecha.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Analizador estricto
        dateFormat.setLenient(false);
        
        binder.registerCustomEditor(Date.class, "fechaNacimiento" , new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "nombre", new MayusculasEditor());
        binder.registerCustomEditor(String.class, "apellido", new MayusculasEditor());
        binder.registerCustomEditor(Pais.class, "pais" , paisEditor);
        binder.registerCustomEditor(Role.class, "roles" , roleEditor);
    }
    
    @GetMapping("/form")
    public String form(Model model , Usuario usuario) {
        
        
        usuario.setIdUsuario(25);
        usuario.setRut("18.975.317-9");
        usuario.setNombre("Daniel");
        usuario.setApellido("Manriquez");
        usuario.setEmail("daniel.manriquez.saavedra@gmail.com");
        usuario.setPassword("cualquierpassword");
        usuario.setUsername("Admingui");
        usuario.setTelefono("930622029");
        usuario.setEdad(25);
        usuario.setPais(new Pais(1, "CL", "Chile"));
        usuario.setHabilitado(true);
        usuario.setRoles(Arrays.asList(new Role(3,"Invitado" , "ROLE_INVITADO")));
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Formulario");
        return "form";

    }
    
    
    @ModelAttribute("paisesDesdeServicio")
    public List<Pais> paisesDesdeServicio(){
        
        return paisService.listar();
    
    }
    
    @ModelAttribute("paises")
    public List<String> paises(){
        
        return Arrays.asList("Chile","España","Mexico","Peru","Argentina");
    
    }
    
     @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){
        
        return Arrays.asList(
                new Pais(1,"CL","Chile"),
                new Pais(2,"ES","España"),
                new Pais(3,"MX","Mexico"),
                new Pais(4,"PE","Peru"),
                new Pais(5,"AR","Argentina"),
                new Pais(6,"CO","Colombia"),
                new Pais(7,"VE","Venezuela")
        );
    
    }
    
    
    @ModelAttribute("paisesMap")
    public Map<String,String> paisesMap(){
        
        Map <String , String > paises = new HashMap<String , String >();
        paises.put("ES", "España");
        paises.put("CL", "Chile");
        paises.put("MX", "Mexico");
        paises.put("PE", "Peru");
        paises.put("AR", "Argentina");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");
        
        return paises;
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){
    
        List<String> roles = new ArrayList();
        
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        
        return roles;
    }
    
    @ModelAttribute("mapaRoles")
    public Map<String , String> mapaRoles(){
    
        Map<String , String> roles = new HashMap();
        
        
        
        roles.put("ROLE_ADMIN" , "Administrador");
        roles.put("ROLE_USER" , "Usuario");
        roles.put("ROLE_INVITADO" , "Invitado");
        
        return roles;
    }
    
    @ModelAttribute("listaRolesDesdeServicio")
    public List<Role> listaRolesDesdeServicio(){
    
       return this.rolService.listarRoles();
    }
    
    @ModelAttribute("listaGeneros")
    public List <String> listaGeneros(){
        
        return Arrays.asList("Hombre" , "Mujer");
        
    }
    
    
    @PostMapping("/form")
    public String procesarFormulario(@Valid Usuario usuario,
            BindingResult result
            ) {
        
        //usuarioValidador.validate(usuario, result);

        
        
        if (result.hasErrors()) //Usuario usuario = new Usuario(username , password , email , telefono );
        {
           
            return "form";
        }
        
        
        return "redirect:/resultado";
    }
    
    
    @GetMapping("/resultado")
    public String resultado (@SessionAttribute(name="usuario" , required=false) Usuario usuario ,Model model 
            ,SessionStatus status){
        
        if(usuario==null){
            return "redirect:/form";
        
        }
        model.addAttribute("titulo", "Procesa Formulario");
        status.setComplete();
        return "resultado";
    }
}
