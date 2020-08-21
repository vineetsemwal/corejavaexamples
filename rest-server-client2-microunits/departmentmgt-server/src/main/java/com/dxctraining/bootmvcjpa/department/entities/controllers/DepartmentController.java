package com.dxctraining.bootmvcjpa.department.entities.controllers;

import com.dxctraining.bootmvcjpa.department.dto.CreateDepartmentRequest;
import com.dxctraining.bootmvcjpa.department.dto.DepartmentDto;
import com.dxctraining.bootmvcjpa.department.entities.Department;
import com.dxctraining.bootmvcjpa.department.entities.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    public DepartmentDto toDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        return dto;
    }

}
