package com.dxctraining.deptmgt.department.controllers;

import com.dxctraining.deptmgt.department.dto.DepartmentDto;
import com.dxctraining.deptmgt.department.entities.Department;
import com.dxctraining.deptmgt.exceptions.DepartmentNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
public class DepartmentControllerTest {

    @Autowired
    private DepartmentController controller;

    @Autowired
    private EntityManager entityManager;


    /**
     * case/scenario : department exists in the store
     * precondition: department is added to the store
     * verifying: getDepartment() returns departmentDto which contains details of department that we have saved before
     */
    @Test
    public void testGetDepartment_ById_1() {
        String deptName = "dev";
        Department department = new Department();
        department.setName(deptName);
        department = entityManager.merge(department);
        int deptId = department.getId();
        DepartmentDto result = controller.getDepartment(deptId);
        Assertions.assertEquals(deptName, result.getName());
        Assertions.assertEquals(deptId, result.getId());

        TypedQuery<Department> query = entityManager.createQuery("from Department", Department.class);
        List<Department> stored = query.getResultList();
        Assertions.assertEquals(1, stored.size());
        Department storedDepartment = stored.get(0);
        Assertions.assertEquals(deptName, storedDepartment.getName());
        Assertions.assertEquals(result.getId(), storedDepartment.getId());
    }

    /**
     * case/scenario: department doesn't exist in store
     * verifying: DepartmentNotFoundException is thrown
     */
    @Test
    public void testGetDepartment_ById_2(){
        Executable execute=()->controller.getDepartment(23);
        Assertions.assertThrows(DepartmentNotFoundException.class,execute);
    }


}
