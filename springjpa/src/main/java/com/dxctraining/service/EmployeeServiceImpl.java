package com.dxctraining.service;

import com.dxctraining.dao.IEmployeeDao;
import com.dxctraining.entities.Employee;
import com.dxctraining.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// transactional will inform spring that it has to open transaction at every method in this class
@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeDao dao;

    @Override
    public Employee findEmployeeById(int id) {
       Employee employee= dao.findEmployeeById(id);
        return employee;
    }


    @Override
    public Employee update(Employee employee) {
        validate(employee);
        employee=dao.update(employee);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        validate(employee);
        employee=dao.save(employee);
        return employee;
    }

    @Override
    public void remove(int id) {
       dao.remove(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public Employee findEmployeeByName(String empName) {
       Employee employee =dao.findEmployeeByName(empName);
       return employee;
    }
}
