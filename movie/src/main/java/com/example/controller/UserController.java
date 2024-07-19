package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import com.example.util.MyLogger;
import com.example.util.SensitiveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    MyLogger logger;
    @Autowired
    SensitiveData sensitiveData;



    @PostMapping("/registerUser")
    public String registerUser(@RequestBody User user){

        String newUser = userService.userRegisteration(user);
        logger.info("User register successfully");


        return newUser;
    }

    @GetMapping("/userLogin")
    public String userLogin(@RequestBody User user){
        String userLogin = userService.userLogin(user);
        logger.info("user has login");
        return userLogin;
    }
}

