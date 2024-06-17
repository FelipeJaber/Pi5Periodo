package com.pi.Models.Order;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_itens")
public class OrderItensModel {
    @EmbeddedId
    private OrderItemKey orderItemKey;
    @Column(name = "quantity", updatable = false, nullable = false)
    private int quantity;
}
