package com.clinica.dao;

import com.clinica.domain.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface LaboratorioDao extends JpaRepository<Laboratorio, Long> {
}
