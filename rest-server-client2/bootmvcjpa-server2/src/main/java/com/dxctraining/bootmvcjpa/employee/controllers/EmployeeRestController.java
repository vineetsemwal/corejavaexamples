package com.dxctraining.bootmvcjpa.employee.controllers;

import com.dxctraining.bootmvcjpa.department.entities.Department;
import com.dxctraining.bootmvcjpa.department.entities.service.IDepartmentService;
import com.dxctraining.bootmvcjpa.employee.dto.CreateEmployeeRequest;
import com.dxctraining.bootmvcjpa.employee.dto.EmployeeDto;
import com.dxctraining.bootmvcjpa.employee.dto.UpdateEmployeeRequest;
import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import com.dxctraining.bootmvcjpa.employee.service.IEmployeeService;
import com.dxctraining.bootmvcjpa.employee.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private EmployeeUtil employeeUtil;

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
        int departmentId=requestData.getDepartmentId();
        Department department=departmentService.findById(departmentId);
        Employee employee = new Employee(name, password,department, age, salary);
        employee = employeeService.save(employee);
        EmployeeDto response=employeeUtil.employeeDto(employee);
        return response;
    }



    /*
    uri is /employees/get
   request parameter  /employees/get?id=10
   path variable /employees/get/10
     */
    @GetMapping("/get/{id}")
    public EmployeeDto findEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.findEmployeeById(id);
        EmployeeDto response=employeeUtil.employeeDto(employee);
        return response;
    }


    @GetMapping
    public List<EmployeeDto>fetchAll(){
       List<Employee>list= employeeService.allEmployees();
      List<EmployeeDto>response= employeeUtil.employeeDto(list);
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
        Employee employee = employeeService.findEmployeeById(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setPassword(password);
        employee.setSalary(salary);
        employee = employeeService.update(employee);
        EmployeeDto response=employeeUtil.employeeDto(employee);
        return response;
    }

    @GetMapping("/authenticate/{id}/{password}")
    public boolean authenticate(@PathVariable("id") int id, @PathVariable("password") String password){
       boolean result= employeeService.authenticate(id, password);
       return result;
    }



}




