package overridedemo;

abstract public class Vehicle {


	private String numberPlate;
	
	public Vehicle(String numberPlate) {
		this.numberPlate=numberPlate;
	}
 	
	public String getNumberPlate() {
		return numberPlate;
	}
	
	
/**
 * at the time of implementing vehicle class, we know that a vehicle should move
 * but we don't have complete information about how it should move,
 *  it can move like a bike or a car or anything else	
 */
  public abstract void move() ;
  
  
  
	
}
