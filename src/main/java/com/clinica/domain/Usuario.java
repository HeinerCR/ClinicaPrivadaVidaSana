package com.clinica.domain;
 
import lombok.Data;
import java.io.Serializable;
import jakarta.persistence.*;
 
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
 
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
 
    @Column(name = "edad")
    private Integer edad;
 
    @Column(name = "cedula", nullable = false, unique = true, length = 20)
    private String cedula;
 
    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;
 
    @Column(name = "contrasena", nullable = false, length = 255)
    private String contrasena;
 
    @Column(name = "telefono", length = 15)
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