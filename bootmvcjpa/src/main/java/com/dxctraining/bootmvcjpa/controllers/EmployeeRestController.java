package com.dxctraining.bootmvcjpa.controllers;

import com.dxctraining.bootmvcjpa.dto.CreateEmployeeRequest;
import com.dxctraining.bootmvcjpa.dto.UpdateEmployeeRequest;
import com.dxctraining.bootmvcjpa.entities.Employee;
import com.dxctraining.bootmvcjpa.exceptions.EmployeeNotFoundException;
import com.dxctraining.bootmvcjpa.exceptions.InvalidArgumentException;
import com.dxctraining.bootmvcjpa.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    /*
      uri is /employees/add
      url http://localhost:8585/employees/add
   */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody CreateEmployeeRequest requestData) {
        String name = requestData.getName();
        String password = requestData.getPassword();
        int age = requestData.getAge();
        double salary = requestData.getSalary();
        Employee employee = new Employee(name, password, age, salary);
        employee = service.save(employee);
        return employee;
    }

    /*
    uri is /employees/get
     /employees/get?id=10
    /employees/get/abc/10
     */
    @GetMapping("/get/{id}")
    public Employee findEmployee(@PathVariable("id") int id) {
        Employee employee = service.findEmployeeById(id);
        return employee;
    }

    /**
     * uri is /employees/update
     */
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody UpdateEmployeeRequest requestData) {
        String name = requestData.getName();
        String password = requestData.getPassword();
        int age = requestData.getAge();
        int id = requestData.getId();
        double salary = requestData.getSalary();
        Employee employee = new Employee(name, password, age, salary);
        employee.setId(id);
        employee = service.update(employee);
        return employee;
    }



}




