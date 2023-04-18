package com.example.ewaserver.rest;

import com.example.ewaserver.Config;
import com.example.ewaserver.exceptions.ResourceNotFoundException;
import com.example.ewaserver.exceptions.UnAuthorizedException;
import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import com.example.ewaserver.service.JWToken;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    Config apiconfig;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    //find all method is in this controller so it allows us to debug. Will be removed later on.
    @GetMapping(path = "", produces = "application/json")
    public List<User> getSummary() {
        return userRepository.findAll();
    }


    @PostMapping(path = "/register", produces = "application/json")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {

        System.out.println(user);

        // Encode the password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        User saveduser = userRepository.Save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(saveduser.getUserId()).toUri();

        return ResponseEntity.created(location).body(saveduser);
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<User> login(@RequestBody ObjectNode signInInfo) {
        String username = signInInfo.get("username").asText();
        String password = signInInfo.get("password").asText();

        User user = userRepository.findByUsername(username);


        if (user == null || !user.verifyPassword(password)) {
            throw new ResourceNotFoundException("Cannot find an account related to " + username);
        }

        JWToken jwToken = new JWToken(user.getUsername(), (long) user.getUserId(), user.getRole());
        String tokenString = jwToken.encode(this.apiconfig.getIssuer(), this.apiconfig.getPassphrase(),
                this.apiconfig.getTokenDurationOfValidity());


        return ResponseEntity.accepted().header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenString)
                .body(user);
    }
}
