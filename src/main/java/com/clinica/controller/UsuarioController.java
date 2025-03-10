package com.clinica.controller;

import com.clinica.domain.Usuario;
import com.clinica.service.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/usuario")

public class UsuarioController {

    @Autowired

    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Usuario> usuarios = usuarioService.getUsuarios();  // No se necesita el parámetro activos
        System.out.println(usuarios);  // Depuración
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";  // Ruta donde se mostrarán los usuarios
    }

    @GetMapping("/nuevo")

    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";  // Ruta para el formulario de creación
    }

    @PostMapping("/guardar")
    public String usuarioGuardar(@ModelAttribute Usuario usuario, BindingResult result) {
        // Verifica si la validación del formulario tiene errores
        if (result.hasErrors()) {
            return "/usuario/listado"; // Devuelve el formulario con los errores
        }

        // Verifica que la contraseña no sea nula ni vacía
        if (usuario.getContrasena() == null || usuario.getContrasena().isEmpty()) {
            // Agrega un error al modelo si la contraseña está vacía
            result.rejectValue("contrasena", "error.usuario", "La contraseña es obligatoria");
            return "/usuario/listado"; // Devuelve el formulario con el error
        }

        // Guarda el usuario si todo está correcto
        usuarioService.save(usuario);
        return "redirect:/usuario/listado"; // Redirige al listado de usuarios
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";  // Redirige al listado después de eliminar

    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";  // Ruta para el formulario de modificación

    }

}
