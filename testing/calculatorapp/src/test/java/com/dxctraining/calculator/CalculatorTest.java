package com.dxctraining.calculator;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;


class CalculatorTest {

    Calculator calculator;

    Adder adder;

    @BeforeAll
    public static void initBeforeAll() {
        System.out.println("inside before all");
    }

    @BeforeEach
    public void init() {
        System.out.println("inside init");
        //creating mock object of type Adder
        adder = Mockito.mock(Adder.class);
        calculator = new Calculator(adder);
    }

    @AfterEach
    public void clear() {
        System.out.println("inside clear");
        calculator = null;
    }


    @Test
    public void testAddByTen_1() {
        System.out.println("inside testAddByTen_1");
        // providing stubbing/mock_implementation of add method
        Mockito.when(adder.add(5, 10)).thenReturn(15);
        int result = calculator.addByTen(5);
        Assertions.assertEquals(15, result);
        //verifying add method is called Once with arguments 5 and 10
        Mockito.verify(adder).add(5,10);
    }

    @Test
    public void testMultiplyByTwo_1(){
       Calculator spy =Mockito.spy(calculator);
       Mockito.doReturn(10).when(spy).multiply(5,2);
       int result=spy.multiplyByTwo(5);
       Assertions.assertEquals(10,result);
       Mockito.verify(spy).multiply(5,2);
    }


}
