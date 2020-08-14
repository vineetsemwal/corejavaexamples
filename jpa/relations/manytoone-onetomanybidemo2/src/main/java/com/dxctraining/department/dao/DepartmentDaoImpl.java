package com.dxctraining.department.dao;

import com.dxctraining.department.entities.Department;
import com.dxctraining.employee.entities.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department save(Department department) {
        department =entityManager.merge(department);
        return department;
    }

    @Override
    public Department findDepartmentById(int id) {
      Department department =  entityManager.find(Department.class,id);
      Set<Employee> employees= department.getEmployees();
      employees.size();// for initializing collection
      return department;
    }
}
