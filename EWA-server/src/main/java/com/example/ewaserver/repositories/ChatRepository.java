package com.example.ewaserver.repositories;

import com.example.ewaserver.models.Chat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
