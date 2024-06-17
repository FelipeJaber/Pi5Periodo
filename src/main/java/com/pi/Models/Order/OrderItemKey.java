package com.pi.Models.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class OrderItemKey {
    @Column(name = "user_id", nullable = false)
    private UUID userId;
    @Column(name = "order_item_id", nullable = false)
    private UUID orderItemId;
    @Column(name = "order_id", nullable = false)
    private UUID orderId;
}
