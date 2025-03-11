package com.clinica.domain;
 
import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;
 
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idUsuario;
    private String nombre;
    private Integer edad;
    private String cedula;
    private String correo;
    private String contrasena;
    private String telefono;
 
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoUsuario tipo; // Usamos un enum para el tipo de usuario
 
    public enum TipoUsuario {
        Cliente, Medico
    }
 
    public Usuario() {
    }
 
    public Usuario(String nombre, Integer edad, String cedula, String correo, String contrasena, String telefono, TipoUsuario tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipo = tipo;
    }
}