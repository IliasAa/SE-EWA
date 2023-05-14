package com.example.ewaserver.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class UserHasLobbyPK implements Serializable {
    @Column(name = "USER_ID")
    private int user_id;

    @Column(name = "LOBBY_ID")
    private int lobby_id;
}
