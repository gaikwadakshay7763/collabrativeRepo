package com.course.service;

import com.course.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.course.service.UserServiceImpl.users;

public interface  UserService {


    public List<User> getAllUser();

    public User getUser(int id);
    public User registerUser(User user);
    public void deletUser(int id);

}

