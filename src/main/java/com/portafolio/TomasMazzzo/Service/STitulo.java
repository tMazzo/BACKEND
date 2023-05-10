/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Service;

import com.portafolio.TomasMazzzo.Entity.Titulo;
import com.portafolio.TomasMazzzo.Repository.RTitulo;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class STitulo {
    @Autowired
    RTitulo rTitulo;
    
    public List<Titulo> list() {
    return rTitulo.findAll();
}
    
    public Optional<Titulo> getOne(int id){
        return rTitulo.findById(id);
    }
    
    public Optional<Titulo> getByNombreT(String nombreT){
        return rTitulo.findByNombreT(nombreT);
    }
    
    public void save(Titulo titulo){
        rTitulo.save(titulo);
    }
    
    public void delete(int id){
        rTitulo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rTitulo.existsById(id);
    }
    
    public boolean existsByNombreT(String nombreT){
        return rTitulo.existsByNombreT(nombreT);
    }
}
