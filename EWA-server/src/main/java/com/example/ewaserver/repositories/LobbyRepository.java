package com.example.ewaserver.repositories;

import com.example.ewaserver.models.Lobby;
import com.example.ewaserver.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LobbyRepository implements EntityRepository<Lobby>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Lobby> findAll() {
        TypedQuery<Lobby> query = this.em.createQuery("select l from Lobby l", Lobby.class);

        return query.getResultList();
    }

    @Override
    public Lobby findById(int id) {
        return this.em.find(Lobby.class, id);
    }


    public Lobby findByLobbyCode(String join_code) {
        return this.em.find(Lobby.class, join_code);
    }

    @Override
    public Lobby Save(Lobby entity) {
        return this.em.merge(entity);
    }

    @Override
    public Lobby update(Lobby entity, int id) {
        return null;
    }

    @Override
    public Lobby deleteById(int id) {
        Lobby lobby = this.findById(id);
        em.remove(lobby);
        return lobby;    }
}
