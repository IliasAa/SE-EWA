package com.example.ewaserver.rest;


import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import com.example.ewaserver.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping(path = "",  produces = "application/json")
    public List<User> getSummary() {
        return userRepository.findAll();
    }

    record RegisterRequest(
            int userId,
            @JsonProperty("username") String username,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            String email,
            String password,
            @JsonProperty("password_confirm") String passwordConfirm,
            String role
    ){ }

    record RegisterRespone(
            @JsonProperty("username") String username,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            String email
    ) {}


    @PostMapping(value = "/register")
    public RegisterRespone registerUser(@RequestBody RegisterRequest registerRequest) {

        var user =  userService.register(
                registerRequest.userId(),
                registerRequest.username(),
                registerRequest.firstname(),
                registerRequest.lastname(),
                registerRequest.email(),
                registerRequest.password,
                registerRequest.passwordConfirm(),
                registerRequest.role()
        );

        return new RegisterRespone(user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail()
        );
    }

    record LoginRequest(String email, String password) { }
    record LoginResponse(String token) {
    }


    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        var token = userService.login(loginRequest.email(), loginRequest.password());

        return new LoginResponse(token.getToken());
    }
}
