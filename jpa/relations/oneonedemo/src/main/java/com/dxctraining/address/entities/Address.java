package com.dxctraining.address.entities;

import com.dxctraining.employee.entities.Employee;

import javax.persistence.*;

@Table(name = "addresses")
@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String city;

    private String houseAddress;

    public Address(){}


    public Address(String city,String house){
        this.city=city;
        this.houseAddress=house;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return that.id==this.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
