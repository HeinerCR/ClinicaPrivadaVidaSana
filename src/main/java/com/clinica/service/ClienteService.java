package com.clinica.service;

import com.clinica.domain.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> obtenerTodosLosClientes();

    void guardarCliente(Cliente cliente);

    void registrarCliente(Cliente cliente);  // Método para registrar
}
