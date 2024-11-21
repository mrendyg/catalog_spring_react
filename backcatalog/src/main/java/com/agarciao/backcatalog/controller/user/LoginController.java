package com.agarciao.backcatalog.controller.user;

import com.agarciao.backcatalog.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;


//
//    @GetMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    public String getLogin(){
//        return "hola";
//    }


}
