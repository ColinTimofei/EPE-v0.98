package com.isdintership.epe.service.impl;

import com.isdintership.epe.dto.SignUpRequestDto;
import com.isdintership.epe.dto.UserDto;
import com.isdintership.epe.entity.Job;
import com.isdintership.epe.entity.Role;
import com.isdintership.epe.entity.User;
import com.isdintership.epe.entity.exception.UserExistException;
import com.isdintership.epe.entity.exception.UserNotFoundException;
import com.isdintership.epe.repository.JobRepository;
import com.isdintership.epe.repository.RoleRepository;
import com.isdintership.epe.repository.UserRepository;
import com.isdintership.epe.rest.RegistrationResponse;
import com.isdintership.epe.security.jwt.JwtTokenProvider;
import com.isdintership.epe.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final JobRepository jobRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JobRepository jobRepository,
                           RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User register (SignUpRequestDto userIn) {
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setFirstname(userIn.getFirstname());
        user.setLastname(userIn.getLastname());
        try {
            user.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse(userIn.getBirthDate()));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        try {
            user.setEmploymentDate(new SimpleDateFormat("dd-MM-yyyy").parse(userIn.getEmploymentDate()));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }


        user.setPhoneNumber(userIn.getPhoneNumber());

        user.setBio(userIn.getBio());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));

        Role roleUser = roleRepository.findByRole("ROLE_USER");
        user.setRole(roleUser);

        Job jobUser = jobRepository.findByJobTitle(userIn.getJob());
        user.setJob(jobUser);

        try {
            LOG.info("Saving user {}", userIn.getEmail());
            return userRepository.save(user);
        } catch (Exception ex) {
            LOG.error("Error during registration. {}", ex.getMessage());
            throw new UserExistException("User with email " + user.getEmail()
                    + " already exists");
        }
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
