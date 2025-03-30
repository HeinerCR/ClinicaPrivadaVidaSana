package com.clinica.controller;

import com.clinica.domain.Laboratorio;
import com.clinica.service.LaboratorioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Laboratorio> laboratorios = laboratorioService.getLaboratorios();
        model.addAttribute("laboratorios", laboratorios);
        model.addAttribute("totalLaboratorios", laboratorios.size());
        return "/laboratorios/listado";
    }

    @GetMapping("/nuevo")
    public String laboratorioNuevo(Model model) {
        model.addAttribute("laboratorio", new Laboratorio());
        return "/laboratorios/nuevo";
    }

    @PostMapping("/guardar")
    public String laboratorioGuardar(Laboratorio laboratorio) {
        laboratorioService.save(laboratorio);
        return "redirect:/laboratorios/listado";
    }

    @GetMapping("/eliminar/{idLaboratorio}")
    public String laboratorioEliminar(@PathVariable("idLaboratorio") Long idLaboratorio) {
        laboratorioService.delete(new Laboratorio(idLaboratorio));
        return "redirect:/laboratorios/listado";
    }

    @GetMapping("/modificar/{idLaboratorio}")
    public String laboratorioModificar(@PathVariable("idLaboratorio") Long idLaboratorio, Model model) {
        Laboratorio laboratorio = laboratorioService.getLaboratorioById(idLaboratorio);
        if (laboratorio == null) {
            return "redirect:/laboratorios/listado";
        }
        model.addAttribute("laboratorio", laboratorio);
        return "/laboratorios/modifica";
    }
}
