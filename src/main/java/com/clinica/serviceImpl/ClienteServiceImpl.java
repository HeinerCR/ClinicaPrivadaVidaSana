package com.clinica.serviceImpl;

import com.clinica.dao.ClienteDao;
import com.clinica.domain.Cliente;
import com.clinica.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)  // Solo lectura, no modifica la base de datos
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDao.findAll();  // Obtiene todos los clientes
    }

    @Override
    @Transactional
    public void guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);  // Guarda o actualiza el cliente
    }

    @Override
    @Transactional
    public void registrarCliente(Cliente cliente) {
        // Puedes agregar lógica adicional si es necesario
        clienteDao.save(cliente);  // Guarda el cliente
    }
}
