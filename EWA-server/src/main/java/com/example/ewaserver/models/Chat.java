package com.example.ewaserver.models;

import com.example.ewaserver.models.User;
import java.time.LocalDateTime;

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
    private String message;
    private LocalDateTime date;


    public Chat() {
    }

    public Chat(int id, String message, LocalDateTime date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }

    public Chat(String message, LocalDateTime date) {
        this.message = message;
        this.date = date;
    }
}
