package com.example.ewaserver.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @MapsId("lobbyId")
    private Lobby lobby;
    @JsonIgnore
    @ManyToOne
    @MapsId("userId")
    private User user;

    private String selected_color;

    public UserHasLobby() {
        this.id = new UserHasLobbyPK();
    }
}
