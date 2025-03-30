package com.clinica.dao;

import com.clinica.domain.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface TratamientoDao extends JpaRepository<Tratamiento, Long> {
}
