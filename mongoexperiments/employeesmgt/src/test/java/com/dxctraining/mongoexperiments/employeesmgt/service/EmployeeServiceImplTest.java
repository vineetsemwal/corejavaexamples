package com.dxctraining.mongoexperiments.employeesmgt.service;

import com.dxctraining.mongoexperiments.employeesmgt.entities.Address;
import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@DataMongoTest
@Import(EmployeeRepositoryServiceImpl.class)
public class EmployeeServiceImplTest {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private MongoTemplate mongo;

    /**
     * case : employee successfully added
     * precondition: employee doesn't exist before
     * verifying: stored employee contains expected details
     */
    @Test
    public void testSave_1(){
        String firstName="prakash",lastName="s";
        int age=21;
        String city="chennai", houseNo="c-1";
        Address address1=new Address(city, houseNo);
        Employee employee1=new Employee(firstName,lastName,age,address1);
        employee1=employeeService.save(employee1);
        String id=employee1.getId();
        Employee fetched=mongo.findById(id,Employee.class);
        Assertions.assertEquals(employee1.getId(),fetched.getId());
        Assertions.assertEquals(firstName,employee1.getFirstName());
        Assertions.assertEquals(lastName, employee1.getLastName());
        Assertions.assertEquals(age,employee1.getAge());
    }

    /**
     * case: employee exists in store,
     * precondition:employee added in store
     * verifying: fetched employee has same details as stored employee
     */
    @Test
    public void findById_2(){
        String firstName="prakash",lastName="s";
        int age=21;
        String city="chennai", houseNo="c-1";
        Address address1=new Address(city, houseNo);
        Employee employee1=new Employee(firstName,lastName,age,address1);
        employee1=mongo.save(employee1);
        Employee fetched=employeeService.findById(employee1.getId());
        Assertions.assertEquals(firstName, fetched.getFirstName());
        Assertions.assertEquals(lastName,fetched.getLastName());
        Assertions.assertEquals(employee1.getId(),fetched.getId());
        Assertions.assertEquals(age, fetched.getAge());

    }


}
