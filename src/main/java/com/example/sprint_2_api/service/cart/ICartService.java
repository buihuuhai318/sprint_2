package com.example.sprint_2_api.service.cart;

import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.model.cart.Cart;
import com.example.sprint_2_api.service.IGenerateService;

import java.util.List;
import java.util.Optional;

public interface ICartService extends IGenerateService<Cart> {

    Optional<Cart> findCartByUser(Long id, int status, Long userId);

    List<Cart> findCarts(Long id, int status);

    Long sumCart(Long id, int status);

    List<ICartDto> findCartsDto(Long id);
}
