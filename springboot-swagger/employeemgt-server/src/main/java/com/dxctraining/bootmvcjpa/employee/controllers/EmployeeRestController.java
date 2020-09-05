package com.dxctraining.bootmvcjpa.employee.controllers;

import com.dxctraining.bootmvcjpa.employee.dto.CreateEmployeeRequest;
import com.dxctraining.bootmvcjpa.employee.dto.DepartmentDto;
import com.dxctraining.bootmvcjpa.employee.dto.EmployeeDto;
import com.dxctraining.bootmvcjpa.employee.dto.UpdateEmployeeRequest;
import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import com.dxctraining.bootmvcjpa.employee.service.IEmployeeService;
import com.dxctraining.bootmvcjpa.employee.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeUtil employeeUtil;

    @Autowired
    private RestTemplate restTemplate;

    /*
      uri is /employees/add
      url http://localhost:8585/employees/add
   */
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto create(@RequestBody @Valid CreateEmployeeRequest requestData) {
        Employee employee = new Employee(requestData.getFirstName(),requestData.getLastName());
        employee = employeeService.save(employee);
        EmployeeDto response = employeeUtil.employeeDto(employee);
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
        EmployeeDto response = employeeUtil.employeeDto(employee);
        return response;
    }


    @GetMapping
    public List<EmployeeDto> fetchAll() {
        List<Employee> list = employeeService.allEmployees();
        List<EmployeeDto>response=new ArrayList<>();
        for (Employee employee:list){
            EmployeeDto dto=employeeUtil.employeeDto(employee);
            response.add(dto);
        }
        return response;
    }




}




