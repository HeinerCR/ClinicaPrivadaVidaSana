package com.clinica.dao;

import com.clinica.domain.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoDao extends JpaRepository<Diagnostico, Long> {
}