package com.pi.Services.Order.GetOrderService;

import com.google.gson.Gson;
import com.pi.Models.Order.OrderModel;
import com.pi.Records.Order.GetOrderRecord;
import com.pi.Repositories.OrderRepository;

import java.util.Optional;

public class GetOrderService implements iGetOrderServices{

    OrderRepository orderRepository;
    Gson gson;

    @Override
    public String getOrder(GetOrderRecord getOrderRecord) throws Exception {
        return getOrderInfos(getOrderRecord);
    }

    private String getOrderInfos(GetOrderRecord getOrderRecord) throws Exception{
        Optional<OrderModel> dbOrderModel = orderRepository.findById(getOrderRecord.orderId());
        if(dbOrderModel.isEmpty())throw new Exception("ORDER NOT FOUND");
        return gson.toJson(dbOrderModel.get());
    }

}
