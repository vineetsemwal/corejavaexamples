package com.dxctraining.deptmgt.department.dto;

public class DepartmentDto {
    private Integer id;

    private String name;

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

    private double rating;

    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating=rating;
    }
}
