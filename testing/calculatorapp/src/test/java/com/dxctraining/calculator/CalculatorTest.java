package com.dxctraining.calculator;

import org.junit.jupiter.api.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void init() {
        System.out.println("inside init");
        calculator = new Calculator();
    }

    @AfterEach
    public void  clear(){
        System.out.println("inside clear");
        calculator=null;
    }


    @Test
    public void testAdd_1() {
        System.out.println("inside testAdd_1");
        int result = calculator.add(2, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testAdd_2() {
        System.out.println("inside testAdd_2");
        int result = calculator.add(-3, -5);
        Assertions.assertEquals(-8, result);
    }


}
