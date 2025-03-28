package com.clinica.controller;

import com.clinica.domain.Cita;
import com.clinica.service.CitaService;
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
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Cita> citas = citaService.getCitas();
        model.addAttribute("citas", citas);
        model.addAttribute("totalCitas", citas.size());
        return "/citas/listado"; // Aquí podría estar el problema
    }

    @GetMapping("/nuevo")
    public String citaNuevo(Model model) {
        model.addAttribute("cita", new Cita());
        return "/citas/nuevo";
    }

    @PostMapping("/guardar")
    public String citaGuardar(Cita cita) {
        citaService.save(cita);
        return "redirect:/citas/listado";
    }

    @GetMapping("/eliminar/{idCita}")
    public String citaEliminar(@PathVariable("idCita") Long idCita) {
        citaService.delete(new Cita(idCita));
        return "redirect:/citas/listado";
    }

    @GetMapping("/modificar/{idCita}")
    public String citaModificar(@PathVariable("idCita") Long idCita, Model model) {
        Cita cita = citaService.getCitaById(idCita);
        if (cita == null) {
            return "redirect:/citas/listado";
        }
        model.addAttribute("cita", cita);
        return "/citas/modifica";
    }
}
