package com.example.ewaserver.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue
    private int idgame;
    private int lobby_idlobby;

    public Game(int idgame, int lobby_idlobby) {
        this.idgame = idgame;
        this.lobby_idlobby = lobby_idlobby;
    }

    protected Game() {
    }
}
