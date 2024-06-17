package com.pi.Controllers;

import com.pi.Records.Order.CreateOrderRecord;
import com.pi.Records.Order.GetAllOrdersRecord;
import com.pi.Records.Order.GetOrderRecord;
import com.pi.Records.Order.UpdateOrderRecord;
import com.pi.Services.Order.CreateOrderService.iCreateOrderServices;
import com.pi.Services.Order.GetAllOrderService.iGetAllOrderServices;
import com.pi.Services.Order.GetOrderService.iGetOrderServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Order")
public class OrderController {

    iGetOrderServices getOrderServices;
    iGetAllOrderServices getAllOrderServices;
    iCreateOrderServices createOrderServices;

    public ResponseEntity<String> getOrder(@RequestBody GetOrderRecord getOrderRecord){
        try {
            getOrderServices.getOrder(getOrderRecord);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<String> getAllOrders(@RequestBody GetAllOrdersRecord getAllOrdersRecord){
        try {
            getAllOrderServices.getAllOrders(getAllOrdersRecord);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRecord createOrderRecord){
        try {
            createOrderServices.createOrder(createOrderRecord);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<String> updateOrder(UpdateOrderRecord updateOrderRecord){
        try {
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
