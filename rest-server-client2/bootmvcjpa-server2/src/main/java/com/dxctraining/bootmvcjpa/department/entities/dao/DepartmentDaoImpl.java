package com.dxctraining.bootmvcjpa.department.entities.dao;

import com.dxctraining.bootmvcjpa.department.entities.Department;
import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import com.dxctraining.bootmvcjpa.exceptions.DepartmentNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

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

    @Override
    public Set<Employee> departmentEmployees(int id) {
        Department department=findById(id);
        Set<Employee> employees=department.getEmployees();
        return employees;
    }
}
