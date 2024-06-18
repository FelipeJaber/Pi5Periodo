package com.pi.Repositories;

import com.pi.Models.Cart.CartItensModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartItensRepository extends JpaRepository<CartItensModel, UUID> {
    List<CartItensModel> findByCartId(UUID cartId);
    @Transactional
    void deleteByCartId(UUID cartId);
}
