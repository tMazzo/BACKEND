/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Service;

import com.portafolio.TomasMazzzo.Entity.Hys;
import com.portafolio.TomasMazzzo.Repository.RHys;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHys {
    @Autowired
    RHys rHys;

    public List<Hys> list() {
    return rHys.findAll();
}
    
    public Optional<Hys> getOne(int id){
        return rHys.findById(id);
    }
    
    public Optional<Hys> getByNombreS(String nombreS){
        return rHys.findByNombreS(nombreS);
    }
    
    public void save(Hys hys){
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
