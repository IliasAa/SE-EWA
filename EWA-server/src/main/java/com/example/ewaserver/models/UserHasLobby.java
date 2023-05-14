package com.example.ewaserver.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.element.Name;

@Entity
@Getter
@Setter
@Table(name = "User_has_lobby")
public class UserHasLobby {

    @EmbeddedId
    private UserHasLobbyPK id;

    @ManyToOne
    @MapsId("lobby_id")
    @JoinColumn(name = "LOBBY_ID")
    private Lobby lobby;
    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "USER_ID")
    private User user;


    @Column(name = "selected_color")
    private String selected_color;

    public UserHasLobby(Lobby lobby, User user, String selectedcolor) {
        this.lobby = lobby;
        this.user = user;
        this.selected_color = selectedcolor;
    }

    public UserHasLobby() {
    }
}
