package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

     String userRegisteration(User user);
     String userLogin(User user);
}
