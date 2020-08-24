package com.dxctraining.deptmgt.department.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "departments")
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private double rating;

    public Department(){

    }

    public Department(String name, double rating){
        this.name=name;
        this.rating=rating;
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

    public void setRating(double rating){
        this.rating=rating;
    }

    public double getRating(){
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}
