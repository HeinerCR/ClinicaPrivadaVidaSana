package com.clinica.serviceimpl;

import com.clinica.dao.DiagnosticoDao;
import com.clinica.domain.Diagnostico;
import com.clinica.service.DiagnosticoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoDao diagnosticoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Diagnostico> getDiagnosticos() {
        return diagnosticoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Diagnostico getDiagnosticoById(Long idDiagnostico) {
        return diagnosticoDao.findById(idDiagnostico).orElse(null);
    }

    @Override
    @Transactional
    public void save(Diagnostico diagnostico) {
        diagnosticoDao.save(diagnostico);
    }

    @Override
    @Transactional
    public void delete(Diagnostico diagnostico) {
        diagnosticoDao.delete(diagnostico);
    }
}