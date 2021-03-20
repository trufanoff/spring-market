package com.yt.market.services;

import com.yt.market.entities.Order;
import com.yt.market.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAllByUserId(Long id){
        return orderRepository.findAllByUserId(id);
    }
}
