package com.example.ewaserver.models;

import com.example.ewaserver.models.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private String message;



    @ManyToMany
    private List<User> users;

    public Chat() {
    }

    public Chat(int id, LocalDateTime date) {
        this.id = id;
        this.date = date;
    }

    public Chat(LocalDateTime date, String message) {
        this.date = date;
        this.message = message;
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
