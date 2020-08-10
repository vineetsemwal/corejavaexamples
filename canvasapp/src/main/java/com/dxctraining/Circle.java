package com.dxctraining;

import org.springframework.stereotype.Component;

/**
 * @Component will inform spring to create object of this class and store in container
 */
@Component
public class Circle implements Shape{
	
	private int radius;
	
	public Circle(int radius) {
		this.radius=radius;
	}

	public Circle(){

	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return 3.14*radius*radius;
	}

	
}
