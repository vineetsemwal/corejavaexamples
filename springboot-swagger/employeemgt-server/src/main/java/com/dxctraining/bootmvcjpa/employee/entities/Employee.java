package com.dxctraining.bootmvcjpa.employee.entities;


import javax.persistence.*;

@Entity
@Table(name = "employees")//table name
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    private String firstName,lastName;


    public Employee() {

    }

    public Employee(String firstName, String lastName) {
         this.firstName=firstName;
         this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
