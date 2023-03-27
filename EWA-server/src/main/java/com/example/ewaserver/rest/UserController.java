package com.example.ewaserver.rest;


import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    private UserRepository userRepository;

    @GetMapping(path = "/test", produces = "application/json")
    public List<User> getTestUsers(){
        return List.of(
                new User(1, "ibrahim", "ibby" , "" , "", "Player"),
                new User(2, "damien", "D" , "" , "", "Player"));
    }

    @GetMapping(path = "",  produces = "application/json")
    public List<User> getSummary() {
        return userRepository.findAll();
    }
}
