package com.dxctraining.usermgt.entities;


import javax.persistence.*;

@Entity
@Table(name = "employees")//table name
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private double salary;

    private int age;

    public User() {

    }

    public User(String name,  int age, double salary) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User that = (User) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
