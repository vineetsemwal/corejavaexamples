package com.dxctraining.jerseyboot.employee.service;


import com.dxctraining.jerseyboot.employee.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee findEmployeeById(int id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void remove(int id);

    Employee findEmployeeByName(String empName);

    List<Employee> allEmployees();

    boolean authenticate(int id, String password);

    List<Employee> allEmployeesByDepartment(int deptId);
}
