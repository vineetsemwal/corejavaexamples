package com.dxctraining.bootmvcjpa.department.entities.dao;

import com.dxctraining.bootmvcjpa.department.entities.Department;

import java.util.List;
import java.util.Set;

public interface IDepartmentDao {

    Department findById(int id);

    Department save(Department department);


}
