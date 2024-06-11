package com.pi.Records.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterUserRecord(@NotNull @NotBlank String name, @NotNull @NotBlank String phone, @NotNull @NotBlank String role, @NotNull @NotBlank String passWord, @NotNull @NotBlank String cpf) {
}
