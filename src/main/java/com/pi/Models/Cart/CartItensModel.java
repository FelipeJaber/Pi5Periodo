package com.pi.Models.Cart;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "tb_cart_itens")
public class CartItensModel {
    @EmbeddedId
    @Column(unique = true, nullable = false)
    private CartItemKey cartItemKey;
    @Column(name = "item_quantity", nullable = false)
    private int itemQuantity;
    @Column(name = "cart_id", nullable = false)
    private UUID cartId;
}
