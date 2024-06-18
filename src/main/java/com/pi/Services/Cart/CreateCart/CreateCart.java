package com.pi.Services.Cart.CreateCart;

import com.pi.Models.Cart.CartModel;
import com.pi.Records.Cart.CreateCartRecord;
import com.pi.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateCart implements iCreateCart {
    CartRepository cartRepository;

    @Autowired
    public CreateCart(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public String createCart(CreateCartRecord createCartRecord) throws Exception {
        return createNewCart(createCartRecord);
    }

    private String createNewCart(CreateCartRecord createCartRecord){
        CartModel cartModel = new CartModel();
        cartModel.setType(createCartRecord.type());
        cartRepository.save(cartModel);
        return cartModel.getCartId().toString();
    }
}
