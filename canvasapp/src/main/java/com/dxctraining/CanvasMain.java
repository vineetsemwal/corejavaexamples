package com.dxctraining;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  Dependency injection is done in 2 steps by spring
 *
 *  1) scan for bean/component classes
 *  2) inject the dependency
 *
 */
public class CanvasMain {

	public static void main(String args[]) {
		// ApplicationContext is the container
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(JavaConfig.class);// registering configuration class
		context.refresh();// now spring will scan and hold the bean classes objects + DI will also be done
		Canvas canvas =context.getBean(Canvas.class);
		Shape shape=context.getBean(Shape.class);
		boolean isCircle=shape instanceof Circle;
		System.out.println("shape is circle="+isCircle);
		canvas.draw();
	}
	
}
