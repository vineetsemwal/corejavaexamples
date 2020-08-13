package com.dxctraining.employee.entities;

import com.dxctraining.address.entities.Address;

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

    @ManyToOne
    private Address address;

    public Employee() {

    }

    public Employee(String name, int age, double salary,Address address) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.address=address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
