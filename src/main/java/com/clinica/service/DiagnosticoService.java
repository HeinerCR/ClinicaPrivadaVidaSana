package com.clinica.service;

import com.clinica.domain.Diagnostico;
import com.clinica.domain.Usuario;
import java.util.List;

public interface DiagnosticoService {

    List<Diagnostico> getDiagnosticos();
    Diagnostico getDiagnosticoById(Long id);
    void save(Diagnostico diagnostico);
    void delete(Diagnostico diagnostico);
    List<Usuario> getTodosUsuarios();

}