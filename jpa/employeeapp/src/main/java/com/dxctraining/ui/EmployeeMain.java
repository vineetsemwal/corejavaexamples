package com.dxctraining.ui;

import com.dxctraining.entities.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeMain {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("employee-mgt");

    public static void main(String args[]) {
        EmployeeMain example = new EmployeeMain();
        example.execute();
    }

    public void execute() {
        Employee employee1 = new Employee("vineel", 21, 1000);
        addEmployee(employee1);
        int id1 = employee1.getId();
        Employee employee2 = new Employee("arshad", 22, 2000);
        addEmployee(employee2);
        int id2 = employee2.getId();

        Employee fetchedEmployee = findEmployeeById(id1);
        System.out.println("fetched employee=" + fetchedEmployee.getId() + " " + fetchedEmployee.getName());
        System.out.println("age=" + fetchedEmployee.getAge() + " " + fetchedEmployee.getSalary());


        System.out.println("*************all employees*************");
        displayAllEmployees();


        System.out.println("*****all employees by name arshad *****************");

        displayEmployeesByName("arshad");


        System.out.println("*********deleteing employee***********");

        deleteEmployee(id1);
        System.out.println("record deleted , id="+id1);


    }

    public void deleteEmployee(int id){
        EntityManager entityManager=emf.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        Employee employee=entityManager.find(Employee.class,id);
        entityManager.remove(employee);
        transaction.commit();
        entityManager.close();
    }

    public Employee findEmployeeById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
    }



    public void displayAllEmployees() {
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Employee>query = entityManager.createQuery("from Employee",Employee.class);
        List<Employee>list =query.getResultList();
        for (Employee employee:list){
            System.out.println("fetched employee=" + employee.getId() + " " + employee.getName());
            System.out.println("age=" + employee.getAge() + " " + employee.getSalary());
        }
        entityManager.close();
    }



    public void displayEmployeesByName(String empName) {
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Employee>query = entityManager.createQuery("from Employee where name=:ename",Employee.class);
        query.setParameter("ename",empName);
        List<Employee>list =query.getResultList();
        for (Employee employee:list){
            System.out.println("fetched employee=" + employee.getId() + " " + employee.getName());
            System.out.println("age=" + employee.getAge() + " " + employee.getSalary());
        }
        entityManager.close();
    }



    public void addEmployee(Employee employee) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
        entityManager.close();
    }


}
