package com.clinica.service;

import com.clinica.domain.Diagnostico;
import java.util.List;

public interface DiagnosticoService {

    List<Diagnostico> getDiagnosticos();
    Diagnostico getDiagnosticoById(Long idDiagnostico);
    void save(Diagnostico diagnostico);
    void delete(Diagnostico diagnostico);
}