package com.dxctraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * @Component will inform spring to create object of this class and store in container
 */
@Component
public class Canvas {

	private Shape shape;

	@Autowired
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return shape;
	}


	public Canvas(Shape shape){
	 this.shape=shape;
	}


	public Canvas(){
	}

	public void draw() {
		double area = shape.area();
		System.out.println("area=" + area);
	}

}
