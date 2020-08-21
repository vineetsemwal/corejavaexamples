package com.dxctraining.deptmgt.exceptions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String msg){
        super(msg);
    }

}
