package com.example.ewaserver.repositories;

import com.example.ewaserver.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class UserRepository implements EntityRepository<User> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User Save(User entity) {
        return null;
    }

    @Override
    public User update(User entity, int id) {
        return null;
    }

    @Override
    public User deleteById(int id) {
        return null;
    }
}
