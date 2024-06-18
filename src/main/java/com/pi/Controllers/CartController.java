package com.pi.Controllers;

import com.pi.Records.Cart.CreateCartRecord;
import com.pi.Records.Cart.UpdateCartRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/cart")
public class CartController {

    @GetMapping("/getcart/{cartId}")
    ResponseEntity<String> getCart(@NotBlank @NotNull @PathVariable("cartId") String orderId){
        return null;
    }

    @GetMapping("/createcart")
    ResponseEntity<String> createCart(@NotBlank @NotNull CreateCartRecord createCartRecord){
        return null;
    }

    @GetMapping("/updatecart/{cartId}")
    ResponseEntity<String> updateCart(@NotBlank @NotNull @PathVariable("cartId") String orderId, @NotBlank @NotNull UpdateCartRecord updateCartRecord){
        return null;
    }
}
