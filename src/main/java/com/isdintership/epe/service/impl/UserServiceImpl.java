package com.isdintership.epe.service.impl;

import com.isdintership.epe.dto.UserDto;
import com.isdintership.epe.entity.Role;
import com.isdintership.epe.entity.User;
import com.isdintership.epe.entity.exception.UserNotFoundException;
import com.isdintership.epe.repository.RoleRepository;
import com.isdintership.epe.repository.UserRepository;
import com.isdintership.epe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByRole("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        User registeredUser = userRepository.save(user);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();

        return result;
    }

    @Override
    public User findByFirstname(String username) {
        User result = userRepository.findByFirstname(username);

        return result;
    }

    @Override
    public User findByEmail(String email) {
        User result = userRepository.findByEmail(email);

        return result;
    }

    @Override
    public UserDto findById(String id) {
        User result = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found with ID:  " + id));

        return UserDto.fromUser(result);
    }

    @Override
    public void delete(String id) {

    }
}
