package com.example.ewaserver.rest;


import com.example.ewaserver.exceptions.ResourceNotFoundException;
import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.UserRepository;
import com.example.ewaserver.service.UserService;
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


    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {

        System.out.println(user);
        User saveduser = userRepository.Save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(saveduser.getUserId()).toUri();

        return ResponseEntity.created(location).body(saveduser);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody ObjectNode signInInfo, HttpServletRequest response) {
        String username = signInInfo.get("username").asText();
        String password = signInInfo.get("password").asText();

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new ResourceNotFoundException("User with username: " + username + " does not exist");
        }

        return ResponseEntity.accepted().header(HttpHeaders.AUTHORIZATION).body(user);
        //jwt token for later
//        var login = userService.login(username,password);
//        jakarta.servlet.http.Cookie cookie = new Cookie("refresh_token", login.getRefreshToken().getToken());
//        cookie.setMaxAge(3600);
//        cookie.setHttpOnly(true);
//        cookie.setPath("/users");
//        return new ResponseEntity.accepted().header(HttpHeaders.AUTHORIZATION).body(user);
    }

    record UserResponse(
            @JsonProperty("username") String username,
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastname") String lastname,
            String email) {}


    @GetMapping(value = "/token")
    public UserResponse user(HttpServletRequest request) {
        var user = (User) request.getAttribute("user");

        return new UserResponse(user.getUsername(), user.getFirstname(), user.getLastname(), user.getEmail());
    }

    record RefreshResponse(String token) {}

    @PostMapping(value = "/refresh")
    public RefreshResponse refresh(@CookieValue("refresh_token" ) String refreshToken) {
        return new RefreshResponse(userService.refreshAccess(refreshToken).getAccesToken().getToken());
    }

    record LogoutResponse(String message) {}
    @PostMapping(value = "/logout")
    public LogoutResponse logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("refresh_token", null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);

        response.addCookie(cookie);

        return new LogoutResponse("Succes");
    }

}
