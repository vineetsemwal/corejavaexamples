package com.dxctraining.consoleapp.service;

import com.dxctraining.consoleapp.entities.Employee;

public interface IEmployeeService {
    Employee findEmployeeById(int id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void remove(int id);

    Employee findEmployeeByName(String empName);
}
