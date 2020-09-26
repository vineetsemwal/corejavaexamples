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
        String name = requestData.getName();
        String password = requestData.getPassword();
        int age = requestData.getAge();
        double salary = requestData.getSalary();
        int departmentId = requestData.getDepartmentId();
        Employee employee = new Employee(name, password, departmentId, age, salary);
        employee = employeeService.save(employee);
        DepartmentDto department = fetchFromDepartmentAppById(departmentId);
        EmployeeDto response = employeeUtil.employeeDto(employee, departmentId, department.getName());
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
        int deptId = employee.getDepartmentId();
        DepartmentDto department = fetchFromDepartmentAppById(deptId);
        EmployeeDto response = employeeUtil.employeeDto(employee, deptId, department.getName());
        return response;
    }


    @GetMapping
    public List<EmployeeDto> fetchAll() {
        List<Employee> list = employeeService.allEmployees();
        List<EmployeeDto>response=new ArrayList<>();
        for (Employee employee:list){
            int  deptId=employee.getDepartmentId();
            DepartmentDto department= fetchFromDepartmentAppById(deptId);
            EmployeeDto dto=employeeUtil.employeeDto(employee,deptId,department.getName());
            response.add(dto);
        }
        return response;
    }

    @GetMapping("/department/{deptId}")
    public List<EmployeeDto> fetchAllForDepartment(@PathVariable("deptId") int deptId) {
        List<Employee> list = employeeService.allEmployeesByDepartment(deptId);
        List<EmployeeDto>response=new ArrayList<>();
        DepartmentDto department= fetchFromDepartmentAppById(deptId);
        for (Employee employee:list){
            EmployeeDto dto=employeeUtil.employeeDto(employee,deptId,department.getName());
            response.add(dto);
        }
        return response;
    }


    /**
     * uri is /employees/update
     */
    @PutMapping("/update")
    public EmployeeDto updateEmployee(@RequestBody @Valid UpdateEmployeeRequest requestData) {
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
        DepartmentDto department=fetchFromDepartmentAppById(employee.getDepartmentId());
        EmployeeDto response = employeeUtil.employeeDto(employee, department.getId(), department.getName());
        return response;
    }

    @GetMapping("/authenticate/{id}/{password}")
    public boolean authenticate(@PathVariable("id") int id, @NotBlank  @PathVariable("password") String password) {
        boolean result = employeeService.authenticate(id, password);
        return result;
    }

    public DepartmentDto fetchFromDepartmentAppById(int deptId) {
       DepartmentDto dto=new DepartmentDto();
       dto.setId(deptId);
       dto.setName("development");
       return dto;
    }


}




