/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Service;

import com.portafolio.TomasMazzzo.Entity.Hys3;
import com.portafolio.TomasMazzzo.Repository.RHys3;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHys3 {
    @Autowired
    RHys3 rHys;

    public List<Hys3> list() {
    return rHys.findAll();
}
    
    public Optional<Hys3> getOne(int id){
        return rHys.findById(id);
    }
    
    public Optional<Hys3> getByNombreS(String nombreS){
        return rHys.findByNombreS(nombreS);
    }
    
    public void save(Hys3 hys){
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
