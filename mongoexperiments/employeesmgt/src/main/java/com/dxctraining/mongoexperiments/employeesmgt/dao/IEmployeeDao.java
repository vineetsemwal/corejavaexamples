package com.dxctraining.mongoexperiments.employeesmgt.dao;


import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IEmployeeDao extends MongoRepository<Employee, String> {

    List<Employee> findByAge(int age);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String firstName);

    @Query("{ $and : [  {firstName: ?0 } , { lastName : ?1}   ]  }")
    List<Employee> findByFullName(String firstName, String lastName);
}
