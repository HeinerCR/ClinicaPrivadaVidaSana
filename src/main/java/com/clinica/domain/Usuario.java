package com.clinica.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario") // Vincula la entidad con la tabla "usuario" en la base de datos
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Clave primaria autoincremental
    @Column(name = "idusuario")
    private Long idUsuario;

    @Column(nullable = false, length = 100)
    private String nombre; // Nombre del usuario

    @Column(unique = true, nullable = false, length = 100)
    private String correo; // Correo electrónico único

    @Column(nullable = false)
    private String contrasena; // Contraseña del usuario (debe ser cifrada)

    @Column(nullable = true, length = 15)
    private String telefono; // Teléfono (opcional)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoUsuario tipo; // Tipo de usuario: Cliente, Médico o Administrador

    // Enumeración para definir los roles de usuario
    public enum TipoUsuario {
        Cliente,
        Medico,
        Administrador
    }
}