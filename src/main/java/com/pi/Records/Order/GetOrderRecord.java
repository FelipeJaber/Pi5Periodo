package com.pi.Records.Order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record GetOrderRecord(@NotBlank @NotNull UUID orderId) {
}
