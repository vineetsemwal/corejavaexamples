package com.dxctraining;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd_1() {
		Calculator calcy=new Calculator();
		int actual=calcy.add(1, 2);
		Assertions.assertEquals(3,actual);
	}
	
	@Test
	void testAdd_2() {
		Calculator calcy=new Calculator();
		int actual=calcy.add(-3, -4);
		Assertions.assertEquals(-7,actual);
	}

}
