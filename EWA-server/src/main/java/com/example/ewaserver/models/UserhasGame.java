package com.example.ewaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_has_lobby")
public class UserhasGame {

    @Id
    private int user_id;
    @Id
    private int lobby_idLobby;

    public UserhasGame(int user_id, int lobby_idLobby) {
        this.user_id = user_id;
        this.lobby_idLobby = lobby_idLobby;
    }

    protected UserhasGame() {
    }
}
