package com.agarciao.backcatalog.controller.user;

import com.agarciao.backcatalog.service.user.LoginRequest;
import com.agarciao.backcatalog.service.user.UserDetailsServiceImpl;
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

    // Endpoint to authenticate the user
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Create an authentication token with the username and password
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        //Authenticate the token
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // Set the security context for the authenticated user
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Successful answer
        return "Usuario autenticado con éxito";
    }



}
