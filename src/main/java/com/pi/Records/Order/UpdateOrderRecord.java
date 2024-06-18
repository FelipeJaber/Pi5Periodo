package com.pi.Records.Order;

import com.pi.Models.Order.OrderItensModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UpdateOrderRecord(@NotNull @NotBlank List<OrderItensModel> orderItens, @NotNull @NotBlank String status, @NotNull @NotBlank String postalCode, @NotNull @NotBlank String complement, @NotNull @NotBlank String country, @NotNull @NotBlank String state) {
}
