package com.pi.Services.Cart.GetCart;

import com.google.gson.Gson;
import com.pi.Models.Cart.CartItensModel;
import com.pi.Models.Cart.CartModel;
import com.pi.Repositories.CartItensRepository;
import com.pi.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GetCart implements iGetCart{
    CartRepository cartRepository;
    CartItensRepository cartItensRepository;
    Gson gson;

    @Autowired
    public GetCart(CartRepository cartRepository, CartItensRepository cartItensRepository, Gson gson) {
        this.cartRepository = cartRepository;
        this.cartItensRepository = cartItensRepository;
        this.gson = gson;
    }

    @Override
    public String getCart(String cartId) throws Exception {
        return getCartInfo(cartId);
    }

    private String getCartInfo(String cartId) throws Exception {
        Optional<CartModel> cartModel = cartRepository.findById(UUID.fromString(cartId));
        if(cartModel.isEmpty()) throw new Exception("INVALID ID");
        List<CartItensModel> itensModelList = cartItensRepository.findByCartId(UUID.fromString(cartId));
        return gson.toJson(itensModelList);
    }

}
