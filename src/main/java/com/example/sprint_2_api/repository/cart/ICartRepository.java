package com.example.sprint_2_api.repository.cart;

import com.example.sprint_2_api.model.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Long> {
}
