package com.dxctraining.mongoexperiments.employeesmgt;

import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import com.dxctraining.mongoexperiments.employeesmgt.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UI {
    @Autowired
    private IEmployeeService service;


     @PostConstruct
    public void start(){
         Employee employee1=new Employee("ankit",21);
         employee1=createEmployee(employee1);
         String id1=employee1.getId();
         Employee employee2=new Employee("kashish",22);
         employee2=createEmployee(employee2);
         String id2=employee2.getId();
         displayEmployeeById(id1);
         displayEmployeeById(id2);
     }

     public void displayEmployeeById(String id){
       Employee employee=  service.findById(id);
         System.out.println("****employee found id="+employee.getId()+
                 " name="+employee.getName()+" age="+employee.getAge());

     }


    public Employee createEmployee(Employee employee){
        employee=service.save(employee);
        System.out.println("****employee created id="+employee.getId()+
                " name="+employee.getName()+" age="+employee.getAge());
       return employee;
     }

}
