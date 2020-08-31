package com.dxctraining.mongoexperiments.employeesmgt.controllers;

import com.dxctraining.mongoexperiments.employeesmgt.dto.CreateEmployeeRequest;
import com.dxctraining.mongoexperiments.employeesmgt.dto.EmployeeDto;
import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import com.dxctraining.mongoexperiments.employeesmgt.service.IEmployeeService;
import com.dxctraining.mongoexperiments.employeesmgt.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    @Autowired
    private EmployeeUtil util;

    /*
      uri is /employees/add
      url http://localhost:8585/employees/add
   */
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@RequestBody CreateEmployeeRequest requestData) {
        Employee employee=new Employee(requestData.getName(),requestData.getAge());
        employee=service.save(employee);
        EmployeeDto response=util.employeeDto(employee);
        return response;
    }


    /*
    uri is /employees/get
   request parameter  /employees/get?id=10
   path variable /employees/get/10
     */
    @GetMapping("/get/{id}")
    public EmployeeDto findEmployee(@PathVariable("id") String id) {
        Employee employee = service.findById(id);
        EmployeeDto response = util.employeeDto(employee);
        return response;
    }


}
