package com.clinica.domain;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "laboratorios")
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlaboratorio")
    private Long idlaboratorio;

    @Column(name = "idusuario", nullable = false)
    private Long idUsuario;

    @Column(name = "resultado", nullable = false)
    private String resultado;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    // Constructores
    public Laboratorio() {
    }

    public Laboratorio(Long idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public Laboratorio(Long idUsuario, LocalDateTime fecha, String resultado) {
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.resultado = resultado;
    }
}