package overridedemo;

public class UI {

	public static void main(String args[]) {
		//
		// overriding is runtime polymorphism
		// memory allocation+ object creation happens at runtime 
		//
		//
		Vehicle car=new Car("c11");
		Vehicle bike=new Bike("b11");
		Vehicle vehicles[]=new Vehicle[2];
		vehicles[0]=car;
		vehicles[1]=bike;
		for(Vehicle vehicle:vehicles) {
		String number=vehicle.getNumberPlate();
		vehicle.move();
		System.out.println("vehicle number="+number);
		}
	
	}
	
}
