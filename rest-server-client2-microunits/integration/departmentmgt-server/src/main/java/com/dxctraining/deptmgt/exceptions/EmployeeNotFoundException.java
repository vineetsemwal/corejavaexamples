package com.dxctraining.deptmgt.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String msg){
        super(msg);
    }

}
