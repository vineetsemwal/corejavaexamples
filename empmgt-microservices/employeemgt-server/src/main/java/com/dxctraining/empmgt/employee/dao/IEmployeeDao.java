package com.dxctraining.empmgt.employee.dao;


import com.dxctraining.empmgt.employee.entities.Employee;

import java.util.List;

public interface IEmployeeDao {

    Employee findEmployeeById(int id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void remove(int id);

    Employee findEmployeeByName(String empName);

    List<Employee>allEmployees();

    List<Employee> allEmployeesByDepartment(int deptId);
}
