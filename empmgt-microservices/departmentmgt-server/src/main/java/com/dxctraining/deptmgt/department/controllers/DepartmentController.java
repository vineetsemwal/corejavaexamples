package com.dxctraining.deptmgt.department.controllers;

import com.dxctraining.deptmgt.department.dto.CreateDepartmentRequest;
import com.dxctraining.deptmgt.department.dto.DepartmentDto;
import com.dxctraining.deptmgt.department.entities.Department;
import com.dxctraining.deptmgt.department.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDto add(@RequestBody CreateDepartmentRequest requestData) {
        Department department = new Department();
        department.setName(requestData.getName());
        department.setRating(requestData.getRating());
        department = service.save(department);
        DepartmentDto response = toDto(department);
        return response;
    }

    @GetMapping("/get/{id}")
    public DepartmentDto getDepartment(@PathVariable("id") int id) {
        Department department = service.findById(id);
        DepartmentDto response = toDto(department);
        return response;
    }

    @GetMapping("/best")
    public DepartmentDto bestDepartment() {
        Department department = service.bestDepartment();
        System.out.println("best dept fetched="+department.getId());
        DepartmentDto dto = toDto(department);
        return dto;
    }

    public DepartmentDto toDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setRating(department.getRating());
        return dto;
    }


}
