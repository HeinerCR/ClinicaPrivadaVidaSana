//package com.clinica.serviceimpl;

//import com.clinica.dao.UsuarioDao;
//import com.clinica.domain.Usuario;
//import com.clinica.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;

//@Service
//public class LoginServiceImpl implements LoginService {

//    @Autowired
//    private UsuarioDao usuarioDao;

//    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  // Usamos el PasswordEncoder

//    @Override
 //   public Usuario login(String correo, String contrasena) {
//        // Busca al usuario por correo en la base de datos
//        Usuario usuario = usuarioDao.findByCorreo(correo);

        // Verifica que el usuario existe y que la contraseña es válida
 //       if (usuario != null && passwordEncoder.matches(contrasena, usuario.getContrasena())) {
 //           return usuario; // Retorna el usuario si las credenciales son correctas
 //       }

 //       return null; // Retorna null si las credenciales son inválidas
 //   }
//}
