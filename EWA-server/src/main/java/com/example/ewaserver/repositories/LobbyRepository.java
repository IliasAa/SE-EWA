package com.example.ewaserver.repositories;

import com.example.ewaserver.models.Lobby;

import java.util.List;

public interface LobbyRepository<E> {

    default List<Lobby> findAll() {
        return null;
    }

    default Lobby findById(long id) {
        return null;
    }
    default long generateNewLobbyCode() {
        return ((int) (Math.random() * 300000));
    }

    default Lobby deleteById(int id) {
        return null;
    }

    default Lobby update(int id) {
        return null;
    }

}