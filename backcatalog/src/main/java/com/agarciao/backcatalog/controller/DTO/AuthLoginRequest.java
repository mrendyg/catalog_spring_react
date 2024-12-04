package com.agarciao.backcatalog.controller.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record AuthLoginRequest(@NotBlank String username,
                               @NonNull String password) {
}
