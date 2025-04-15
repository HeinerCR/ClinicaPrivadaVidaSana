package com.clinica.controller;

import com.clinica.domain.Usuario;
import com.clinica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Registro de usuarios
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario); // Guarda el usuario
        return "redirect:/usuario/listado"; // Redirige al listado tras el registro exitoso
    }

    // Listado de usuarios
    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "/usuario/listado";
    }

    // Eliminar usuario
    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long idUsuario) {
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        if (usuario != null) {
            usuarioService.delete(usuario);
        }
        return "redirect:/usuario/listado";
    }
}