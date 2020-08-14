package com.dxctraining.employee.service;

import com.dxctraining.employee.entities.Employee;

public interface IEmployeeService {
    Employee findEmployeeById(int id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void remove(int id);

}
