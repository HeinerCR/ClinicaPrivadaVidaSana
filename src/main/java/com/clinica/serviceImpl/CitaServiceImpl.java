package com.clinica.serviceimpl;

import com.clinica.dao.CitaDao;
import com.clinica.domain.Cita;
import com.clinica.service.CitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> getCitas() {
        return citaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cita getCitaById(Long idCita) {
        return citaDao.findById(idCita).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    @Transactional
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }
}