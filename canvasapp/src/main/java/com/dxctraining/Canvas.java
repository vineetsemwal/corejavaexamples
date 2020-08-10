package com.dxctraining;

public class Canvas {

	private Shape shape;

	public Canvas(Shape shape) {
		this.shape = shape;
	}

	public Canvas() {
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}

	public void draw() {
		double area = shape.area();
		System.out.println("area=" + area);
	}

}
