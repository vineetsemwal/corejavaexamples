package com.dxctraining.bootmvcjpa.exceptions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(String msg){
        super(msg);
    }

}
