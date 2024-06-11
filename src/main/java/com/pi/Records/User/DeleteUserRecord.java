package com.pi.Records.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DeleteUserRecord(@NotBlank @NotNull String token) {
}