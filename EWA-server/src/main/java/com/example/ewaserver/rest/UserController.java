package com.example.ewaserver.rest;


import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/test", produces = "application/json")
    public List<User> getTestUsers(){
        return List.of(
                new User(1, "ibrahim", "ibby" , "" , "", "", "Player"),
                new User(2, "damien", "D" , "" , "",  "", "Player"));
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
            String role
    ){ }


    @PostMapping(value = "/register")
    public User registerUser(@RequestBody RegisterRequest registerRequest) {
        return userRepository.Save(
                User.of(
                        registerRequest.userId(),
                        registerRequest.username(),
                        registerRequest.firstname(),
                        registerRequest.lastname(),
                        registerRequest.email(),
                        registerRequest.password(),
                        registerRequest.role()
                )
        );
    }

}
