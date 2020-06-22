
package com.dmanriquez.springbootapp.app.models.domain;

import com.dmanriquez.springbootapp.app.validation.IdentificadorRegex;
import com.dmanriquez.springbootapp.app.validation.Requerido;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
//import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Usuario {
   
    private Integer idUsuario;
    
    //@Pattern(regexp="[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][\\d]{1}")
    @IdentificadorRegex
    private String rut;
    
    //@NotEmpty
    @Requerido
    private String nombre;
    
    //@NotBlank
    @Requerido
    private String apellido;
    
    @NotBlank
    @Size(min = 3 , max = 9)
    @NotEmpty
    private String username;
    
    
    @Requerido
    private String password;
    
    @Email
    @Requerido
    private String email;
    
    @Requerido
    private String telefono;
    
    @NotNull
    @Min(18)
    @Max(99)
    private Integer edad;
    
    @NotNull
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    //@Past
    private Date fechaNacimiento;
    
    @NotNull
    private Pais pais;
    
    @NotEmpty
    private List <Role> roles;
    
    @NotNull
    private Boolean habilitado = true;
    
    @NotEmpty
    private String genero;
    

    public Usuario(String username, String password, String email, String telefono) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
    }
    
    
    
}
