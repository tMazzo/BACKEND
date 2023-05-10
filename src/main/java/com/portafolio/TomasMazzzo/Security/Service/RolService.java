/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Security.Service;

import com.portafolio.TomasMazzzo.Security.Entity.rol;
import com.portafolio.TomasMazzzo.Security.Enums.RolNombre;
import com.portafolio.TomasMazzzo.Security.Repository.iRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {

    @Autowired
    iRolRepository iRolRepository;

    public Optional<rol> getByRolNombre(RolNombre rolNombre) {

        return iRolRepository.findByRolNombre(rolNombre);
    }

    public void save(rol rol) {
        iRolRepository.save(rol);
    }
}
