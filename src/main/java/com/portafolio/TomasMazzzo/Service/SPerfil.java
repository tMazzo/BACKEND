/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Service;

import com.portafolio.TomasMazzzo.Entity.Perfil;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portafolio.TomasMazzzo.Repository.RPerfil;

@Service
@Transactional
public class SPerfil {
    @Autowired
    RPerfil rPersona;
    
     public List<Perfil> list() {
    return rPersona.findAll();
}
    
    public Optional<Perfil> getOne(int id){
        return rPersona.findById(id);
    }
    
    public Optional<Perfil> getByNombreP(String nombreP){
        return rPersona.findByNombreP(nombreP);
    }
    
    public void save(Perfil perfil){
        rPersona.save(perfil);
    }
    
    public void delete(int id){
        rPersona.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByNombreP(String nombreP){
        return rPersona.existsByNombreP(nombreP);
    }

}