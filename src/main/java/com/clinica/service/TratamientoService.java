package com.clinica.service;

import java.util.List;
import com.clinica.domain.Tratamiento;

public interface TratamientoService {

    public List<Tratamiento> getTratamientos();
    public Tratamiento getTratamientoById(Long idTratamiento);
    public void save(Tratamiento tratamiento);
    public void delete(Tratamiento tratamiento);
}
