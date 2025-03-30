package com.clinica.serviceimpl;

import com.clinica.dao.LaboratorioDao;
import com.clinica.domain.Laboratorio;
import com.clinica.service.LaboratorioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LaboratorioServiceImpl implements LaboratorioService {

    @Autowired
    private LaboratorioDao laboratorioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Laboratorio> getLaboratorios() {
        return laboratorioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Laboratorio getLaboratorioById(Long idLaboratorio) {
        return laboratorioDao.findById(idLaboratorio).orElse(null);
    }

    @Override
    @Transactional
    public void save(Laboratorio laboratorio) {
        laboratorioDao.save(laboratorio);
    }

    @Override
    @Transactional
    public void delete(Laboratorio laboratorio) {
        laboratorioDao.delete(laboratorio);
    }
}