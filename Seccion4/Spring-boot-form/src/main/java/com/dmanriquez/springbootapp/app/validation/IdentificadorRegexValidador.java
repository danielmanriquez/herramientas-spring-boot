/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmanriquez.springbootapp.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex , String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if(value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][\\d]{1}")){
        
            return true;
        }
        
        return false;
    }
    
}
