package com.pi.Models.Cart;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_cart")
public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id", nullable = false, unique = true, updatable = false)
    private UUID cartId;
    @Column(name = "cart_type", nullable = false, unique = true, updatable = false)
    private String type;
}
