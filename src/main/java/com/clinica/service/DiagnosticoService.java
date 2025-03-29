
import com.clinica.domain.Diagnostico;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public interface DiagnosticoService {
    List<Diagnostico> obtenerDiagnosticosPorCliente(int clienteId);
}
