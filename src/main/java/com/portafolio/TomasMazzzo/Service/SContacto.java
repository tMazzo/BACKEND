/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Service;

import com.portafolio.TomasMazzzo.Entity.Contacto;
import com.portafolio.TomasMazzzo.Repository.RContacto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SContacto {
     @Autowired
    RContacto rContacto;
    
     public List<Contacto> list() {
    return rContacto.findAll();
}
    
    public Optional<Contacto> getOne(int id){
        return rContacto.findById(id);
    }
    
    public Optional<Contacto> getByTelefonoC(String telefonoC){
        return rContacto.findByTelefonoC(telefonoC);
    }
    
    public void save(Contacto contacto){
        rContacto.save(contacto);
    }
    
    public void delete(int id){
        rContacto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rContacto.existsById(id);
    }
    
    public boolean existsByTelefonoC(String telefonoC){
        return rContacto.existsByTelefonoC(telefonoC);
    }

}
