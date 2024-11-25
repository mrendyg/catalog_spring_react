package com.agarciao.backcatalog.controller.user;

import com.agarciao.backcatalog.service.user.LoginRequest;
import com.agarciao.backcatalog.service.user.UserDetailsServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // Endpoint para autenticar al usuario
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Crear un token de autenticación con el nombre de usuario y la contraseña
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        // Autenticar el token
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Establecer el contexto de seguridad para el usuario autenticado
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Respuesta exitosa (puedes personalizar esto, agregar un JWT, etc.)
        return "Usuario autenticado con éxito";
    }



}
