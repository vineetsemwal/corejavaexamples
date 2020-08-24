package com.dxctraining.deptmgt.department.dao;

import com.dxctraining.deptmgt.department.entities.Department;

public interface IDepartmentDao {

    Department findById(int id);

    Department save(Department department);


}
