/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Controller;

import com.portafolio.TomasMazzzo.Dto.dtoEducacion;
import com.portafolio.TomasMazzzo.Entity.Educacion;
import com.portafolio.TomasMazzzo.Security.Controller.Mensaje;
import com.portafolio.TomasMazzzo.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "*")
public class CEducacion {

    @Autowired
    SEducacion sEducacion;

    // CREAR LISTA
    @CrossOrigin(origins = "*")
    @GetMapping(value = {"/lista"})
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // BUSCAR EXPERIENCIA
    @CrossOrigin(origins = "*")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("Esa educación no existe."), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    // BORRAR EXPERIENCIA
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id, HttpServletResponse response) {
        // VALIDAMOS SI EXISTE EL ID
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada."), HttpStatus.OK);
    }
    
    // CREAR EXPERIENCIA
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu, HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "*");
        if (StringUtils.isBlank(dtoEdu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreE(dtoEdu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa Educación existe."), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoEdu.getAnioE(), dtoEdu.getNombreE(), dtoEdu.getLocalidadE(), dtoEdu.getDescripcionE());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educación agregada."), HttpStatus.OK);
    }
    
     // ACTUALIZAR EXPERIENCIA
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu) {

        // VALIDAMOS SI EXISTE EL ID
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        // COMPARA NOMBRE DE EXPERIENCIAS
        if (sEducacion.existsByNombreE(dtoEdu.getNombreE()) && sEducacion.getByNombreE(dtoEdu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe."), HttpStatus.BAD_REQUEST);
        }

        // NO PUEDE ESTAR VACÍO
        if (StringUtils.isBlank(dtoEdu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setAnioE(dtoEdu.getAnioE());
        educacion.setNombreE(dtoEdu.getNombreE());
        educacion.setLocalidadE(dtoEdu.getLocalidadE());
        educacion.setDescripcionE((dtoEdu.getDescripcionE()));

        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada."), HttpStatus.OK);
    }
}
