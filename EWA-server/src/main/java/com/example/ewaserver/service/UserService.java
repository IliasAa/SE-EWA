package com.example.ewaserver.service;

import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String accessTokenSecret;
    private final String refreshTokenSecret;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       @Value("${application.security.access-token-secret}") String accessTokenSecret,
                       @Value("${application.security.refresh-token-secret}") String refreshTokenSecret) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accessTokenSecret = accessTokenSecret;
        this.refreshTokenSecret = refreshTokenSecret;
    }

    public User register(int userId, String username, String firstname, String lastname, String email, String password, String passwordConfirm,  String role) {
        if (!Objects.equals(password, passwordConfirm))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password do not match");

        return userRepository.Save(
                User.of(userId, username, firstname, lastname, email, passwordEncoder.encode(password), role)
        );
    }

    public Login  login(String email, String password) {
        // find user by email
        var user = userRepository.findByEmail(email);

        System.out.println(userRepository.findByEmail(email));

        // see if the passwords match
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid credentials");

        // return user
        return Login.of(user.getUserId(),  accessTokenSecret , refreshTokenSecret);
    }

    public User getUserFromToken(String token) {
        return userRepository.findById(Token.from(token, accessTokenSecret));
    }


}
