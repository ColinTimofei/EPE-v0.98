package com.isdintership.epe.service;

import com.isdintership.epe.dto.SignUpRequestDto;
import com.isdintership.epe.dto.UserDto;
import com.isdintership.epe.entity.User;
import com.isdintership.epe.rest.RegistrationResponse;

import java.util.List;

public interface UserService {
    User register(SignUpRequestDto user);


    List<User> getAll();

    User findByFirstname(String username);

    User findByEmail(String email);

    UserDto findById(String id);

    void delete(String id);
}
