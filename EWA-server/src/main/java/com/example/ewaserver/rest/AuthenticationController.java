package com.example.ewaserver.rest;

import com.example.ewaserver.Config;
import com.example.ewaserver.exceptions.ResourceNotFoundException;
import com.example.ewaserver.exceptions.UnAuthorizedException;
import com.example.ewaserver.models.Token;
import com.example.ewaserver.models.User;
import com.example.ewaserver.repositories.TokenRepository;
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
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    Config apiconfig;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

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

        User savedUser = userRepository.Save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(savedUser.getUserId()).toUri();

        return ResponseEntity.created(location).body(savedUser);
    }

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<User> login(@RequestBody ObjectNode signInInfo, HttpServletResponse response) {
        String username = signInInfo.get("username").asText();
        String password = signInInfo.get("password").asText();

        User user = userRepository.findByUsername(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new ResourceNotFoundException("Cannot find an account related to " + username);
        }

        // Acces token
        JWToken jwToken = new JWToken(user.getUsername(), (long) user.getUserId(), user.getRole());
        String tokenString = jwToken.encode(this.apiconfig.getIssuer(), this.apiconfig.getPassphrase(),
                this.apiconfig.getTokenDurationOfValidity());


        return ResponseEntity.accepted()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenString)
                .body(user);

    }

    record RefreshToken(String refreshToken, Date issuedAt, Date refreshToken_issuedAt) {
    }

    @PostMapping(value = "/getRefreshToken", produces = "application/json")
    public RefreshToken refreshToken(@RequestBody User user, HttpServletResponse response) {
        // Refresh token
        JWToken jwTokenRefresh = new JWToken(user.getUsername(), (long) user.getUserId(), user.getRole());
        String refreshTokenString = jwTokenRefresh.encode(this.apiconfig.getIssuer(),
                this.apiconfig.getRefreshPassphrase(),
                this.apiconfig.getRefreshTokenDurationOfValidity());


        Token token = new Token(refreshTokenString, jwTokenRefresh.getExpired_at(), jwTokenRefresh.getIssued_at(), user);
        this.tokenRepository.Save(token);

        Cookie cookie = new Cookie("refresh_token", refreshTokenString);
        cookie.setMaxAge(36000);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        System.out.println(jwTokenRefresh.getIssued_at() == token.getIssued_at());

        return new RefreshToken(refreshTokenString, token.getIssued_at(), jwTokenRefresh.getIssued_at());
    }


    record RefreshResponse(String accesToken) {
    }

    @PostMapping(value = "/refresh", produces = "application/json")
    public ResponseEntity<String> refresh(@RequestBody String refreshTokenString) {
        // Decode the refreshToken with the string and passPhrase.
        JWToken refreshToken = JWToken.decode(refreshTokenString, apiconfig.getIssuer(),
                apiconfig.getRefreshPassphrase());


        User user = this.tokenRepository.
                findByRefreshToken(refreshToken.getAccountId(),
                        refreshTokenString, refreshToken.getExpired_at());


        if (user == null) {
            throw new UnAuthorizedException("User could not be found or refresh_token is invalid");
        }

        // Initialize a new accesToken with the claims that were retrieved from refreshToken.
        JWToken accesToken = new JWToken(
                refreshToken.getCallName(), refreshToken.getAccountId(), refreshToken.getRole()
        );

        // Encode the instance to get the accesTokenString out of it.
        String accesTokenString = accesToken.encode(apiconfig.getIssuer(), apiconfig.getPassphrase(),
                apiconfig.getTokenDurationOfValidity());

        // Return the new accesToken
        return ResponseEntity.accepted()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accesTokenString)
                .body(accesTokenString);
//        return new RefreshResponse(accesTokenString);
    }

    @PostMapping(value = "/{id}")
    public String logout(@PathVariable int id) {
        this.tokenRepository.deleteById(id);
        return "Logged out and removed tokens";
    }
}
