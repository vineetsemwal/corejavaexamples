package overridedemo;

public class Car extends Vehicle{

	
	public Car(String numberPlate) {
		super(numberPlate);
	}
	
	/**
	 * For overriding there are 2 conditions
	 * 1) the signature of method in Subclass has to be exactly same as base class
	 * 2) We can't reduce the access, either access has to be same or
	 *  we can widen/increase it
	 */
	@Override
	 public void move() {
	 System.out.println("car moves");	
	}
}
