package com.pi.Records.Cart;

import com.pi.Models.Cart.CartItensModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record UpdateCartRecord(@NotNull @NotBlank List<CartItensModel> productList, UUID cart_id) {
}
