package com.clinica.dao;

import com.clinica.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {
    // Puedes agregar métodos personalizados si es necesario
}