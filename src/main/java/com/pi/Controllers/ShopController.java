package com.pi.Controllers;

import com.pi.Records.Shop.BuyItensRecord;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Transactional
@RestController
@RequestMapping("/shop")
public class ShopController {

    @PostMapping("/buy")
    public ResponseEntity<String> buyItens(@Valid @RequestBody BuyItensRecord buyItensRecord) {
        return null;
    }
}
