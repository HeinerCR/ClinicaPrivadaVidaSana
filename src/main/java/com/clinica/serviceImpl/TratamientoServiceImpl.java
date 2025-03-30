package com.clinica.serviceimpl;

import com.clinica.dao.TratamientoDao;
import com.clinica.domain.Tratamiento;
import com.clinica.service.TratamientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoDao tratamientoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tratamiento> getTratamientos() {
        return tratamientoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tratamiento getTratamientoById(Long idTratamiento) {
        return tratamientoDao.findById(idTratamiento).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tratamiento tratamiento) {
        tratamientoDao.save(tratamiento);
    }

    @Override
    @Transactional
    public void delete(Tratamiento tratamiento) {
        tratamientoDao.delete(tratamiento);
    }
}