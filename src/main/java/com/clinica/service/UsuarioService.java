package com.clinica.service;

import com.clinica.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getUsuarios();
    Usuario getUsuarioById(Long idUsuario);
    void save(Usuario usuario);
    void delete(Usuario usuario);
}