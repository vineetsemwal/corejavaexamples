package com.dxctraining.usermgt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEmployeeNotFound(UserNotFoundException e){
        System.out.println("inside handleUserNotFound");
        String msg=e.getMessage();
        return msg;
    }

    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidArgument(InvalidArgumentException e){
        System.out.println("inside handleInvalidArgument");
        return e.getMessage();
    }
}
