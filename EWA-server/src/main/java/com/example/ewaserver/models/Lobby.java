package com.example.ewaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "lobby")
public class Lobby {

    @Id
    @GeneratedValue
    private int idLobby;
    private String join_code;
    private String selected_color;
    private int isPrivateLobby;
    private int player_size;
    private int max_allowed_Players;

    public Lobby(int idLobby, String join_code, String selected_color, int isPrivateLobby, int player_size, int max_allowed_Players) {
        this.idLobby = idLobby;
        this.join_code = join_code;
        this.selected_color = selected_color;
        this.isPrivateLobby = isPrivateLobby;
        this.player_size = player_size;
        this.max_allowed_Players = max_allowed_Players;
    }

    protected Lobby (){}

}