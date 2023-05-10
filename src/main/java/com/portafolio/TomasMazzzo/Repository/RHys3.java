/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Repository;


import com.portafolio.TomasMazzzo.Entity.Hys3;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHys3 extends JpaRepository<Hys3, Integer> {
    
    public Optional<Hys3> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
