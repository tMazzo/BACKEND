/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Security.Repository;

import com.portafolio.TomasMazzzo.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario); 
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByMail(String mail);
}
