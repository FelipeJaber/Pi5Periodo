package com.pi.Records.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateProductRecord(@NotNull @NotBlank String name, @NotNull @NotBlank String description, @NotNull @NotBlank float price, @NotNull @NotBlank int stock, @NotNull @NotBlank String section, @NotNull @NotBlank String token) {
}
