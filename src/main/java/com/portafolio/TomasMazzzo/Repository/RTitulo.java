/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Repository;

import com.portafolio.TomasMazzzo.Entity.Titulo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTitulo extends JpaRepository<Titulo, Integer>{
    public Optional<Titulo> findByNombreT(String nombreT);

    public boolean existsByNombreT(String nombreT);
}
