package com.dxctraining.bootmvcjpa.department.entities.service;

import com.dxctraining.bootmvcjpa.department.entities.Department;

import java.util.Set;

public interface IDepartmentService {

    Department findById(int id);

    Department save(Department department);

}
