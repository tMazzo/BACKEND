/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Controller;

import com.portafolio.TomasMazzzo.Dto.dtoTitulo;
import com.portafolio.TomasMazzzo.Entity.Titulo;
import com.portafolio.TomasMazzzo.Security.Controller.Mensaje;
import com.portafolio.TomasMazzzo.Service.STitulo;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/titulo")
@CrossOrigin(origins = "https://bkd-portfolio-web.onrender.com")
public class CTitulo {
      @Autowired
    STitulo sTitulo;
      
    // CREAR LISTA
    @GetMapping(value = {"/lista"})
    public ResponseEntity<List<Titulo>> list() {
        List<Titulo> list = sTitulo.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     // BUSCAR TITULO
    @GetMapping("/detail/{id}")
    public ResponseEntity<Titulo> getById(@PathVariable("id") int id) {
        if (!sTitulo.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese titulo no existe."), HttpStatus.NOT_FOUND);
        }
        Titulo titulo = sTitulo.getOne(id).get();
        return new ResponseEntity(titulo, HttpStatus.OK);
    }
    
    // BORRAR TITULO
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id, HttpServletResponse response) {
        // VALIDAMOS SI EXISTE EL ID
        if (!sTitulo.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        sTitulo.delete(id);
        return new ResponseEntity(new Mensaje("Titulo eliminada."), HttpStatus.OK);
    }
    
     // CREAR EXPERIENCIA
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTitulo dtotitulo) {
        if (StringUtils.isBlank(dtotitulo.getNombreT())) {
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (sTitulo.existsByNombreT(dtotitulo.getNombreT())) {
            return new ResponseEntity(new Mensaje("Ese Titulo existe."), HttpStatus.BAD_REQUEST);
        }

        Titulo titulo = new Titulo(dtotitulo.getNombreT());
        sTitulo.save(titulo);

        return new ResponseEntity(new Mensaje("Titulo agregado."), HttpStatus.OK);
    }
    
    // ACTUALIZAR EXPERIENCIA
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTitulo dtotitulo) {

        // VALIDAMOS SI EXISTE EL ID
        if (!sTitulo.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        // COMPARA NOMBRE DE EXPERIENCIAS
        if (sTitulo.existsByNombreT(dtotitulo.getNombreT()) && sTitulo.getByNombreT(dtotitulo.getNombreT()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese Titulo ya existe."), HttpStatus.BAD_REQUEST);
        }

        // NO PUEDE ESTAR VACÍO
        if (StringUtils.isBlank(dtotitulo.getNombreT())) {
            return new ResponseEntity(new Mensaje("El Titulo es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Titulo titulo = sTitulo.getOne(id).get();
        titulo.setNombreT(dtotitulo.getNombreT());

        sTitulo.save(titulo);
        return new ResponseEntity(new Mensaje("Titulo actualizado."), HttpStatus.OK);
    }
}
