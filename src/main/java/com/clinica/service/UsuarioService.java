package com.clinica.service;

import java.util.List;
import com.clinica.domain.Usuario;

public interface UsuarioService {

    // Se obtiene un listado de todos los usuarios
    public List<Usuario> getUsuarios();

    // Se obtiene un Usuario, a partir del id de un usuario
    public Usuario getUsuario(Usuario usuario);

    // Se inserta un nuevo usuario si el id del usuario está vacío
    // Se actualiza un usuario si el id del usuario NO está vacío
    public void save(Usuario usuario);

    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Usuario usuario);
}
