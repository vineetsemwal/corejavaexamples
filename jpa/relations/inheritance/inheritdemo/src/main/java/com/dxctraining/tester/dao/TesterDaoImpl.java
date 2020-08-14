package com.dxctraining.tester.dao;

import com.dxctraining.tester.entities.Tester;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TesterDaoImpl implements ITesterDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Tester save(Tester tester) {
        tester = entityManager.merge(tester);
        return tester;
    }

    @Override
    public Tester findById(int id) {
        Tester tester = entityManager.find(Tester.class, id);
        return tester;
    }
}
