package com.example.EPE.service;

import com.example.EPE.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByFirstname(String username);

    User findById(UUID id);

    void delete(UUID id);
}
