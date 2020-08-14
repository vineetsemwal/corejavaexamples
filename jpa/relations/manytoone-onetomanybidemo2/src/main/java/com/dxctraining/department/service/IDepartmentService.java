package com.dxctraining.department.service;

import com.dxctraining.department.entities.Department;

public interface IDepartmentService {

    Department save(Department department);

    Department findDepartmentById(int id);
}
