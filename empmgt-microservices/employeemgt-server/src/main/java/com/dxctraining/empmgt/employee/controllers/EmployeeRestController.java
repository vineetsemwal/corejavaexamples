package com.dxctraining.empmgt.employee.controllers;

import com.dxctraining.empmgt.employee.dto.CreateEmployeeRequest;
import com.dxctraining.empmgt.employee.dto.DepartmentDto;
import com.dxctraining.empmgt.employee.dto.EmployeeDto;
import com.dxctraining.empmgt.employee.dto.UpdateEmployeeRequest;
import com.dxctraining.empmgt.employee.entities.Employee;
import com.dxctraining.empmgt.employee.service.IEmployeeService;
import com.dxctraining.empmgt.employee.util.EmployeeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeUtil employeeUtil;

    @Autowired
    private RestTemplate restTemplate;

    String baseDepartmentUrl = "http://deptmgt/departments/";


    private DepartmentDto cachedTopDepartment =null;

    public DepartmentDto getCachedTopDepartment(){
        return cachedTopDepartment;
    }

    public void setCachedTopDepartment(DepartmentDto dto){
        this.cachedTopDepartment=dto;
    }

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
        int departmentId = requestData.getDepartmentId();
        Employee employee = new Employee(name, password, departmentId, age, salary);
        employee = employeeService.save(employee);
        DepartmentDto department = fetchFromDepartmentAppById(departmentId);
        EmployeeDto response = employeeUtil.employeeDto(employee, departmentId, department.getName(),department.getRating());
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
        EmployeeDto response = employeeUtil.employeeDto(employee, deptId, department.getName(), department.getRating());
        return response;
    }


    @GetMapping
    public List<EmployeeDto> fetchAll() {
        List<Employee> list = employeeService.allEmployees();
        List<EmployeeDto>response=new ArrayList<>();
        for (Employee employee:list){
            int  deptId=employee.getDepartmentId();
            DepartmentDto department= fetchFromDepartmentAppById(deptId);
            EmployeeDto dto=employeeUtil.employeeDto(employee,deptId,department.getName(), department.getRating());
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
            EmployeeDto dto=employeeUtil.employeeDto(employee,deptId,department.getName(), department.getRating());
            response.add(dto);
        }
        return response;
    }

    /**
     * fetches employees of best department, if the method fails for some reason, alternative method will be executed
     *
     */
    @GetMapping("/topdepartment")
    @HystrixCommand(fallbackMethod = "fetchAllForCachedTopDepartment")
    public List<EmployeeDto> fetchAllForTopDepartment() {
        System.out.println("inside fetchAllForTopDepartment");
        DepartmentDto departmentDto=fetchBestDepartment();
        int deptId=departmentDto.getId();
        System.out.println("cached top department id="+deptId);
        List<Employee> list = employeeService.allEmployeesByDepartment(deptId);
        List<EmployeeDto>response=new ArrayList<>();
        DepartmentDto department= fetchFromDepartmentAppById(deptId);
        for (Employee employee:list){
            EmployeeDto dto=employeeUtil.employeeDto(employee,deptId,department.getName(), department.getRating());
            response.add(dto);
        }
        return response;
    }



    /**
     * fallback(alternative) method for fetching employees of best department
     *
     */
    public List<EmployeeDto> fetchAllForCachedTopDepartment() {
        System.out.println("inside  fetchAllForCachedTopDepartment");
        DepartmentDto department=getCachedTopDepartment();
        int deptId=department.getId();
        List<Employee> list = employeeService.allEmployeesByDepartment(deptId);
        List<EmployeeDto>response=new ArrayList<>();
        for (Employee employee:list){
            EmployeeDto dto=employeeUtil.employeeDto(employee,deptId,department.getName(), department.getRating());
            response.add(dto);
        }
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
        DepartmentDto department=fetchFromDepartmentAppById(employee.getDepartmentId());
        EmployeeDto response = employeeUtil.employeeDto(employee, department.getId(), department.getName(), department.getRating());
        return response;
    }

    @GetMapping("/authenticate/{id}/{password}")
    public boolean authenticate(@PathVariable("id") int id, @PathVariable("password") String password) {
        boolean result = employeeService.authenticate(id, password);
        return result;
    }


    public DepartmentDto fetchBestDepartment(){
        String url=baseDepartmentUrl+"/best";
        DepartmentDto dto=restTemplate.getForObject(url,DepartmentDto.class);
        setCachedTopDepartment(dto);//cached/stored here
        return dto;
    }


    public DepartmentDto fetchFromDepartmentAppById(int deptId) {
        String url = baseDepartmentUrl+"/get/" + deptId;
        DepartmentDto dto = restTemplate.getForObject(url, DepartmentDto.class);
        return dto;
    }





}




