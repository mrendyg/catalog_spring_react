package com.agarciao.backcatalog.service.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Clase interna para mapear el JSON de la solicitud
public class LoginRequest {
    private String username;
    private String password;
}