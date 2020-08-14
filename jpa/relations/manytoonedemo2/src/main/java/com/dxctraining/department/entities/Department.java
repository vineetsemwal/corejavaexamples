package com.dxctraining.department.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "departments")
@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;

    public Department(){}

    private String name;

    private String company;

    public Department(String name, String company){
        this.name=name;
        this.company=company;
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
