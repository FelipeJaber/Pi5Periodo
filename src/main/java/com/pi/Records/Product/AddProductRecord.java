package com.pi.Records.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddProductRecord(@NotNull @NotBlank String name, @NotNull @NotBlank String description, @NotNull float price, @NotNull int stock, @NotNull @NotBlank String section, @NotNull @NotBlank String token) {
}
