
package com.dmanriquez.springbootapp.app.editors;

import java.beans.PropertyEditorSupport;


public class MayusculasEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.substring(0 , 1).toUpperCase() + text.substring(1).trim());
    }
    
    
    
}
