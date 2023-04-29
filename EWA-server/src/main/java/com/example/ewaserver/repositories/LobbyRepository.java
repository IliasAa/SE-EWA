package com.example.ewaserver.repositories;

import com.example.ewaserver.models.Lobby;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LobbyRepository implements EntityRepository<Lobby>{
    @Override
    public List<Lobby> findAll() {
        return null;
    }

    @Override
    public Lobby findById(int id) {
        return null;
    }

    @Override
    public Lobby Save(Lobby entity) {
        return null;
    }

    @Override
    public Lobby update(Lobby entity, int id) {
        return null;
    }

    @Override
    public Lobby deleteById(int id) {
        return null;
    }
}
