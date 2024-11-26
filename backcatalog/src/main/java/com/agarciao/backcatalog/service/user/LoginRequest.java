package com.agarciao.backcatalog.service.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Internal class to map the JSON of the request
public class LoginRequest {
    private String username;
    private String password;
}