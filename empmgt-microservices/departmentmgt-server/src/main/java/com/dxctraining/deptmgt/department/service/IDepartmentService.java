package com.dxctraining.deptmgt.department.service;

import com.dxctraining.deptmgt.department.entities.Department;

public interface IDepartmentService {

    Department findById(int id);

    Department save(Department department);

    Department bestDepartment();

}
