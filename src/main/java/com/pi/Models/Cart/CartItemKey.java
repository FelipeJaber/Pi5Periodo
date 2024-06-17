package com.pi.Models.Cart;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CartItemKey {

    @Column(name = "user_id", nullable = false)
    private UUID userId;
    @Column(name = "item_id", nullable = false)
    private UUID itemId;
}
