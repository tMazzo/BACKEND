/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Controller;

import com.portafolio.TomasMazzzo.Dto.dtoExperiencia;
import com.portafolio.TomasMazzzo.Entity.Experiencia;
import com.portafolio.TomasMazzzo.Security.Controller.Mensaje;
import com.portafolio.TomasMazzzo.Service.SExperiencia;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    // CREAR LISTA
    @GetMapping(value = {"/lista"})
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // BUSCAR EXPERIENCIA
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("Esa Experiencia no existe."), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    // BORRAR EXPERIENCIA
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id, HttpServletResponse response) {
        // VALIDAMOS SI EXISTE EL ID
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada."), HttpStatus.OK);
    }

    // CREAR EXPERIENCIA
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp) {
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByNombreE(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa Experiencia existe."), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoexp.getAnioE(), dtoexp.getNombreE(), dtoexp.getLocalidadE(), dtoexp.getDescripcionE());
        sExperiencia.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada."), HttpStatus.OK);
    }

    // ACTUALIZAR EXPERIENCIA
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp) {

        // VALIDAMOS SI EXISTE EL ID
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        // COMPARA NOMBRE DE EXPERIENCIAS
        if (sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe."), HttpStatus.BAD_REQUEST);
        }

        // NO PUEDE ESTAR VACÍO
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setAnioE(dtoexp.getAnioE());
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setLocalidadE(dtoexp.getLocalidadE());
        experiencia.setDescripcionE((dtoexp.getDescripcionE()));

        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada."), HttpStatus.OK);
    }

}
