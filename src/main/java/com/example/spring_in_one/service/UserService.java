package com.example.spring_in_one.service;

import com.example.spring_in_one.entity.User;
import java.util.List;

public interface UserService {
    User save(User user);

    User findById(String id);

    void delete(User user);

    List<User> findAll();
}
