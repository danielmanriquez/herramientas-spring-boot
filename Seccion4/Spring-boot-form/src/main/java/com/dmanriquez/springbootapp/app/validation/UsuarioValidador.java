
package com.dmanriquez.springbootapp.app.validation;

import com.dmanriquez.springbootapp.app.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

 @Component
public class UsuarioValidador implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Usuario usuario = (Usuario) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace( errors, "nombre", "NotEmpty.usuario.nombre");
        
//        if(!usuario.getRut().matches("[0-9]{2}[.][\\\\d]{3}[.][\\\\d]{3}[-][\\\\d]{1}")){
//        
//            errors.rejectValue("rut", "Pattern.usuario.rut");
//        
//        }
    }
    
}
