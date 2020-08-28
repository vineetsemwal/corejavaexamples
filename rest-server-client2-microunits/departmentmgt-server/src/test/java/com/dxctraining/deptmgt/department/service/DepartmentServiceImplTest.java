package com.dxctraining.deptmgt.department.service;


import com.dxctraining.deptmgt.department.dao.DepartmentDaoImpl;
import com.dxctraining.deptmgt.department.entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.dxctraining.deptmgt.exceptions.DepartmentNotFoundException;
import com.dxctraining.deptmgt.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import({DepartmentServiceImpl.class, DepartmentDaoImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DepartmentServiceImplTest {

    @Autowired
    private IDepartmentService service;

    @Autowired
    private EntityManager entityManager;

    /**
     * case/scenario: department does NOT exist in the store
     * verifying: DepartmentNotFoundException is thrown
     */
    @Test
    public void testFindById_1() {
     /*
       Executable executable=new Executable() {
         @Override
         public void execute() throws Throwable {
             service.findById(768);
         }
     };
     */
        Executable executable = () -> service.findById(768);
        Assertions.assertThrows(DepartmentNotFoundException.class, executable);

    }

    /**
     * case/scenario : department exists in the store
     * precondition: department is added to the store
     * verifying: findById() returns department which was added to the store
     */
    @Test
    public void testFindById_2() {
        System.out.println("entity manager=" + entityManager);
        Department department = new Department();
        department.setName("dev");
        department = entityManager.merge(department);
        int deptId = department.getId();
        Department result = service.findById(deptId);
        Assertions.assertEquals(deptId, result.getId());
        Assertions.assertEquals(department.getName(), result.getName());
    }

    /**
     * scenario : department doesn't exist in the store previously
     * verifying: data saved in the database after save method is expected
     */
    @Test
    public void testSave_1() {
        String deptName = "testing";
        Department department = new Department();
        department.setName(deptName);
        Department result = service.save(department);
        Assertions.assertEquals(deptName, result.getName());
        TypedQuery<Department>query=entityManager.createQuery("from Department", Department.class);
        List<Department>stored=query.getResultList();
        Assertions.assertEquals(1,stored.size());
        Department storedDepartment=stored.get(0);
        Assertions.assertEquals(deptName,storedDepartment.getName());
        Assertions.assertEquals(result.getId(),storedDepartment.getId());
    }

    /**
     * scenario : null is passed as department
     * verifying: InvalidArgumentException is thrown
     */
    @Test
    public void testSave_2(){
        /*
        Executable executable=new Executable() {
            @Override
            public void execute() throws Throwable {
                service.save(null);
            }
        };
        */
        Executable executable=()->service.save(null);
        Assertions.assertThrows(InvalidArgumentException.class, executable);
    }

}
