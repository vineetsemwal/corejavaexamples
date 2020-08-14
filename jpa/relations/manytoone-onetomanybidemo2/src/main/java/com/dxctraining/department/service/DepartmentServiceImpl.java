package com.dxctraining.department.service;

import com.dxctraining.department.dao.IDepartmentDao;
import com.dxctraining.department.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentDao dao;

    @Override
    public Department save(Department department) {
        department = dao.save(department);
        return department;
    }

    @Override
    public Department findDepartmentById(int id) {
        Department department = dao.findDepartmentById(id);
        return department;
    }
}
