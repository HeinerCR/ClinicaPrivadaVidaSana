package com.clinica.controller;

import com.clinica.domain.Tratamiento;
import com.clinica.service.TratamientoService;
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
@RequestMapping("/tratamientos")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Tratamiento> tratamientos = tratamientoService.getTratamientos();
        model.addAttribute("tratamientos", tratamientos);
        model.addAttribute("totalTratamientos", tratamientos.size());
        return "/tratamientos/listado";
    }

    @GetMapping("/nuevo")
    public String tratamientoNuevo(Model model) {
        model.addAttribute("tratamiento", new Tratamiento());
        return "/tratamientos/nuevo";
    }

    @PostMapping("/guardar")
    public String tratamientoGuardar(Tratamiento tratamiento) {
        tratamientoService.save(tratamiento);
        return "redirect:/tratamientos/listado";
    }

    @GetMapping("/eliminar/{idTratamiento}")
    public String tratamientoEliminar(@PathVariable("idTratamiento") Long idTratamiento) {
        tratamientoService.delete(new Tratamiento(idTratamiento));
        return "redirect:/tratamientos/listado";
    }

    @GetMapping("/modificar/{idTratamiento}")
    public String tratamientoModificar(@PathVariable("idTratamiento") Long idTratamiento, Model model) {
        Tratamiento tratamiento = tratamientoService.getTratamientoById(idTratamiento);
        if (tratamiento == null) {
            return "redirect:/tratamientos/listado";
        }
        model.addAttribute("tratamiento", tratamiento);
        return "/tratamientos/modifica";
    }
}