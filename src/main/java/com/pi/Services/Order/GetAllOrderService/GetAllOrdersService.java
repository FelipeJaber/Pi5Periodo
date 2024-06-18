package com.pi.Services.Order.GetAllOrderService;

import com.google.gson.Gson;
import com.pi.Models.Order.OrderModel;
import com.pi.Records.Order.GetAllOrdersRecord;

import com.pi.Repositories.OrderRepository;

import java.util.List;

public class GetAllOrdersService implements iGetAllOrderServices{

    OrderRepository orderRepository;
    Gson gson;

    @Override
    public String getAllOrders(GetAllOrdersRecord getAllOrdersRecord)throws Exception{
        return getAllOrdersInfo();
    }

    private String getAllOrdersInfo() throws Exception{
        List<OrderModel> dbOrderModel = orderRepository.findAll();
        if(dbOrderModel.isEmpty())throw new Exception("ORDER NOT FOUND");
        return gson.toJson(dbOrderModel);
    }
}
