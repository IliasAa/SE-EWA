package com.example.ewaserver.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Embeddable
@Getter
@Setter
public class UserLobbyId implements Serializable {
    private int userId;
    private int lobbyId;


    public UserLobbyId(int userId, int lobbyId) {
        this.userId = userId;
        this.lobbyId = lobbyId;
    }

    protected UserLobbyId() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
