package com.dxctraining.deptmgt.department.dao;

import com.dxctraining.deptmgt.department.entities.Department;
import com.dxctraining.deptmgt.exceptions.DepartmentNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department findById(int id) {
        Department department = entityManager.find(Department.class, id);
        if(department==null){
            throw new DepartmentNotFoundException("department not found for id="+id);
        }
        return department;
    }

    @Override
    public Department save(Department department) {
        department=entityManager.merge(department);
        return department;
    }

}
