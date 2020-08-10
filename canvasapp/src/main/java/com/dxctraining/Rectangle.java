package com.dxctraining;

public class Rectangle implements Shape{

	private int length, breadth;
		
	public Rectangle(int length, int breadth) {
		this.length=length;
		this.breadth=breadth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	@Override
	public double area() {
		return length*breadth;
	}
	
}
