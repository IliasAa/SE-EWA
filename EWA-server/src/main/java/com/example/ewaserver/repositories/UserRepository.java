package com.example.ewaserver.repositories;

import com.example.ewaserver.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserRepository implements EntityRepository<User> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = this.em.createQuery("select u from User u", User.class);

        return query.getResultList();
    }

    @Override
    public User findById(int id) {
        return this.em.find(User.class, id);
    }

    @Override
    public User Save(User entity) {
        return this.em.merge(entity);
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
