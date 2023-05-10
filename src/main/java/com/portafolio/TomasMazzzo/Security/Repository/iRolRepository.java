/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Security.Repository;

import com.portafolio.TomasMazzzo.Security.Entity.rol;
import com.portafolio.TomasMazzzo.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<rol, Integer>{
    Optional<rol> findByRolNombre(RolNombre rolNombre);
    
    
}
