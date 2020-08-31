package com.dxctraining.mongoexperiments.employeesmgt.service;

import com.dxctraining.mongoexperiments.employeesmgt.dao.IEmployeeDao;
import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import com.dxctraining.mongoexperiments.employeesmgt.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRepositoryServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao dao;


    @Override
    public Employee save(Employee employee) {
        employee = dao.save(employee);
        return employee;
    }

    @Override
    public Employee findById(String id) {
        Optional<Employee> optional = dao.findById(id);
        boolean exist = optional.isPresent();
        if (!exist) {
            throw new EmployeeNotFoundException("employee not found for id=" + id);
        }
        Employee employee = optional.get();
        return employee;
    }


    @Override
    public List<Employee> findAll() {
        List<Employee> list = dao.findAll();
        return list;
    }

    @Override
    public List<Employee> findByAge(int age) {
        List<Employee> list = dao.findByAge(age);
        return list;
    }

    @Override
    public List<Employee>findByFirstName(String firstName){
        List<Employee>list=dao.findByFirstName(firstName);
        return list;
    }


    @Override
    public List<Employee>findByLastName(String lastName){
        List<Employee>list=dao.findByLastName(lastName);
        return list;
    }

    @Override
    public List<Employee>findByFullName(String firstName, String lastName){
        List<Employee>list=dao.findByFullName(firstName, lastName);
        return list;
    }

    @Override
    public void removeById(String id) {
        dao.deleteById(id);
    }
}
