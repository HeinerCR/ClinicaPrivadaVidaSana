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

    // Registro de usuarios (mantiene el endpoint existente)
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario); // Guarda el usuario utilizando el método save
        return "redirect:/";
    }

    // Listado de usuarios (mantiene el endpoint existente)
    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "/usuario/listado";
    }

    // Eliminar usuario (mantiene el endpoint existente, usa POST)
    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long idUsuario) {
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        if (usuario != null) {
            usuarioService.delete(usuario);
        }
        return "redirect:/usuario/listado";
    }

    // Mostrar formulario de registro (mantiene el endpoint existente)
    @GetMapping("/registrar")
    public String mostrarFormularioRegistro() {
        return "registrar"; // Nombre del archivo en src/main/resources/templates
    }

    // Mostrar formulario para modificar un usuario existente
    @GetMapping("/modificar/{idUsuario}")
    public String mostrarFormularioModificar(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        if (usuario == null) {
            return "redirect:/usuario/listado"; // Redirige si el usuario no existe
        }
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica"; // Nombre del archivo del formulario de edición
    }

    // Guardar un nuevo usuario O actualizar uno existente
    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario) {
        usuarioService.save(usuario); // El método save debería manejar tanto la creación como la actualización
        return "redirect:/usuario/listado";
    }
}