package com.pi.Services.Order.UpdateOrderService;

import com.pi.Models.Order.OrderModel;
import com.pi.Records.Order.UpdateOrderRecord;
import com.pi.Repositories.OrderRepository;

import java.util.Optional;
import java.util.UUID;

public class UpdateOrderService implements iUpdateOrderServices{
    OrderRepository orderRepository;
    @Override
    public void updateOrder(UpdateOrderRecord updateOrderRecord, UUID orderID) throws Exception {
        changeOrder(updateOrderRecord, orderID);
    }

    private void changeOrder(UpdateOrderRecord updateOrderRecord, UUID orderID) throws Exception {
        Optional<OrderModel> dbOrderModel = orderRepository.findById(orderID);
    }
}
