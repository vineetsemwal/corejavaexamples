package com.dxctraining.hotelmgt.customermgt.dto;

import javax.validation.constraints.NotBlank;

public class CreateCustomer {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
