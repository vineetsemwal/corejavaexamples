package com.dxctraining.bootmvcjpa.employee.service;

import com.dxctraining.bootmvcjpa.employee.dao.IEmployeeDao;
import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import com.dxctraining.bootmvcjpa.exceptions.EmployeeNotFoundException;
import com.dxctraining.bootmvcjpa.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// transactional will inform spring that it has to open transaction at every method in this class
@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeDao dao;

    @Override
    public Employee findEmployeeById(int id) {
       Optional<Employee> optional= dao.findById(id);
       if(!optional.isPresent()){
           throw new EmployeeNotFoundException("employee not found for id="+id);
       }
        Employee employee=optional.get();
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
       dao.deleteById(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
       List<Employee> employees =dao.findByFirstName(firstName);
       return employees;
    }

    @Override
    public List<Employee>findByLastName(String lastName){
      List<Employee>list=  dao.findByLastName(lastName);
      return list;
    }

    @Override
    public List<Employee> findByFullName(String firstName, String lastName) {
       List<Employee>list= dao.findByFullName(firstName, lastName);
       return list;
    }

    @Override
    public List<Employee> allEmployees(){
        List<Employee>employees=dao.findAll();
        return employees;
    }

}
