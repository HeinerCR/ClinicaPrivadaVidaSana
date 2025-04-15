package com.clinica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            .requestMatchers("/", "/api/login", "/static/**", "/images/**").permitAll() // Permitir acceso sin autenticar
            .requestMatchers("/usuario/**", "/tratamientos/**", "/diagnosticos/**", "/laboratorios/**").hasAuthority("Administrador") // Solo Admin
            .requestMatchers("/usuario/mis-datos", "/tratamientos/mis-tratamientos", "/diagnosticos/mis-diagnosticos", "/laboratorios/mis-laboratorios").hasAnyAuthority("Cliente", "Medico") // Clientes y Médicos
            .anyRequest().authenticated() // Cualquier otra ruta requiere autenticación
            .and()
            .formLogin()
            .loginPage("/") // Página de login
            .defaultSuccessUrl("/index", true) // Redirección al login exitoso
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/") // Redirección al logout exitoso
            .permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Cifrado de contraseñas
    }
}