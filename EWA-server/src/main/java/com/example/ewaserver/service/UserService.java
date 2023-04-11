package com.example.ewaserver.service;

import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(int userId, String username, String firstname, String lastname, String email, String password, String passwordConfirm,  String role) {
        if (!Objects.equals(password, passwordConfirm))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password do not match");

        return userRepository.Save(
                User.of(userId, username, firstname, lastname, email, passwordEncoder.encode(password), role)
        );
    }

    public User login(String email, String password) {
        // find user by email
        var user = userRepository.findByEmail(email);

        System.out.println(userRepository.findByEmail(email));

        // see if the passwords match
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid credentials");

        // return user
        return user;
    }
}
