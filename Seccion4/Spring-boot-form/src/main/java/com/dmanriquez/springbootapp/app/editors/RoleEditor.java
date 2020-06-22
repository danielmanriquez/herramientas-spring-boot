package com.dmanriquez.springbootapp.app.editors;

import com.dmanriquez.springbootapp.app.services.IRoleService;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleEditor extends PropertyEditorSupport{
    
    @Autowired
    private IRoleService roleService;
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
       
        try{
        
            Integer id = Integer.parseInt(text);
            this.setValue(roleService.buscarPorId(id));
        
        }catch(NumberFormatException e){
        
            this.setValue(null);
        }
        
    }
    
    
    
}
