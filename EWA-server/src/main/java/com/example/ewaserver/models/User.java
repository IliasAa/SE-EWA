package com.example.ewaserver.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    private int userId;

    private String username;
    private String firstname;

    private String lastname;

    private String email;

    private String role = "Player";

    public User(int userId, String username, String firstname, String lastname, String email, String role) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }

    public User() {
    }


}
