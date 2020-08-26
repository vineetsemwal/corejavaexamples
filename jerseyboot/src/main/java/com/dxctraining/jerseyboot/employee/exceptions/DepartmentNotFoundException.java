package com.dxctraining.jerseyboot.employee.exceptions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String msg){
        super(msg);
    }

}
