package com.dxctraining.calculator;

public class Calculator {

    private Adder adder;

    public Calculator(Adder adder){
        this.adder=adder;
    }

    public int addByTen(int num1){
        System.out.println("inside add by ten , num="+num1);
        int result=adder.add(num1,10);
        return result;
    }

}
