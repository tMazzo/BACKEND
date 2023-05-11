/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Controller;


import com.portafolio.TomasMazzzo.Dto.dtoHys2;
import com.portafolio.TomasMazzzo.Entity.Hys2;
import com.portafolio.TomasMazzzo.Security.Controller.Mensaje;
import com.portafolio.TomasMazzzo.Service.SHys2;
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
@RequestMapping("/hys2")
@CrossOrigin(origins = "https://bkd-portfolio-web.onrender.com")
public class CHys2 {
      @Autowired
      SHys2 sHys;
      
    // CREAR LISTA
    @CrossOrigin(origins = "https://bkd-portfolio-web.onrender.com")
    @GetMapping(value = {"/lista"})
    public ResponseEntity<List<Hys2>> list() {
        List<Hys2> list = sHys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    // BUSCAR EXPERIENCIA
    @CrossOrigin(origins = "https://bkd-portfolio-web.onrender.com")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys2> getById(@PathVariable("id") int id) {
        if (!sHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("Ese hys no existe."), HttpStatus.NOT_FOUND);
        }
        Hys2 hys = sHys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    // BORRAR EXPERIENCIA
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id, HttpServletResponse response) {
        // VALIDAMOS SI EXISTE EL ID
        if (!sHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        response.setHeader("Access-Control-Allow-Origin", "*");
        sHys.delete(id);
        return new ResponseEntity(new Mensaje("hys eliminada."), HttpStatus.OK);
    }
    
    // CREAR EXPERIENCIA
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys2 dtohys) {
        if (StringUtils.isBlank(dtohys.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (sHys.existsByNombreS(dtohys.getNombreS())) {
            return new ResponseEntity(new Mensaje("Ese hys existe."), HttpStatus.BAD_REQUEST);
        }

        Hys2 hys = new Hys2(dtohys.getNombreS(), dtohys.getColorS(), dtohys.getPorcentajeS());
        sHys.save(hys);

        return new ResponseEntity(new Mensaje("hys agregado."), HttpStatus.OK);
    }
    
    // ACTUALIZAR EXPERIENCIA
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys2 dtohys) {

        // VALIDAMOS SI EXISTE EL ID
        if (!sHys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }

        // COMPARA NOMBRE DE EXPERIENCIAS
        if (sHys.existsByNombreS(dtohys.getNombreS()) && sHys.getByNombreS(dtohys.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese hys ya existe."), HttpStatus.BAD_REQUEST);
        }

        // NO PUEDE ESTAR VACÍO
        if (StringUtils.isBlank(dtohys.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio, no puede estar en blanco."), HttpStatus.BAD_REQUEST);
        }

        Hys2 hys = sHys.getOne(id).get();
        hys.setNombreS(dtohys.getNombreS());
        hys.setColorS(dtohys.getColorS());
        hys.setPorcentajeS(dtohys.getPorcentajeS());


        sHys.save(hys);
        return new ResponseEntity(new Mensaje("hys actualizado."), HttpStatus.OK);
    }
    
}
