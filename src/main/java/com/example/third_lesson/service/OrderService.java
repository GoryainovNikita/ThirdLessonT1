package com.example.third_lesson.service;

import com.example.third_lesson.model.Order;
import com.example.third_lesson.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Order getById(Long id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            return optionalOrder.get();
        }
        throw new RuntimeException("Order not found for id : " + id);
    }

    public void deleteOrder(Order order){
        orderRepository.delete(order);
    }
}
