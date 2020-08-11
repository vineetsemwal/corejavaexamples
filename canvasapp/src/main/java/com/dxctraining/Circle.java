package com.dxctraining;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Component will inform spring to create object of this class and store in container
 */

public class Circle implements Shape{

	@Value("${circle.radius}")
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
