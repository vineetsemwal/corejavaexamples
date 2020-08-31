package com.dxctraining.mongoexperiments.employeesmgt.service;

import com.dxctraining.mongoexperiments.employeesmgt.dao.IEmployeeDao;
import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import com.dxctraining.mongoexperiments.employeesmgt.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeDao dao;


    @Override
    public Employee save(Employee employee) {
       employee= dao.save(employee);
       return employee;
    }

    @Override
    public Employee findById(String id) {
      Optional<Employee>optional= dao.findById(id);
      boolean exist=optional.isPresent();
      if(!exist){
          throw new EmployeeNotFoundException("employee not found for id="+id);
      }
      Employee employee=optional.get();
       return employee;
    }

    @Override
    public void removeById(String id) {
       dao.deleteById(id);
    }
}
