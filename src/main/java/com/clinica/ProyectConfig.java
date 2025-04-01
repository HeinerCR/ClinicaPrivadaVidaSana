package com.clinica;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProyectConfig implements WebMvcConfigurer {

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

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/Login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");

    }

    /* El siguiente método se utiliza para completar la clase no es 
    realmente funcional, la próxima semana se reemplaza con usuarios de BD */
  //  @Bean
  //  public UserDetailsService users() {
//        UserDetails admin = User.builder()
  //              .username("juan")
  //              .password("{noop}123")
  //              .roles("Usuario", "Medico", "Administrador")
  //              .build();
  //      UserDetails sales = User.builder()
  //              .username("rebeca")
  //              .password("{noop}456")
  //              .roles("Usuario", "Medico")
  //              .build();
  //      UserDetails user = User.builder()
  //              .username("pedro")
  //              .password("{noop}789")
  //              .roles("Usuario")
  //              .build();
  //      return new InMemoryUserDetailsManager(user, sales, admin);
  //  }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((request) -> request
//                .requestMatchers("/", "/index", "/errores/**", "/error",
//                        "/carrito/**", "/pruebas/**", "/reportes/**",
//                        "/registro/**", "/js/**", "/webjars/**")
//                .permitAll()
//                .requestMatchers(
//                        "/producto/nuevo", "/producto/guardar",
//                        "/producto/modificar/**", "/producto/eliminar/**",
//                        "/categoria/nuevo", "/categoria/guardar",
//                        "/categoria/modificar/**", "/categoria/eliminar/**",
//                        "/usuario/nuevo", "/usuario/guardar",
//                        "/usuario/modificar/**", "/usuario/eliminar/**",
//                        "/reportes/**"
//                ).hasRole("Administrador")
//                .requestMatchers(
//                        "/producto/listado",
//                        "/categoria/listado",
//                        "/usuario/listado"
//                ).hasAnyRole("Medico", "Admin")
//                .requestMatchers("/facturar/carrito")
//                .hasRole("Usuario")
//                )
//                .formLogin((form) -> form
//                .loginPage("/login").permitAll())
//                .logout((logout) -> logout.permitAll());
//        return http.build();
//    }
}
