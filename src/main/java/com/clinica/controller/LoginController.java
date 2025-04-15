package com.clinica.controller;

import com.clinica.domain.Usuario;
import com.clinica.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Carga la página de login
    @GetMapping("/")
    public String loginPage() {
        return "login"; // Retorna la vista del formulario de login
    }

    // Maneja el envío del formulario de login
    @PostMapping("/api/login")
    public String login(@RequestParam String correo, @RequestParam String contrasena, Model model) {
        // Autentica al usuario mediante el servicio de login
        Usuario usuario = loginService.login(correo, contrasena);

        if (usuario != null) {
            // Si las credenciales son válidas, redirige al índice
            model.addAttribute("usuario", usuario);
            return "redirect:/index"; // Redirige a la página principal
        }

        // Si las credenciales son inválidas, muestra un error
        model.addAttribute("error", "Credenciales incorrectas.");
        return "login"; // Regresa al formulario de login
    }
}