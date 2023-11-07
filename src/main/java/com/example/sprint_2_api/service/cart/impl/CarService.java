package com.example.sprint_2_api.service.cart.impl;

import com.example.sprint_2_api.dto.cart.ICartDto;
import com.example.sprint_2_api.model.cart.Cart;
import com.example.sprint_2_api.repository.cart.ICartRepository;
import com.example.sprint_2_api.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Optional<Cart> findCartByUser(Long id, int status, Long userId) {
        return cartRepository.findCartByCharitableProject_IdAndPayStatusAndAppUser_Id(id, status, userId);
    }

    @Override
    public List<Cart> findCarts(Long id, int status) {
        return cartRepository.findCartsByAppUser_IdAndPayStatus(id, status);
    }

    @Override
    public Long sumCart(Long id, int status) {
        List<Cart> list = findCarts(id, status);
        long sum = 0;
        for (Cart cart : list) {
            sum += cart.getMoney();
        }
        return sum;
    }

    @Override
    public List<ICartDto> findCartsDto(Long id) {
        return cartRepository.findCartsDto(id);
    }
}
