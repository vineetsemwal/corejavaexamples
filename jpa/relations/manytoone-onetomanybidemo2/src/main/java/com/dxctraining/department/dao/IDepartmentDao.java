package com.dxctraining.department.dao;

import com.dxctraining.department.entities.Department;

public interface IDepartmentDao {

    Department save(Department department);


    Department findDepartmentById(int id);

}
