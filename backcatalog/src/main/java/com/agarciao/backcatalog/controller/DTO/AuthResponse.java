package com.agarciao.backcatalog.controller.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "message", "date", "jwt"})
public record AuthResponse (
        String username,
        String message,
        String date,
        String jwt,
        Boolean status) {
}
