package calculatordemo;
/**
 * 
 *  1) Fields ,values represents state of object
 *  2) Functions represents functionality
 * 
 * We have created blueprint/design of Calculator
 * 
 *  A used defined Class is a used defined data type
 */
public class Calculator {	
	
	private int integerResult;
	
	public int getIntegerResult() {
		return integerResult;
	}
	
	
	/**
	 * 
	 * compiler will know these three methods are different from number of args or type of args
	 */
	public int add(int num1, int num2) {		
	   int 	result=num1+num2; 
	   return result;
	}
	
	/// Calculator c=new Calculator();
	// int op=c.add(1,2,3);
	public int add(int num1, int num2, int num3) {
	  int result= this.add(num1,num2); 
	  result=result+num3;
	  return result;
	}
	

	public double add(double num1, double num2) {		
	   double result=num1+num2; 
	   return result;
	}
	
	public String add(String arg1, String arg2) {
		String result=arg1+arg2;
		return result;
	}
	
}
