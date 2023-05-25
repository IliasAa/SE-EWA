package com.example.ewaserver.repositories;

import com.example.ewaserver.models.Chat;
import com.example.ewaserver.models.UserHasLobby;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class ChatRepository implements EntityRepository<Chat>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Chat> findAll() {
        TypedQuery<Chat> query = this.em.createQuery("select l from Chat l", Chat.class);
        return query.getResultList();
    }

    @Override
    public List<Chat> findByQuery(String jpqlName, Object... params) {
        return null;
    }

    @Override
    public Chat findById(int id) {
        return null;
    }

    @Override
    public Chat Save(Chat entity) {
        return this.em.merge(entity);
    }

    @Override
    public Chat update(Chat entity, int id) {
        return null;
    }

    @Override
    public Chat deleteById(int id) {
        return null;
    }
}
