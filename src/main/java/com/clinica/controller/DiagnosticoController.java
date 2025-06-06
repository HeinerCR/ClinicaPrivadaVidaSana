package com.clinica.controller;

import com.clinica.domain.Diagnostico;
import com.clinica.service.DiagnosticoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Diagnostico> diagnosticos = diagnosticoService.getDiagnosticos();
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("totalDiagnosticos", diagnosticos.size());
        return "/diagnosticos/listado";
    }

    @GetMapping("/nuevo")
    public String diagnosticoNuevo(Model model) {
        model.addAttribute("diagnostico", new Diagnostico());
        return "/diagnosticos/nuevo";
    }

    @PostMapping("/guardar")
    public String guardarDiagnostico(@ModelAttribute Diagnostico diagnostico) {
        System.out.println("Diagnóstico guardado: " + diagnostico);
        return "redirect:/diagnosticos/listado"; 
    }

    @GetMapping("/eliminar/{id}")
    public String diagnosticoEliminar(@PathVariable("id") Long id) {
        diagnosticoService.delete(new Diagnostico(id));
        return "redirect:/diagnosticos/listado";
    }

    @GetMapping("/modificar/{id}")
    public String diagnosticoModificar(@PathVariable("id") Long id, Model model) {
        Diagnostico diagnostico = diagnosticoService.getDiagnosticoById(id);
        if (diagnostico == null) {
            return "redirect:/diagnosticos/listado";
        }
        model.addAttribute("diagnostico", diagnostico);
        return "/diagnosticos/modifica";
    }
}
