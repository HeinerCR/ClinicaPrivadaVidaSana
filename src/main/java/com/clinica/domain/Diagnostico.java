package com.clinica.domain;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "diagnosticos")
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddiagnostico")
    private Long iddiagnostico;

    @Column(name = "idusuario", nullable = false)
    private Long idUsuario;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    // Constructores
    public Diagnostico() {
    }

    public Diagnostico(Long iddiagnostico) {
        this.iddiagnostico = iddiagnostico;
    }

    public Diagnostico(Long idUsuario, LocalDateTime fecha, String descripcion) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
