package com.dxctraining.tester.entities;

import com.dxctraining.employee.entities.Employee;

import javax.persistence.Entity;

@Entity
public class Tester extends Employee {

    private String testingLibrary;

    public Tester(){

    }
    public Tester(String name, int age, double salary,String testingLibrary){
        super(name, age, salary);
        this.testingLibrary=testingLibrary;
    }

    public String getTestingLibrary(){
        return testingLibrary;
    }

    public void setTestingLibrary(String testingLibrary){
        this.testingLibrary=testingLibrary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tester that = (Tester) o;
        return this.getId()==that.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
