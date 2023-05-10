/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Controller;

import com.portafolio.TomasMazzzo.Dto.dtoPerfil;
import com.portafolio.TomasMazzzo.Entity.Perfil;
import com.portafolio.TomasMazzzo.Security.Controller.Mensaje;
import com.portafolio.TomasMazzzo.Service.SPerfil;
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
@RequestMapping("/perfil")
@CrossOrigin(origins = "http://localhost:4200")
public class CPerfil {
    @Autowired
    SPerfil sPerfil;

    // CREAR LISTA
    @GetMapping(value = {"/lista"})
    public ResponseEntity<List<Perfil>> list() {
        List<Perfil> list = sPerfil.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    // BUSCAR PERFIL
    @GetMapping("/detail/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable("id") int id) {
        if (!sPerfil.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese Perfil no existe."), HttpStatus.NOT_FOUND);
        }
        Perfil perfil = sPerfil.getOne(id).get();
        return new ResponseEntity(perfil, HttpStatus.OK);
    }
    
    // BORRAR PERFIL
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id, HttpServletResponse response) {
        // VALIDAMOS SI EXISTE EL ID
        if (!sPerfil.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        sPerfil.delete(id);
        return new ResponseEntity(new Mensaje("Perfil eliminado."), HttpStatus.OK);
    }
    
    // CREAR PERFIL
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPerfil dtoPer) {
        if (StringUtils.isBlank(dtoPer.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Perfil perfil = new Perfil(dtoPer.getNombreP(), dtoPer.getApellidoP(), dtoPer.getApodoP(), dtoPer.getImgP());
        sPerfil.save(perfil);

        return new ResponseEntity(new Mensaje("Perfil agregado."), HttpStatus.OK);
    }
    
     // ACTUALIZAR PERFIL
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPerfil dtoper) {

        // VALIDAMOS SI EXISTE EL ID
        if (!sPerfil.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        // NO PUEDE ESTAR VACÍO
        if (StringUtils.isBlank(dtoper.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Perfil perfil = sPerfil.getOne(id).get();
        perfil.setNombreP(dtoper.getNombreP());
        perfil.setApellidoP(dtoper.getApellidoP());
        perfil.setApodoP(dtoper.getApodoP());
        perfil.setImgP((dtoper.getImgP()));

        sPerfil.save(perfil);
        return new ResponseEntity(new Mensaje("Nombre actualizado."), HttpStatus.OK);
    }

}
