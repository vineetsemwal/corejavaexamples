package overridedemo;

public class UI {

	public static void main(String args[]) {
		//
		// overriding is runtime polymorphism
		// memory allocation+ object creation happens at runtime 
		//
		//
		Vehicle car=new Car("c11");
		car.move();
		String carNumber=car.getNumberPlate();
		System.out.println("car number="+carNumber);
	
		Vehicle bike=new Bike("b11");
		bike.move();
		String bikeNumber=bike.getNumberPlate();
		System.out.println("bike number="+bikeNumber);
	
	}
	
}
