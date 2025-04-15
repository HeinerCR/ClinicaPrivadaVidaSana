package com.clinica.service;

import com.clinica.domain.Usuario;

public interface LoginService {
    Usuario login(String correo, String contrasena);
}