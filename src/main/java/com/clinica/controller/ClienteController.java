package com.clinica.controller;

import com.clinica.domain.Cliente;
import com.clinica.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping("/cliente")

public class ClienteController {

    @Autowired

    private ClienteService clienteService;

    @Autowired

    @GetMapping("/listado")

    public String listado(Model model) {

        List<Cliente> clientes = clienteService.getClientes(false);  // Cambia el método si es necesario

        model.addAttribute("clientes", clientes);

        model.addAttribute("totalClientes", clientes.size());

        return "/cliente/listado";  // Ruta donde se mostrarán los clientes

    }

    @GetMapping("/nuevo")

    public String clienteNuevo(Cliente cliente) {

        return "/cliente/modifica";  // Ruta para el formulario de creación

    }

    @PostMapping("/guardar")

    public String clienteGuardar(Cliente cliente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {

            clienteService.save(cliente);

        }

        clienteService.save(cliente);

        return "redirect:/cliente/listado";  // Redirige al listado de clientes

    }

    @GetMapping("/eliminar/{idCliente}")

    public String clienteEliminar(Cliente cliente) {

        clienteService.delete(cliente);

        return "redirect:/cliente/listado";  // Redirige al listado después de eliminar

    }

    @GetMapping("/modificar/{idCliente}")

    public String clienteModificar(Cliente cliente, Model model) {

        cliente = clienteService.getCliente(cliente);

        model.addAttribute("cliente", cliente);

        return "/cliente/modifica";  // Ruta para el formulario de modificación

    }

}
