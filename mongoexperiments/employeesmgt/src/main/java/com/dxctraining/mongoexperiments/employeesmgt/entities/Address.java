package com.dxctraining.mongoexperiments.employeesmgt.entities;

public class Address {
    private String city, houseNo;

    public Address(){

    }

    public Address(String city,String houseNo){
        this.city=city;
        this.houseNo=houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
}
