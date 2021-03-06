package com.dxctraining.mongoexperiments.employeesmgt.service;

import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee save(Employee employee);

    Employee findById(String id);

    void removeById(String id);

    List<Employee> findAll();

    List<Employee>findByAge(int age);

    List<Employee>findByFirstName(String firstName);

    List<Employee>findByLastName(String lastName);

    List<Employee>findByFullName(String firstName, String lastName);

}
