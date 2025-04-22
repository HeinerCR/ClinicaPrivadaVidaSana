package com.clinica;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProyectConfig implements WebMvcConfigurer {

    // Configuración de internacionalización (se mantiene igual)
    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // Configuración de vistas
   // @Override
   // public void addViewControllers(ViewControllerRegistry registry) {
   //     registry.addViewController("/").setViewName("index");
   //     registry.addViewController("/index").setViewName("index");
   //     registry.addViewController("/login").setViewName("login/login"); // Ruta a tu template de login
   //     registry.addViewController("/registrar").setViewName("registrar");
   //     registry.addViewController("/acceso-denegado").setViewName("error/403");
   // }

    // Usuarios en memoria (actualizado para usar email como username)
  //  @Bean
  //  public UserDetailsService users() {
  //      UserDetails admin = User.builder()
  //              .username("admin@clinica.com") // Ahora usa un email como username
  //              .password("{noop}admin123")
  //              .roles("ADMINISTRADOR")
  //              .build();

  //      UserDetails medico = User.builder()
  //              .username("medico@clinica.com")
  //              .password("{noop}medico123")
  //              .roles("MEDICO")
 //               .build();

  //      UserDetails cliente = User.builder()
  //              .username("cliente@clinica.com")
 //               .password("{noop}cliente123")
  //              .roles("CLIENTE")
 //               .build();

 //       return new InMemoryUserDetailsManager(admin, medico, cliente);
 //   }


 //   @Bean
 //   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
 //               .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
  //                              "/",
 //                               "/index",
 //                               "/css/**",
 //                               "/js/**",
 //                               "/images/**",
 //                               "/webjars/**",
 //                               "/registrar",
 //                               "/error/**",
 //                               "/login"
 //                       ).permitAll()
 //                       .requestMatchers("/usuario/**", "/laboratorios/**", "/tratamientos/**", "/citas/**", "/diagnosticos/**").hasRole("ADMINISTRADOR")
 //                       .requestMatchers("/citas/modifica/**").hasAnyRole("MEDICO", "ADMINISTRADOR")
 //                       .requestMatchers("/citas/listado", "/tratamientos/listado").hasRole("CLIENTE")
  //                      .requestMatchers("/citas/listado", "/diagnostics/listado").authenticated()
  //                      .anyRequest().authenticated()
 //               )
//                .formLogin(form -> form
//                        .loginPage("/login")
 //                       .loginProcessingUrl("/login")
//                        .usernameParameter("correo")
 //                       .passwordParameter("contrasena")
 //                       .defaultSuccessUrl("/index", true)
 //                       .failureUrl("/login?error=true")
  //                      .permitAll()
 //               )
 //               .logout(logout -> logout
 //                       .logoutSuccessUrl("/login?logout")
 ///                       .permitAll()
 //               )
//                .exceptionHandling(ex -> ex
//                        .accessDeniedPage("/error/403")
//                );

 //       return http.build();
//    }
}