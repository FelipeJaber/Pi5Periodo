package com.pi.Records.Cart;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCartRecord(@NotNull @NotBlank String type) {
}
