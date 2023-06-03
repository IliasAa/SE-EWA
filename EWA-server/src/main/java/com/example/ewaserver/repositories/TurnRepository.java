package com.example.ewaserver.repositories;

import com.example.ewaserver.models.Turn;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TurnRepository implements EntityRepository<Turn>{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Turn> findAll() {
        return null;
    }

    @Override
    public Turn findById(int id) {
        return null;
    }

    @Override
    public Turn Save(Turn entity) {
        return null;
    }

    @Override
    public Turn update(Turn entity, int id) {
        return null;
    }

    @Override
    public Turn deleteById(int id) {
        return null;
    }

    @Override
    public List<Turn> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Turn> query =
                this.em.createNamedQuery(jpqlName, Turn.class);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }

}
