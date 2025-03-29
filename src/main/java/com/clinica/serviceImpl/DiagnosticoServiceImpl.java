
import com.clinica.domain.Diagnostico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoDao diagnosticoDao;

    @Override
    public List<Diagnostico> obtenerDiagnosticosPorCliente(int clienteId) {
        return diagnosticoDao.findByClienteId(clienteId);
    }
}