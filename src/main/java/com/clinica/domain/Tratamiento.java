package com.clinica.domain;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "tratamientos")
public class Tratamiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtratamiento")
    private Long idtratamiento;

    @Column(name = "idusuario", nullable = false)
    private Long idUsuario;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDateTime fecha_inicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDateTime fecha_fin;

    // Constructores
    public Tratamiento() {
    }

    public Tratamiento(Long idtratamiento) {
        this.idtratamiento = idtratamiento;
    }

    public Tratamiento(Long idUsuario, String descripcion, LocalDateTime fecha_inicio, LocalDateTime fecha_fin) {
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
}
