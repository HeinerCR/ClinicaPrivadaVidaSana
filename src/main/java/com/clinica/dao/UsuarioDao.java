package com.clinica.dao;

import com.clinica.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
