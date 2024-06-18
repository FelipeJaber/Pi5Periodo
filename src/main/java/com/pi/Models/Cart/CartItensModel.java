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

    public CartItensModel(CartItemKey cartItemKey, int itemQuantity, UUID cartId) {
        this.cartItemKey = cartItemKey;
        this.itemQuantity = itemQuantity;
        this.cartId = cartId;
    }

    @Column(name = "item_quantity", nullable = false)
    private int itemQuantity;
    @Column(name = "cart_id", nullable = false)
    private UUID cartId;

    public CartItemKey getCartItemKey() {
        return cartItemKey;
    }

    public void setCartItemKey(CartItemKey cartItemKey) {
        this.cartItemKey = cartItemKey;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }
}
