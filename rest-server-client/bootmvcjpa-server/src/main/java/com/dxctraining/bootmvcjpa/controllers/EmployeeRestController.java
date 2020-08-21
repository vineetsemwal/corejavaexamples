package com.dxctraining.bootmvcjpa.controllers;

import com.dxctraining.bootmvcjpa.dto.CreateEmployeeRequest;
import com.dxctraining.bootmvcjpa.dto.EmployeeDto;
import com.dxctraining.bootmvcjpa.dto.UpdateEmployeeRequest;
import com.dxctraining.bootmvcjpa.entities.Employee;
import com.dxctraining.bootmvcjpa.exceptions.EmployeeNotFoundException;
import com.dxctraining.bootmvcjpa.exceptions.InvalidArgumentException;
import com.dxctraining.bootmvcjpa.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    /*
      uri is /employees/add
      url http://localhost:8585/employees/add
   */
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@RequestBody CreateEmployeeRequest requestData) {
        String name = requestData.getName();
        String password = requestData.getPassword();
        int age = requestData.getAge();
        double salary = requestData.getSalary();
        Employee employee = new Employee(name, password, age, salary);
        employee = service.save(employee);
        EmployeeDto response=employeeDto(employee);
        return response;
    }



    /*
    uri is /employees/get
   request parameter  /employees/get?id=10
   path variable /employees/get/10
     */
    @GetMapping("/get/{id}")
    public EmployeeDto findEmployee(@PathVariable("id") int id) {
        Employee employee = service.findEmployeeById(id);
        EmployeeDto response=employeeDto(employee);
        return response;
    }


    @GetMapping
    public List<EmployeeDto>fetchAll(){
       List<Employee>list= service.allEmployees();
      List<EmployeeDto>response= employeeDto(list);
       return response;
    }

    /**
     * uri is /employees/update
     */
    @PutMapping("/update")
    public EmployeeDto updateEmployee(@RequestBody UpdateEmployeeRequest requestData) {
        String name = requestData.getName();
        String password = requestData.getPassword();
        int age = requestData.getAge();
        int id = requestData.getId();
        double salary = requestData.getSalary();
        Employee employee = new Employee(name, password, age, salary);
        employee.setId(id);
        employee = service.update(employee);
        EmployeeDto response=employeeDto(employee);
        return response;
    }

    @GetMapping("/authenticate/{id}/{password}")
    public boolean authenticate(@PathVariable("id") int id, @PathVariable("password") String password){
       boolean result= service.authenticate(id, password);
       return result;
    }


    public EmployeeDto employeeDto(Employee employee){
        EmployeeDto dto=new EmployeeDto(employee.getId(),employee.getName(),employee.getPassword(),employee.getSalary(),employee.getAge());
        return dto;
    }

    public List<EmployeeDto>employeeDto(List<Employee>employees){
        List<EmployeeDto>dtos=new ArrayList<>();
        for (Employee employee:employees){
            EmployeeDto dto=employeeDto(employee);
            dtos.add(dto);
        }
        return dtos;
    }

}




