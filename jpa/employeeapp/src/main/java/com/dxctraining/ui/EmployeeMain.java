package com.dxctraining.ui;

import com.dxctraining.entities.Employee;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class EmployeeMain {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee-mgt");

    public static void main(String args[]) {
        EmployeeMain example = new EmployeeMain();
        example.execute();
    }

    public void execute() {
        Employee employee1 = new Employee("vineel", 21, 1000);
        employee1 = addEmployee(employee1);
        int id1 = employee1.getId();
        Employee employee2 = new Employee("arshad", 22, 2000);
        employee2 = addEmployee(employee2);

        Employee fetchedEmployee = findEmployeeById(id1);
        System.out.println("fetched employee=" + fetchedEmployee.getId() + " " + fetchedEmployee.getName());
        System.out.println("age=" + fetchedEmployee.getAge() + " " + fetchedEmployee.getSalary());


        Employee updated = updateEmployee(id1, "dharma", 8000);

        System.out.println("updated employee=" + updated.getName());

        System.out.println("*************all employees*************");
        displayAllEmployees();


        System.out.println("*****all employees by name arshad *****************");

        displayEmployeesByName("arshad");


        System.out.println("*********deleteing employee***********");

        //  deleteEmployee(id1);
        // System.out.println("record deleted , id="+id1);

        emf.close();

    }

    public void deleteEmployee(int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();
    }

    public Employee findEmployeeById(int id) {
        System.out.println("inside find,id=" + id);
        EntityManager entityManager = emf.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }


    public void displayAllEmployees() {
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> list = query.getResultList();
        for (Employee employee : list) {
            System.out.println("fetched employee=" + employee.getId() + " " + employee.getName());
            System.out.println("age=" + employee.getAge() + " " + employee.getSalary());
        }
        entityManager.close();
    }


    public void displayEmployeesByName(String empName) {
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Employee> query = entityManager.createQuery("from Employee where name=:ename", Employee.class);
        query.setParameter("ename", empName);
        List<Employee> list = query.getResultList();
        for (Employee employee : list) {
            System.out.println("fetched employee=" + employee.getId() + " " + employee.getName());
            System.out.println("age=" + employee.getAge() + " " + employee.getSalary());
        }
        entityManager.close();
    }


    public Employee addEmployee(Employee employee) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //will insert because id in employee object doesnt exist in any record of table
        employee = entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
        return employee;
    }



    public Employee updateEmployee(int id, String newName, double newSalary) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        employee.setName(newName);
        employee.setSalary(newSalary);
        //will update because id in employee object exists in one of the record in table
        employee = entityManager.merge(employee);
        transaction.commit();
        entityManager.close();
        return employee;
    }


}
