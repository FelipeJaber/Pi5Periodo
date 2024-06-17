package com.pi.Models.Order;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    private UUID orderId;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
    @Column(name = "complement", nullable = false)
    private String complement;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "state", nullable = false)
    private String state;

}
