package com.dxctraining.ui;

import com.dxctraining.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        System.out.print("age=" + fetchedEmployee.getAge() + " " + fetchedEmployee.getSalary());

    }


    public Employee findEmployeeById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        return employee;
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
