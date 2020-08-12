package com.dxctraining.dao;

import com.dxctraining.entities.Employee;
import com.dxctraining.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{

    //equivalent to @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee=entityManager.find(Employee.class,id);
        if(employee==null){
            throw new EmployeeNotFoundException("employee not found for id="+id);
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        employee=entityManager.merge(employee);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public void remove(int id) {
     Employee employee= entityManager.find(Employee.class,id) ;
     entityManager.remove(employee);
    }
}
