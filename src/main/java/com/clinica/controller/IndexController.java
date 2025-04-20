package com.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String page(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido a la Clínica!");
        return "index";
    }
}
