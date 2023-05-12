/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Controller;

import com.portafolio.TomasMazzzo.Dto.dtoContacto;
import com.portafolio.TomasMazzzo.Entity.Contacto;
import com.portafolio.TomasMazzzo.Security.Controller.Mensaje;
import com.portafolio.TomasMazzzo.Service.SContacto;
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
@RequestMapping("/contacto")
@CrossOrigin(origins = "*")
public class CContacto {

    @Autowired
    SContacto sContacto;

    // CREAR LISTA
    @CrossOrigin(origins = "*")
    @GetMapping(value = {"/lista"})
    public ResponseEntity<List<Contacto>> list() {
        List<Contacto> list = sContacto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    // BUSCAR PERFIL
    @CrossOrigin(origins = "*")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Contacto> getById(@PathVariable("id") int id) {
        if (!sContacto.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese id de contacto no existe."), HttpStatus.NOT_FOUND);
        }
        Contacto contacto = sContacto.getOne(id).get();
        return new ResponseEntity(contacto, HttpStatus.OK);
    }

    // BORRAR PERFIL
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id, HttpServletResponse response) {
        // VALIDAMOS SI EXISTE EL ID
        if (!sContacto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        sContacto.delete(id);
        return new ResponseEntity(new Mensaje("contacto eliminado."), HttpStatus.OK);
    }

    // CREAR PERFIL
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoContacto dtoCont, HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "*");
        if (StringUtils.isBlank(dtoCont.getTelefonoC())) {
            return new ResponseEntity(new Mensaje("El telefono es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoCont.getEmailC())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Contacto contacto = new Contacto(dtoCont.getTelefonoC(), dtoCont.getEmailC());
        sContacto.save(contacto);

        return new ResponseEntity(new Mensaje("Nuevo contacto agregado."), HttpStatus.OK);
    }

    // ACTUALIZAR PERFIL
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoContacto dtoCont) {

        // VALIDAMOS SI EXISTE EL ID
        if (!sContacto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        // NO PUEDE ESTAR VACÍO
        if (StringUtils.isBlank(dtoCont.getTelefonoC())) {
            return new ResponseEntity(new Mensaje("El telefono es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoCont.getEmailC())) {
            return new ResponseEntity(new Mensaje("El email es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Contacto contacto = sContacto.getOne(id).get();
        contacto.setTelefonoC(dtoCont.getTelefonoC());
        contacto.setEmailC(dtoCont.getEmailC());

        sContacto.save(contacto);
        return new ResponseEntity(new Mensaje("Contacto actualizado."), HttpStatus.OK);
    }

}
