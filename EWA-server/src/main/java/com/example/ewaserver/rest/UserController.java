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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    @Autowired
    Config apiconfig;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping(path = "", produces = "application/json")
    public List<User> getSummary() {
        return userRepository.findAll();
    }


    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {

        System.out.println(user);
        User saveduser = userRepository.Save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(saveduser.getUserId()).toUri();

        return ResponseEntity.created(location).body(saveduser);
    }

    @PostMapping(value = "/login")
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

    record UserResponse(
            @JsonProperty("username") String username,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            String email) {
    }


    @GetMapping(value = "/token")
    public UserResponse user(HttpServletRequest request) {
        var user = (User) request.getAttribute("user");

        return new UserResponse(user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail());
    }


    record LogoutResponse(String message) {
    }

    @PostMapping(value = "/logout")
    public LogoutResponse logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("refresh_token", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);

        return new LogoutResponse("Succes");
    }

    @DeleteMapping(path = "{id}")
    public User deleteUser(@PathVariable() int id,
                           @RequestAttribute(name = JWToken.JWT_ATTRIBUTE_NAME) JWToken jwtInfo) {
        if (jwtInfo == null || !jwtInfo.isAdmin()) {
            throw new UnAuthorizedException(
                    "Admin role is required to remove an user");
        }
        User user = this.userRepository.deleteById(id);
        if (user == null) {
            throw new ResourceNotFoundException(
                    "Cannot delete an user with id=" + id);
        }
        return user;
    }

}
