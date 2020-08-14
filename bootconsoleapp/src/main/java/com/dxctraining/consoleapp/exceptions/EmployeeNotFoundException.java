package com.dxctraining.consoleapp.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String msg){
        super(msg);
    }

}
