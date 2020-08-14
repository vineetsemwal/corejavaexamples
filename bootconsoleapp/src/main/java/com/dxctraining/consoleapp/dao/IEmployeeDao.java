package com.dxctraining.consoleapp.dao;

import com.dxctraining.consoleapp.entities.*;

public interface IEmployeeDao {

    Employee findEmployeeById(int id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void remove(int id);

    Employee findEmployeeByName(String empName);
}
