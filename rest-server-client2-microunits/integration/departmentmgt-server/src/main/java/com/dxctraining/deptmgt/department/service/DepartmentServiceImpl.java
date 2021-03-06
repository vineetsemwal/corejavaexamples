package com.dxctraining.deptmgt.department.service;

import com.dxctraining.deptmgt.department.entities.Department;
import com.dxctraining.deptmgt.department.dao.IDepartmentDao;
import com.dxctraining.deptmgt.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DepartmentServiceImpl implements IDepartmentService {

   @Autowired
    private IDepartmentDao dao;

    @Override
    public Department findById(int id) {
        System.out.println("**********inside service's findById(), id="+id);
        Department department=dao.findById(id);
        return department;
    }

    @Override
    public Department save(Department department) {
        validateDepartment(department);
        department=dao.save(department);
        return department;
    }

    @Override
    public Department findByName(String name){
      Department department=  dao.findByName(name);
      return department;
    }

    public void validateDepartment(Department department){
        if(department==null){
            throw new InvalidArgumentException("department can't be null");
        }
    }

}
