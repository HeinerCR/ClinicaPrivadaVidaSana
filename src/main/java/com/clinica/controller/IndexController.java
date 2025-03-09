
package com.clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class IndexController {
 
    // Ruta principal (home)
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");  // Si necesitas pasar algún atributo, puedes hacerlo aquí
        return "index";  // Redirige a la vista index.html
    }
    // Ruta para la información
    @RequestMapping("/informacion")
    public String contacto(Model model) {
        return "informacion";  // Redirige a la vista informacion.html
    }
 
}