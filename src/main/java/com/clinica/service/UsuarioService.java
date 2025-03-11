package com.clinica.service;

import java.util.List;
import com.clinica.domain.Usuario;

public interface UsuarioService {

    public List<Usuario> getUsuarios();
    public Usuario getUsuarioById(Long idUsuario);
    public void save(Usuario usuario);
    public void delete(Usuario usuario);
}
