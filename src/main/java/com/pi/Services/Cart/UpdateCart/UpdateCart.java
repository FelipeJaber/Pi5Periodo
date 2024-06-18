package com.pi.Services.Cart.UpdateCart;

import com.pi.Models.Cart.CartItemKey;
import com.pi.Models.Cart.CartItensModel;
import com.pi.Records.Cart.UpdateCartRecord;
import com.pi.Repositories.CartItensRepository;
import com.pi.Repositories.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UpdateCart implements iUpdateCart {

    CartRepository cartRepository;
    CartItensRepository cartItensRepository;

    @Autowired
    public UpdateCart(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void updateCart(UpdateCartRecord updateCartRecord) throws Exception {
        updateCartItens(updateCartRecord);
    }

    @Transactional
    public void updateCartItens(UpdateCartRecord updateCartRecord) throws Exception {
        throw  new Exception("NON IMPLEMENTED");
//        UUID cartUUID = updateCartRecord.cart_id();
//        List<CartItensModel> listaItens = new ArrayList<>();
//
//        cartItensRepository.deleteByCartId(cartUUID);
//
//
//
//        for (CartItensModel item : updateCartRecord.productList()) {
//            listaItens.add(new CartItensModel(cartUUID, updateCartRecord.productList().get().getItemQuantity(), cartUUID));
//        }
    }
}
