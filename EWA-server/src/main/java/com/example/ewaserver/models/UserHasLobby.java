package com.example.ewaserver.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "User_has_lobby")
public class UserHasLobby {
    @EmbeddedId
    private UserLobbyId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idLobby")
    private Lobby lobby;

    private String selected_color;

    public UserHasLobby(User user, Lobby lobby) {
        this.user = user;
        this.lobby = lobby;
        this.id = new UserLobbyId(user.getUserId(), lobby.getIdLobby());
    }

    protected UserHasLobby() {
    }
}
