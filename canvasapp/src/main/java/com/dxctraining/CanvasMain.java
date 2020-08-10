package com.dxctraining;

public class CanvasMain {

	public static void main(String args[]) {
		Rectangle rectangle=new Rectangle(5,5);
		Circle circle=new Circle(3);
		Canvas canvas=new Canvas();
		canvas.setShape(circle);
	    canvas.draw();	
	}
	
}
