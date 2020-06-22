package com.dmanriquez.springbootapp.app.editors;

import com.dmanriquez.springbootapp.app.services.IPaisService;
import java.beans.PropertyEditorSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaisEditor extends PropertyEditorSupport {

    public PaisEditor() {
        log.info("Entrando a la clase Pais Editor");
    }

    @Autowired
    private IPaisService paisService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        log.info("Entrando al metodo de paisEditor");
        try {
            Integer id = Integer.parseInt(text);
            this.setValue(paisService.obtenerPaisPorId(id));
        } catch (NumberFormatException e) {
            this.setValue(null);
        }
    }
}
