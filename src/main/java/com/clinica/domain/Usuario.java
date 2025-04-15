package com.clinica.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario") // Mapea la tabla "usuario" en la base de datos
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario") // Mapeo correcto con el nombre de la columna en la base de datos
    private Long idUsuario;

    private String nombre;       // Nombre del usuario
    private Integer edad;        // Edad del usuario
    private String cedula;       // Cédula única del usuario
    private String correo;       // Correo electrónico del usuario
    private String contrasena;   // Contraseña del usuario
    private String telefono;     // Teléfono de contacto

    @Enumerated(EnumType.STRING) // Almacena el tipo de usuario como texto en la base de datos
    private TipoUsuario tipo;    // Tipo de usuario: Cliente, Medico o Administrador

    // Enumeración para tipo de usuario
    public enum TipoUsuario {
        Cliente, Medico, Administrador
    }
}