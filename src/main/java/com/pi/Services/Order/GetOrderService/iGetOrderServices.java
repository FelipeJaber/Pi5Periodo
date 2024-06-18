package com.pi.Services.Order.GetOrderService;

import com.pi.Records.Order.GetOrderRecord;

import java.util.UUID;

public interface iGetOrderServices {

    public String getOrder(GetOrderRecord getOrderRecord, UUID orderID) throws Exception;
}
