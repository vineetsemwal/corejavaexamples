package com.dxctraining.bootmvcjpa.employee.entities;

import com.dxctraining.bootmvcjpa.department.entities.Department;

import javax.persistence.*;

@Entity
@Table(name = "employees")//table name
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private double salary;

    private int age;

    private String password;

    @ManyToOne
    private Department department;


    public Employee() {

    }

    public Employee(String name,String password, Department department ,int age, double salary) {
        this.name = name;
        this.password=password;
        this.salary = salary;
        this.age = age;
        this.department=department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee that = (Employee) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
