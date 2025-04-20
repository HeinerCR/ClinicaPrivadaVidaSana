package com.clinica.config;

import com.clinica.service.CustomUserDetailsService; // Asegúrate de que esta importación esté presente
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService; // ¡Esta línea debe estar DESCOMENTADA!

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // ... otras configuraciones que puedas tener
            .userDetailsService(customUserDetailsService); // ¡Esta línea debe estar DESCOMENTADA!
            // ... el resto de tu configuración
        return http.build();
    }

    // ... el resto de tu código (passwordEncoder, etc.) pueden seguir comentados por ahora
}