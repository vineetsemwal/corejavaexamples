package com.dxctraining.department.dao;

import com.dxctraining.department.entities.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department save(Department department) {
        department=entityManager.merge(department);
        return department;
    }
}
