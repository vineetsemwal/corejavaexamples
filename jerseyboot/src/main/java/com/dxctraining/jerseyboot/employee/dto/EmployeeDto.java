package com.dxctraining.jerseyboot.employee.dto;

public class EmployeeDto {

    private int id;

    private String name;

    private double salary;

    private int age;

    private String password;

    public EmployeeDto(){

    }

    public EmployeeDto(int id, String name, String password,double salary,int age){
        this.id=id;
        this.name=name;
        this.password=password;
        this.salary=salary;
        this.age=age;
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

}
