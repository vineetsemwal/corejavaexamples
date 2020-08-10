package com.dxctraining;

import org.junit.jupiter.api.*;

class CalculatorTest {

	Calculator calcy;
	
	@BeforeEach
	public void init() {
    System.out.println("inside init");
	  calcy=new Calculator();	
	}
	
	@AfterEach
	public void clear() {
	    System.out.println("inside clear");
	    calcy=null;
	}
	
	@Test
	void testAdd_1() {
		System.out.println("inside testAdd_1");
		int actual=calcy.add(1, 2);
		Assertions.assertEquals(3,actual);
	}
	
	@Test
	void testAdd_2() {
		System.out.println("inside testAdd_2");
		int actual=calcy.add(-3, -4);
		Assertions.assertEquals(-7,actual);
	}

	
	@Test
	public void testAddByTen_1() {
		System.out.println("inside testAddByTen_1");
		int actual=calcy.addByTen(2);		
		Assertions.assertEquals(12, actual);
		
	}	
	

	@Test
	public void testAddByTen_2() {
		System.out.println("inside testAddByTen_2");
    	int actual=calcy.addByTen(-2);		
		Assertions.assertEquals(8, actual);
		
	}
	
}
