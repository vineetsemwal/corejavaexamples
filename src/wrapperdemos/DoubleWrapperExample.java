package wrapperdemos;

public class DoubleWrapperExample {

	public static void main(String[]args) {
	Double wrapper=new Double(10.2);
	double convertedToPrimitive=wrapper.doubleValue();
    wrapper=11.3;
    // wrapper=new Double(11.3);
    
    double primitive=10.2;
    primitive=new Double(12.2);
    // primitive= doubleObject.doubleValue()
    
       
    
    
	}
	
}
