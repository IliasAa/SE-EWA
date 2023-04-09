package com.example.ewaserver.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @JsonProperty("username") private String username;

    @JsonProperty("firstname") private String firstname;

    @JsonProperty("lastname") private String lastname;

    private String email;
    private String password;

    private String role = "Player";




    public static User of(int userId,String username, String firstname, String lastname, String email, String password, String role){
        return new User(userId, username, firstname, lastname, email, password, role);
    }


    public User(int userId, String username, String firstname, String lastname, String email, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    public User() {
    }


}
