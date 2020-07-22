
/**
 * 
 * int , Integer  
  long,  Long
  float, Float
  double, Double
  boolean, Boolean

 */
public class IntegerWrapperExample {

	public static void main(String args[]) {				
		// int is primitive type
		int i1=10;		// 4 byte , 32 bits
		// Integer is wrapper class, advantage of wrapper class is we can reuse 
		// predefined methods available in the Integer class
		Integer i2=new Integer(10); 
		int primitivei2=i2.intValue();
		byte b=i2.byteValue();// -128 to 127
		String str=i2.toString();// "10"
		double doubleValue=i2.doubleValue();//10.00
		float floatValue=i2.floatValue();// 10.00
		long longValue=i2.longValue();// 8 bytes, 64 bits
		
		System.out.println("integer="+i2);
		System.out.println("string="+str);
		System.out.println("double="+doubleValue);	
		
	}
	
}
