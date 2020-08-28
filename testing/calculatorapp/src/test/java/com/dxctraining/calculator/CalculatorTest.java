package com.dxctraining.calculator;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;


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
        adder = Mockito.mock(Adder.class);
        calculator = new Calculator(adder);
    }

    @AfterEach
    public void clear() {
        System.out.println("inside clear");
        calculator = null;
    }

/*
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
    */

    @Test
    public void testAddByTen_1() {
        System.out.println("inside testAddByTen_1");
        Mockito.when(adder.add(5, 10)).thenReturn(15);
        int result = calculator.addByTen(5);
        Assertions.assertEquals(15, result);
        Mockito.verify(adder).add(5,10);
    }


}
