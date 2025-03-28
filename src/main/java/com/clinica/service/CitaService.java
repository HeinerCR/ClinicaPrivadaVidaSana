package com.clinica.service;

import java.util.List;
import com.clinica.domain.Cita;

public interface CitaService {

    public List<Cita> getCitas();
    public Cita getCitaById(Long idCita);
    public void save(Cita cita);
    public void delete(Cita cita);
}
