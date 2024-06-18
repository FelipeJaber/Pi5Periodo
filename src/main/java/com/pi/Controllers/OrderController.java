package com.pi.Controllers;

import com.pi.Records.Order.CreateOrderRecord;
import com.pi.Records.Order.GetAllOrdersRecord;
import com.pi.Records.Order.GetOrderRecord;
import com.pi.Records.Order.UpdateOrderRecord;
import com.pi.Services.Order.CreateOrderService.iCreateOrderServices;
import com.pi.Services.Order.GetAllOrderService.iGetAllOrderServices;
import com.pi.Services.Order.GetOrderService.iGetOrderServices;
import com.pi.Services.Order.UpdateOrderService.iUpdateOrderServices;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/Order")
public class OrderController {

    iGetOrderServices getOrderServices;
    iGetAllOrderServices getAllOrderServices;
    iCreateOrderServices createOrderServices;
    iUpdateOrderServices updateOrderServices;

    @GetMapping("/getorder/{orderId}")
    public ResponseEntity<String> getOrder(@NotBlank @NotNull @PathVariable ("orderId") String orderId, @RequestBody GetOrderRecord getOrderRecord){
        try {
            return ResponseEntity.ok(getOrderServices.getOrder(getOrderRecord, UUID.fromString(orderId)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getallorders")
    public ResponseEntity<String> getAllOrders(@RequestBody GetAllOrdersRecord getAllOrdersRecord){
        try {
            return ResponseEntity.ok(getAllOrderServices.getAllOrders(getAllOrdersRecord));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/createorder")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRecord createOrderRecord){
        try {
            createOrderServices.createOrder(createOrderRecord);
            return ResponseEntity.ok("ORDER CREATED SUCESSFULY");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/updateorder/{orderId}")
    public ResponseEntity<String> updateOrder(@NotBlank @NotNull @PathVariable ("orderId") String orderId, UpdateOrderRecord updateOrderRecord){
        try {
            updateOrderServices.updateOrder(updateOrderRecord, UUID.fromString(orderId));
            return ResponseEntity.ok("ORDER UPDATED SUCESSFULY");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
