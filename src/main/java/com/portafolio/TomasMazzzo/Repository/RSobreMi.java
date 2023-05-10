/**
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Repository;

import com.portafolio.TomasMazzzo.Entity.SobreMi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSobreMi extends JpaRepository<SobreMi, Integer>{
    
    Optional<SobreMi> findByTextoSM(String textoSM);

    boolean existsByTextoSM(String textoSM);
}
