package com.dxctraining.developer.entities;

import com.dxctraining.employee.entities.Employee;

import javax.persistence.Entity;

@Entity
public class Developer extends Employee {

    private String language;

    public Developer(){}

    public Developer(String name, int age, double salary,String language){
        super(name, age, salary);
        this.language=language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer that = (Developer) o;
        return that.getId()==this.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
