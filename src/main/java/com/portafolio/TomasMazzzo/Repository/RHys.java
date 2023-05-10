/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Repository;

import com.portafolio.TomasMazzzo.Entity.Hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHys extends JpaRepository<Hys, Integer> {
    
    public Optional<Hys> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
