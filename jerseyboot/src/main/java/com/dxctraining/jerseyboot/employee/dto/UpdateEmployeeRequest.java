package com.dxctraining.jerseyboot.employee.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateEmployeeRequest {

    private int id;

    @Size(min = 2)
    @NotBlank
    private String name;

    private double salary;

    private int age;

    private String password;

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
}
