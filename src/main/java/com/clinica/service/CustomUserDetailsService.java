package com.clinica.service;

import com.clinica.dao.UsuarioDao;
import com.clinica.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByCorreo(correo);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con correo: " + correo);
        }

        String rol = usuario.getTipo().name(); // "Administrador", "Cliente", etc.

        return new User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                Collections.singletonList(new SimpleGrantedAuthority(rol))
        );
    }
}
