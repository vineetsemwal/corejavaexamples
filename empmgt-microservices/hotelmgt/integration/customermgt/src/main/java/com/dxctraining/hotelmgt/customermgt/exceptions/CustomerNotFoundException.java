package com.dxctraining.hotelmgt.customermgt.exceptions;

public class CustomerNotFoundException extends RuntimeException{

    private String msg;

    public CustomerNotFoundException(String msg){
        super(msg);
    }

}
