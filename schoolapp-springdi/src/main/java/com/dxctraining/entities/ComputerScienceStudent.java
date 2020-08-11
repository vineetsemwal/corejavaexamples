package com.dxctraining.entities;

/**
 * 
 * things that can be done with super keyword
 * 1) you can address members(fields + methods)
 * 2) you can call constructor of immediate base class
 *
 */
public class ComputerScienceStudent extends Student {

	private String laptopAlloted;

	public ComputerScienceStudent(String name, int age, boolean placed, 
			String laptopAlloted, Course course) {
		//super with round bracket means we are calling base class constructor
		super(name, age, placed, course);
		this.laptopAlloted = laptopAlloted;
	}
	

	public String getLaptopAlloted() {
		return laptopAlloted;
	}

	public void setLaptopAlloted(String laptopAlloted) {
		this.laptopAlloted = laptopAlloted;
	}
	
	/**
	 * annotations are metadata, data about data, information about data
	 * override annotation is informing compiler that we are overriding a base class method
	 * if we dont use override annotation then if we are not overriding , 
	 * compiler will not inform us that we are not overriding
	 */
	@Override
	public void setAge(int age) {
		if(age>17) {
			super.setAge(age);
		}
	}
		

}
