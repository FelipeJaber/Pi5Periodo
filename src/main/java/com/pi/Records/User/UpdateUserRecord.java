package com.pi.Records.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRecord(@NotBlank @NotNull String token, @NotNull @NotBlank String nome, @NotNull @NotBlank String phone, @NotNull @NotBlank String passWord, @NotNull @NotBlank String role) {
}
