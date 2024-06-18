package com.pi.Services.Order.UpdateOrderService;

import com.pi.Records.Order.UpdateOrderRecord;

import java.util.UUID;

public interface iUpdateOrderServices {
    public void updateOrder(UpdateOrderRecord updateOrderRecord, UUID orderId)throws Exception;
}
