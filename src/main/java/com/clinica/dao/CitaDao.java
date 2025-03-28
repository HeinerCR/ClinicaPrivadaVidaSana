package com.clinica.dao;

import com.clinica.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CitaDao extends JpaRepository<Cita, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
