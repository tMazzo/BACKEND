/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Service;

import com.portafolio.TomasMazzzo.Entity.Hys2;
import com.portafolio.TomasMazzzo.Repository.RHys2;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHys2 {
    @Autowired
    RHys2 rHys;

    public List<Hys2> list() {
    return rHys.findAll();
}
    
    public Optional<Hys2> getOne(int id){
        return rHys.findById(id);
    }
    
    public Optional<Hys2> getByNombreS(String nombreS){
        return rHys.findByNombreS(nombreS);
    }
    
    public void save(Hys2 hys){
        rHys.save(hys);
    }
    
    public void delete(int id){
        rHys.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHys.existsById(id);
    }
    
    public boolean existsByNombreS(String nombreS){
        return rHys.existsByNombreS(nombreS);
    }

}
