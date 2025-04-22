//package com.clinica.controller;

//import com.clinica.domain.Usuario;
//import com.clinica.service.LoginService;
//mport org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;

//@Controller
//public class LoginController {

 //   @Autowired
 //   private LoginService loginService;

    // Página inicial: formulario de login
 //   @GetMapping("/")
 //   public String loginPage() {
 //       return "login/login"; // login.html dentro de carpeta login/
 //   }

    // Procesamiento del formulario de login
  //  @PostMapping("/api/login")
  //  public String login(@RequestParam String correo,
   //                     @RequestParam String contrasena,
  //                      Model model) {

  //      Usuario usuario = loginService.login(correo, contrasena);

   //     if (usuario != null) {
  //          model.addAttribute("usuario", usuario);
   //         return "redirect:/index"; // Redirige a la vista principal
  //      }

  //      model.addAttribute("error", "Credenciales incorrectas.");
 //       return "login/login";
 //   }
//}