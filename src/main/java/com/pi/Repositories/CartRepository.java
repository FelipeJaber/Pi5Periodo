package com.pi.Repositories;

import com.pi.Models.Cart.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<CartModel, UUID> {
}
