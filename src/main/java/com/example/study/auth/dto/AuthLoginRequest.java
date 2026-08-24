package com.example.study.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthLoginRequest(

        @NotBlank
        @Size(min = 2, max = 20)
        String username,

        @NotBlank
        @Size(min = 2, max = 20)
        String password
) {
}
