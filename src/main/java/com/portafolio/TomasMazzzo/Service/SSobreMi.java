/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Service;

import com.portafolio.TomasMazzzo.Entity.SobreMi;
import com.portafolio.TomasMazzzo.Repository.RSobreMi;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSobreMi {
    @Autowired
    RSobreMi rSobreMi;
    
    public List<SobreMi> list() {
    return rSobreMi.findAll();
}
    
    public Optional<SobreMi> getOne(int id){
        return rSobreMi.findById(id);
    }
    
    public Optional<SobreMi> getBytextoSM(String textoSM){
        return rSobreMi.findByTextoSM(textoSM);
    }
    
    public void save(SobreMi sobreMi){
        rSobreMi.save(sobreMi);
    }
    
    public void delete(int id){
        rSobreMi.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSobreMi.existsById(id);
    }
    
    public boolean existsByTextoSM(String textoSM){
        return rSobreMi.existsByTextoSM(textoSM);
    }

}
