package overridedemo;

public class Bike extends Vehicle{
	
	public Bike(String numberPlate) {
		super(numberPlate);
	}

	@Override
	public void move() {
		System.out.println("bike moves");
	}
	
}
