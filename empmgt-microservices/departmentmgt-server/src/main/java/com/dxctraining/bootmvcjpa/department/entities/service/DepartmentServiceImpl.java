package com.dxctraining.bootmvcjpa.department.entities.service;

import com.dxctraining.bootmvcjpa.department.entities.Department;
import com.dxctraining.bootmvcjpa.department.entities.dao.IDepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@Service
public class DepartmentServiceImpl implements IDepartmentService {

   @Autowired
    private IDepartmentDao dao;

    @Override
    public Department findById(int id) {
        Department department=dao.findById(id);
        return department;
    }

    @Override
    public Department save(Department department) {
        department=dao.save(department);
        return department;
    }

}
