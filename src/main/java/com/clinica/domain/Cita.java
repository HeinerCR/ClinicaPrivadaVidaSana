package com.clinica.domain;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "citas")
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcita")
    private Long idCita;

    @Column(name = "idusuario", nullable = false)
    private Long idUsuario;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoCita estado;

    public enum EstadoCita {
        Pendiente, Confirmada, Cancelada
    }

    // Constructores
    public Cita() {
    }

    public Cita(Long idCita) {
        this.idCita = idCita;
    }

    public Cita(Long idUsuario, LocalDateTime fecha, EstadoCita estado) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.estado = estado;
    }
}
