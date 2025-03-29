
import com.clinica.domain.Diagnostico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@Repository
public interface DiagnosticoDao extends JpaRepository<Diagnostico, Integer> {
    List<Diagnostico> findByClienteId(int clienteId);
}
