package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.util.SensitiveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SensitiveData sensitiveData;
    


    public String userRegisteration(User user) {

        List<User>users = userRepository.findAll();

        Predicate<User> userName = u -> u.getUserName().equalsIgnoreCase(user.getUserName());

        List<User> userCondition = users.stream().filter(userName).collect(Collectors.toList());
        if(userCondition.isEmpty()){
            User newUser = userRepository.save(user);
            String content = new String(String.valueOf(user));
            String maskUserDetails = sensitiveData.mask(content);
            return maskUserDetails;
        }
        else {
            return "user already exist with this userName, please try another";

        }


    }

    @Override
    public String userLogin(User user) throws RuntimeException{

            List<User> users = userRepository.findAll();
            User verifyUser = users.stream().filter(u -> u.getUserName().equalsIgnoreCase(user.getUserName())).findAny().get();
            boolean verification = verifyUser.getUserPassword().equals(user.getUserPassword());

       if((verifyUser!= null) && (verification==true)){

           return "user Login is Successful";
       }

       return null;
    }
}
