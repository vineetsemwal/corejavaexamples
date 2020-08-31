package com.dxctraining.mongoexperiments.employeesmgt.dao;


import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IEmployeeDao extends MongoRepository<Employee, String> {

    List<Employee> findByAge(int age);

}
