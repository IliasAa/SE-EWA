package com.example.ewaserver.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

//Damiën
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LudoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Value("${server.servlet.context-path}")
    private String servletContextPath;

    @BeforeEach
    void setup() {
        if (servletContextPath == null) {
            servletContextPath = "/";
        }
    }

    @Test
    public void checkIfMovesExist() {
    }



}
