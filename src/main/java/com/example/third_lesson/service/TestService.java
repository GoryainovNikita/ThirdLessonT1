package com.example.third_lesson.service;

import com.example.third_lesson.model.Order;
import com.example.third_lesson.model.Status;
import com.example.third_lesson.model.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final OrderService orderService;

    private final UserService userService;

    @PostConstruct
    public void init(){

        User user = new User();
        user.setEmail("aaa@gmail.com");
        user.setName("aaa");
        userService.saveUser(user);

        Order order = new Order();
        order.setDescription("AAA");
        order.setStatus(Status.IN_PROGRESS);
        order.setUser(user);

        User userById = userService.getById(1L);
        userService.addOrderForUser(userById, order);
        orderService.saveOrder(order);
        userService.saveUser(userById);
        orderService.getById(1L);
        orderService.getById(2L);
        orderService.deleteOrder(orderService.getById(1L));




    }

}
