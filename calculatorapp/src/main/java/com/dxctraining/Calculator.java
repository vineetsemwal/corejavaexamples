package com.dxctraining;

public class Calculator {

    public int add(int num1, int num2){
        int result= num1+num2;
        return result;
    }

    public int addByTen(int num1){
        int result=add(num1,10);
        return result;
    }

}
