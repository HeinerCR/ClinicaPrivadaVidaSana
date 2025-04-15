package com.clinica.controller;

import com.clinica.domain.Usuario;
import com.clinica.service.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para manejar las solicitudes relacionadas con Usuarios.
 */
@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Lista todos los usuarios disponibles.
     *
     * @param model Modelo para pasar datos a la vista.
     * @return Página de listado de usuarios.
     */
    @GetMapping("/listado")
    public String listado(Model model) {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        log.info("Se cargó el listado de usuarios: {} usuarios encontrados", usuarios.size());
        return "/usuario/listado";
    }

    /**
     * Carga la página para crear un nuevo usuario.
     *
     * @param model Modelo para pasar un objeto vacío de Usuario.
     * @return Página de creación de nuevo usuario.
     */
    @GetMapping("/nuevo")
    public String usuarioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/usuario/nuevo";
    }

    /**
     * Guarda un usuario en la base de datos (nuevo o modificado).
     *
     * @param usuario Objeto Usuario con los datos ingresados.
     * @return Redirección al listado de usuarios.
     */
    @PostMapping("/guardar")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        log.info("Usuario guardado: {}", usuario);
        return "redirect:/usuario/listado";
    }

    /**
     * Elimina un usuario por su ID.
     *
     * @param idUsuario ID del usuario a eliminar.
     * @return Redirección al listado de usuarios.
     */
    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(@PathVariable("idUsuario") Long idUsuario) {
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        if (usuario != null) {
            usuarioService.delete(usuario);
            log.info("Usuario eliminado: {}", usuario);
        } else {
            log.warn("Intento de eliminar usuario con ID inexistente: {}", idUsuario);
        }
        return "redirect:/usuario/listado";
    }

    /**
     * Carga la página para modificar un usuario existente.
     *
     * @param idUsuario ID del usuario a modificar.
     * @param model Modelo para pasar el usuario encontrado.
     * @return Página de modificación de usuario.
     */
    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        if (usuario == null) {
            log.warn("Intento de modificar usuario con ID inexistente: {}", idUsuario);
            return "redirect:/usuario/listado";
        }
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}