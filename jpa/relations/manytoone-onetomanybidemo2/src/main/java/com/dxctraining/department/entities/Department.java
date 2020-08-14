package com.dxctraining.department.entities;

import com.dxctraining.employee.entities.Employee;

import javax.persistence.*;
import java.util.Set;

@Table(name = "departments")
@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;

    private String name, company;


    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    public Department(){}

    public Department(String name, String compnany){
        this.name=name;
        this.company=compnany;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return that.id==this.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
