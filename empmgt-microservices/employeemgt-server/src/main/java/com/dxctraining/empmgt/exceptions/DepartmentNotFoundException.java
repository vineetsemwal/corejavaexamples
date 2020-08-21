package com.dxctraining.empmgt.exceptions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String msg){
        super(msg);
    }

}
