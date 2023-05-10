/**
 *
 * @authors sirM
 */
package com.portafolio.TomasMazzzo.Controller;

import com.portafolio.TomasMazzzo.Dto.dtoSobreMi;
import com.portafolio.TomasMazzzo.Entity.SobreMi;
import com.portafolio.TomasMazzzo.Security.Controller.Mensaje;
import com.portafolio.TomasMazzzo.Service.SSobreMi;
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
@RequestMapping("/sobreMi")
@CrossOrigin(origins = "http://localhost:4200")
public class CSobreMi {
    @Autowired
    SSobreMi sSobreMi;
     
     // CREAR LISTA
    @GetMapping(value = {"/lista"})
    public ResponseEntity<List<SobreMi>> list() {
        List<SobreMi> list = sSobreMi.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    // BUSCAR PERFIL
    @GetMapping("/detail/{id}")
    public ResponseEntity<SobreMi> getById(@PathVariable("id") int id) {
        if (!sSobreMi.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese texto no existe."), HttpStatus.NOT_FOUND);
        }
        SobreMi sobreMi = sSobreMi.getOne(id).get();
        return new ResponseEntity(sobreMi, HttpStatus.OK);
    }
    
    // BORRAR PERFIL
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id, HttpServletResponse response) {
        // VALIDAMOS SI EXISTE EL ID
        if (!sSobreMi.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        sSobreMi.delete(id);
        return new ResponseEntity(new Mensaje("Sobre mi eliminado."), HttpStatus.OK);
    }
    
     // CREAR PERFIL
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSobreMi dtosm) {
        if (StringUtils.isBlank(dtosm.getTextoSM())) {
            return new ResponseEntity(new Mensaje("El texto es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        SobreMi sobreMi = new SobreMi(dtosm.getTextoSM());
        sSobreMi.save(sobreMi);

        return new ResponseEntity(new Mensaje("Texto agregado."), HttpStatus.OK);
    }
    
    // ACTUALIZAR PERFIL
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSobreMi dtosm) {

        // VALIDAMOS SI EXISTE EL ID
        if (!sSobreMi.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        // NO PUEDE ESTAR VACÍO
        if (StringUtils.isBlank(dtosm.getTextoSM())) {
            return new ResponseEntity(new Mensaje("El texto es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        SobreMi sobreMi = sSobreMi.getOne(id).get();
        sobreMi.setTextoSM(dtosm.getTextoSM());


        sSobreMi.save(sobreMi);
        return new ResponseEntity(new Mensaje("Texto actualizado."), HttpStatus.OK);
    }
}
