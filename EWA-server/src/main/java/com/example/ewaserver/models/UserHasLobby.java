package com.example.ewaserver.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.element.Name;

@Entity
@Getter
@Setter
@Table(name = "user_has_lobby")
public class UserHasLobby {

    @EmbeddedId
    UserHasLobbyPK id;

    @JsonIgnore
    @ManyToOne
    @MapsId("lobbyId")
    private Lobby lobby;

    @ManyToOne
    @MapsId("userId")
    private User user;

    private String selected_color;

    public UserHasLobby() {
        this.id = new UserHasLobbyPK();
    }
}
