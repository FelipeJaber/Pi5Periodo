package com.pi.Records.Shop;

import com.pi.Models.ProductModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record BuyItensRecord(@NotNull @NotBlank List<ProductModel> products) {
}
