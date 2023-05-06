package com.example.ewaserver.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Lobby_find_by_code",
                query = "select l from Lobby l where l.join_code = ?1 "),
})

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

    @ManyToMany
    @JsonBackReference
    @JsonIgnore
    private List<User> users;


    public Lobby(String join_code, String selected_color, int isPrivateLobby, int player_size, int max_allowed_Players,List<User> users) {
        this.join_code = join_code;
        this.selected_color = selected_color;
        this.isPrivateLobby = isPrivateLobby;
        this.player_size = player_size;
        this.max_allowed_Players = max_allowed_Players;
        this.users = users;
    }

    protected Lobby (){}

}