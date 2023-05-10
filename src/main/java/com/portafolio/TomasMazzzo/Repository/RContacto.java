/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Repository;

import com.portafolio.TomasMazzzo.Entity.Contacto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RContacto extends JpaRepository<Contacto, Integer> {
    
     public Optional<Contacto> findByTelefonoC(String telefonoC);

    public boolean existsByTelefonoC(String telefonoC);
}
