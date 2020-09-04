package com.dxctraining.oninevideo.usermgt.dto;

public class CreateUserRequest {
    private String name,interest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
