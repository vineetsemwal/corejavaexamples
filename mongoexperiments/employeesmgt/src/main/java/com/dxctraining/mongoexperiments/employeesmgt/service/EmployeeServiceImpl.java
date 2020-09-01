package com.dxctraining.mongoexperiments.employeesmgt.service;

import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private MongoTemplate mongo;

    @Override
    public Employee save(Employee employee) {
        System.out.println("using mongotemplate save");
        employee = mongo.save(employee);//works like jpa merge
        return employee;
    }

    @Override
    public Employee findById(String id) {
        Employee employee = mongo.findById(id, Employee.class);
        return employee;
    }

    @Override
    public void removeById(String id) {
        Employee employee=findById(id);
        mongo.remove(employee);
        /*
        Criteria criteria=Criteria.where("id").is(id);
        Query query=Query.query(criteria);
        mongo.findAndRemove(query,Employee.class);
       */
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = mongo.findAll(Employee.class);
        return list;
    }

    @Override
    public List<Employee> findByAge(int age) {
        Criteria criteria=Criteria.where("age").is(age);
        Query query = Query.query(criteria);
        List<Employee> list = mongo.find(query, Employee.class);
        return list;
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        Criteria criteria=Criteria.where("firstName").is(firstName) ;
        Query query = Query.query(criteria);
        List<Employee> list = mongo.find(query, Employee.class);
        return list;
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        Criteria criteria=Criteria.where("lastName").is(lastName) ;
        Query query = Query.query(criteria);
        List<Employee> list = mongo.find(query, Employee.class);
        return list;
    }

    @Override
    public List<Employee> findByFullName(String firstName, String lastName) {
        /*
        Criteria criteria1=Criteria.where("firstName").is(firstName);
        Criteria criteria2=Criteria.where("lastName").is(lastName);
        Criteria criteria=criteria1.andOperator(criteria2) ;
        */
        Criteria criteria=Criteria.where("firstName").is(firstName).
                andOperator(Criteria.where("lastName").is(lastName));
        Query query = Query.query(criteria);
        List<Employee> list = mongo.find(query, Employee.class);
        return list;
    }
}
