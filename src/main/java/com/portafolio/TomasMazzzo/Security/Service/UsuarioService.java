/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Security.Service;

import com.portafolio.TomasMazzzo.Security.Entity.Usuario;
import com.portafolio.TomasMazzzo.Security.Repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existByMail(String mail) {
        return iusuarioRepository.existsByMail(mail);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
