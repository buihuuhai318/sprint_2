package com.example.sprint_2_api.service.cart.impl;

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
}
