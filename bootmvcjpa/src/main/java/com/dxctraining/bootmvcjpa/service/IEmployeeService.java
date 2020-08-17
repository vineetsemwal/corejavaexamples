package com.dxctraining.bootmvcjpa.service;


import com.dxctraining.bootmvcjpa.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee findEmployeeById(int id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void remove(int id);

    Employee findEmployeeByName(String empName);

    List<Employee> allEmployees();

}
