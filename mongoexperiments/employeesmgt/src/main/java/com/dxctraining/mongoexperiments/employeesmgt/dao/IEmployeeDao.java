package com.dxctraining.mongoexperiments.employeesmgt.dao;


import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEmployeeDao extends MongoRepository<Employee, String> {
}
