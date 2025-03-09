package com.clinica.service;
 
import java.util.List;
 import com.clinica.domain.Cliente;

public interface ClienteService {
 
    // Se obtiene un listado de usuarios en un List
    public List<Cliente> getClientes(boolean activos);
 
    // Se obtiene un Cliente, a partir del id de un usuario
    public Cliente getCliente(Cliente usuario);
 
    // Se inserta un nuevo usuario si el id del usuario está vacío
    // Se actualiza un usuario si el id del usuario NO está vacío
    public void save(Cliente usuario);
 
    // Se elimina el usuario que tiene el id pasado por parámetro
    public void delete(Cliente usuario);
}