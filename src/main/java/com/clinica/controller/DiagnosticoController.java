
import com.clinica.domain.Diagnostico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@Controller
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping("/{clienteId}")
    public String listarDiagnosticos(@PathVariable("clienteId") int clienteId, Model model) {
        List<Diagnostico> diagnosticos = diagnosticoService.obtenerDiagnosticosPorCliente(clienteId);
        model.addAttribute("diagnosticos", diagnosticos);
        return "listado-diagnosticos";
    }
}