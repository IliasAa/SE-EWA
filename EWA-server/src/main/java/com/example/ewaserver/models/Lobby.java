package com.example.ewaserver.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.element.Name;
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
    private int isPrivateLobby;
    private int player_size;
    private int max_allowed_Players;
    private int lobby_status;

    private int userid_owner;

    @OneToMany(mappedBy = "lobby")
    private Set<UserHasLobby> users;


    public Lobby(String join_code, int isPrivateLobby, int player_size, int max_allowed_Players,
                 int lobby_status, int userid_owner, Set<UserHasLobby> users) {
        this.join_code = join_code;
        this.isPrivateLobby = isPrivateLobby;
        this.player_size = player_size;
        this.max_allowed_Players = max_allowed_Players;
        this.lobby_status = lobby_status;
        this.userid_owner = userid_owner;
        this.users = users;
    }

    protected Lobby (){}

    public void addUser (User user,Lobby lobby) {
        UserHasLobby userHasLobby = new UserHasLobby(user,lobby);
        users.add(userHasLobby);
        user.getLobbySet().add(userHasLobby);
    }

}