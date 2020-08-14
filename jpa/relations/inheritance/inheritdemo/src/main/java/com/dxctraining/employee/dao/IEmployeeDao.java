package com.dxctraining.employee.dao;

import com.dxctraining.employee.entities.Employee;

public interface IEmployeeDao {

    Employee findEmployeeById(int id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void remove(int id);

}
