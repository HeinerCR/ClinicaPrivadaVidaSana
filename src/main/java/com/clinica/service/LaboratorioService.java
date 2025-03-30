package com.clinica.service;

import java.util.List;
import com.clinica.domain.Laboratorio;

public interface LaboratorioService {

    public List<Laboratorio> getLaboratorios();
    public Laboratorio getLaboratorioById(Long idLaboratorio);
    public void save(Laboratorio laboratorio);
    public void delete(Laboratorio laboratorio);
}
