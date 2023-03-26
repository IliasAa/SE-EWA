package com.example.ewaserver.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    private int userId;

    private String username;
    private String firstname;

    private String lastname;

    private String email;

    private String role = "Player";

}
