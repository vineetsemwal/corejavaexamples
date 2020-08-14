package com.dxctraining.developer.dao;

import com.dxctraining.developer.entities.Developer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DeveloperDaoImpl implements IDeveloperDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Developer save(Developer developer) {
        developer = entityManager.merge(developer);
        return developer;
    }

    @Override
    public Developer findById(int id) {
        Developer developer = entityManager.find(Developer.class, id);
        return developer;
    }
}
