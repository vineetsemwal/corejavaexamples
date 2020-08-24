package com.dxctraining.deptmgt.department.dto;

public class CreateDepartmentRequest {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double rating;

    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating=rating;
    }


}
