package com.dxctraining.mongoexperiments.employeesmgt;

import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import com.dxctraining.mongoexperiments.employeesmgt.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UI {
    @Autowired
    private IEmployeeService service;


    @PostConstruct
    public void start() {
        Employee employee1 = new Employee("ankit", "kahar", 21);
        employee1 = createEmployee(employee1);
        String id1 = employee1.getId();
        Employee employee2 = new Employee("kashish", "singh", 22);
        employee2 = createEmployee(employee2);

        Employee employee3 = new Employee("roop", "sai", 22);
        employee3 = createEmployee(employee3);

        String id2 = employee2.getId();
        displayEmployeeById(id1);
        displayEmployeeById(id2);
        displayByAge(21);
        displayAll();

        displayByFullName("kashish", "singh");

    }

    void displayAll(){
      System.out.println("********displayAll");
      List<Employee>list=  service.findAll();
      for (Employee employee:list){
          displayEmployee(employee);
      }
    }

    void displayByAge(int age) {
        System.out.println("*****displayByAge");
        List<Employee> list = service.findByAge(age);
        for (Employee employee : list) {
            displayEmployee(employee);
        }
    }

    void displayEmployee(Employee employee) {
        System.out.println(employee.getId() +
                " name=" + employee.getFirstName() +" "+employee.getLastName()+ " age=" + employee.getAge());

    }

    public void displayEmployeeById(String id) {
        System.out.println("*****displayEmployeeById");
        Employee employee = service.findById(id);
        displayEmployee(employee);
    }


    public Employee createEmployee(Employee employee) {
        System.out.println("*********createmployee");
        employee = service.save(employee);
        displayEmployee(employee);
        return employee;
    }

    public void displayByFullName(String firstName, String lastName){
       System.out.println("**********inside displayByFullName");
       List<Employee>list= service.findByFullName(firstName, lastName);
       for (Employee employee:list){
           displayEmployee(employee);
       }
    }

}
