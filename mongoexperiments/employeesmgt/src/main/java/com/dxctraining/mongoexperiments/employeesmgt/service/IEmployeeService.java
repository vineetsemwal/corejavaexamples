package com.dxctraining.mongoexperiments.employeesmgt.service;

import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;

public interface IEmployeeService {

    Employee save(Employee employee);

    Employee findById(String id);

    void removeById(String id);

}
