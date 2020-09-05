package com.dxctraining.bootmvcjpa.employee.service;


import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeService {

    Employee findEmployeeById(int id);

    Employee save(Employee employee);

    void remove(int id);

    List<Employee> findByFirstName(String empName);

    List<Employee>findByLastName(String lastName);

    List<Employee> findByFullName(String firstName, String lastName);

    List<Employee> allEmployees();

}
