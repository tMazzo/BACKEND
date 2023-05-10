/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Repository;


import com.portafolio.TomasMazzzo.Entity.Hys2;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHys2 extends JpaRepository<Hys2, Integer> {
    
    public Optional<Hys2> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
