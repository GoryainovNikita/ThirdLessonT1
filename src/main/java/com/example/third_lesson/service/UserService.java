package com.example.third_lesson.service;

import com.example.third_lesson.model.Order;
import com.example.third_lesson.model.User;
import com.example.third_lesson.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new RuntimeException("User not found for id : " + id);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void addOrderForUser(User user, Order order){
        user.getOrderSet().add(order);
    }

}
