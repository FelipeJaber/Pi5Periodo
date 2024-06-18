package com.pi.Services.Order.CreateOrderService;

import com.pi.Models.Order.OrderModel;
import com.pi.Records.Order.CreateOrderRecord;
import com.pi.Repositories.OrderRepository;

public class CreateOrderService implements iCreateOrderServices{

    OrderRepository orderRepository;


    public void createOrder(CreateOrderRecord createOrderRecord) throws Exception{
        createNewOrder(createOrderRecord);
    }

    private void createNewOrder(CreateOrderRecord createOrderRecord) throws Exception{
        OrderModel orderModel = new OrderModel();
        orderModel.setState(createOrderRecord.state());
        orderModel.setComplement(createOrderRecord.complement());
        orderModel.setCountry(createOrderRecord.country());
        orderModel.setPostalCode(createOrderRecord.postalCode());
        orderModel.setStatus("CREATED");
        orderRepository.save(orderModel);
    }

}
