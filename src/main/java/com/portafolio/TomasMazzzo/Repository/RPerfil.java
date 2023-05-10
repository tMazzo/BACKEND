/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Repository;

import com.portafolio.TomasMazzzo.Entity.Perfil;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPerfil extends JpaRepository<Perfil, Integer>{
    
    public Optional<Perfil> findByNombreP(String nombreP);

    public boolean existsByNombreP(String nombreP);
}
