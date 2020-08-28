package com.dxctraining.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdderTest {
    Adder adder;

    @BeforeEach
    public void configure(){
        adder=new Adder();
    }

    @Test
    public void testAdd_1() {
        System.out.println("inside testAdd_1");
        int result = adder.add(2, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testAdd_2() {
        System.out.println("inside testAdd_2");
        int result = adder.add(-3, -5);
        Assertions.assertEquals(-8, result);
    }

}
